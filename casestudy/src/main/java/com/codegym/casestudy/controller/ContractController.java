package com.codegym.casestudy.controller;


import com.codegym.casestudy.dto.EmployeeDto;
import com.codegym.casestudy.dto.contract_dto.ContractDto;
import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.model.employee.Education;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.employee.Position;
import com.codegym.casestudy.model.service.Service;
import com.codegym.casestudy.service.contract.IContractService;
import com.codegym.casestudy.service.customer.ICustomerService;
import com.codegym.casestudy.service.employee.IEmployeeService;
import com.codegym.casestudy.service.service.IServiceOfServive;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    IContractService iContractService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IServiceOfServive iServiceService;

    @ModelAttribute("employeeList")
    public List<Employee> getEmployeeList(){
        return iEmployeeService.findAll();
    }

    @ModelAttribute("customerList")
    public List<Customer> getCustomerList(){
        return iCustomerService.findAll();
    }

    @ModelAttribute("serviceList")
    public List<Service> getServiceList(){
        return iServiceService.findAll();
    }

    @GetMapping({""})
    public String showList(@PageableDefault(value = 5) Pageable pageable, Model model){

        Page<Contract> contractList = iContractService.findAll(pageable);
        model.addAttribute("contractList", contractList);
        return "contract/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contractDto",new ContractDto());
        return "contract/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute ContractDto contractDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){

        List<Service> serviceList = iServiceService.findAll();

        for (Service service : serviceList) {
            if (contractDto.getService().getServiceName().equals(service.getServiceName())) {
                contractDto.setContractTotalMoney(service.getServiceCost());
            }
        }

        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("contractDto", contractDto);
            return "/contract/create";
        }

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("message", "Added new contract have successfully");
        return "redirect:/contract";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Optional<Integer> id){
        iContractService.removeById(id.get());
        return "redirect:/contract";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Optional<Integer> id, Model model) {
        Contract contract = iContractService.findById(id.get());
        ContractDto contractDto = new ContractDto();
        BeanUtils.copyProperties(contract, contractDto);
        model.addAttribute("contractDto", contractDto);
        return "/contract/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute ContractDto contractDto, BindingResult bindingResult, Model model) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("contractDto", contractDto);
            return "/contract/edit";
        }

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        iContractService.save(contract);
        return "redirect:/contract";
    }


}
