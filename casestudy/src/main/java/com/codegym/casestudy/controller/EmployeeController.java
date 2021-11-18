package com.codegym.casestudy.controller;

import com.codegym.casestudy.dto.EmployeeDto;
import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.model.employee.Education;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.employee.Position;
import com.codegym.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

    @ModelAttribute("positionList")
    public List<Position> getPositionList() {
        return iEmployeeService.findAllPossition();
    }

    @ModelAttribute("divisionList")
    public List<Division> getDivisionList() {
        return iEmployeeService.findAllDivision();
    }

    @ModelAttribute("educationDegreeList")
    public List<Education> getEducationDegreeList() {
        return iEmployeeService.findAllEducationDegree();
    }

    @GetMapping({"", "/search"})
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam Optional<String> name, Model model) {

        String nameValue = "";
        if (name.isPresent()) {
            nameValue = name.get();
        }

        Page<Employee> employeeList = iEmployeeService.searchByName(pageable, nameValue);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("name", nameValue);
        return "employee/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute EmployeeDto employeeDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "/employee/create";
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Added new employee have successfully");
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Optional<Integer> id) {
        iEmployeeService.removeById(id.get());
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Employee employee = iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);

        model.addAttribute("employeeDto", employeeDto);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult, Model model) {

        new EmployeeDto().validate(employeeDto, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("employeeDto", employeeDto);
            return "/employee/edit";
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        iEmployeeService.save(employee);
        return "redirect:/employee";
    }
}


