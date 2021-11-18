package com.codegym.casestudy.controller;

import com.codegym.casestudy.dto.service_dto.ServiceDto;
import com.codegym.casestudy.model.service.RentType;
import com.codegym.casestudy.model.service.Service;
import com.codegym.casestudy.model.service.ServiceType;
import com.codegym.casestudy.service.service.IServiceOfServive;
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
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    IServiceOfServive iServiceService;

    @ModelAttribute("serviceTypeList")
    public List<ServiceType> getServiceType() {
        return iServiceService.findAllServiceType();
    }

    @ModelAttribute("rentTypeList")
    public List<RentType> getRentType() {
        return iServiceService.findAllRentType();
    }

    @GetMapping({"", "/search"})
    public String showList(@PageableDefault(value = 5) Pageable pageable,
                           @RequestParam Optional<String> name, Model model) {

        String nameValue = "";
        if (name.isPresent()) {
            nameValue = name.get();
        }

        Page<Service> serviceList = iServiceService.searchByName(pageable, nameValue);
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("name", nameValue);
        return "service/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        return "service/create";
    }

    @PostMapping("/create")
    public String save(@Valid @ModelAttribute ServiceDto serviceDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("serviceDto", serviceDto);
            return "/service/create";
        }

        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        iServiceService.save(service);
        redirectAttributes.addFlashAttribute("message", "Added new Service have successfully");
        return "redirect:/service";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Optional<Integer> id) {
        iServiceService.removeById(id.get());
        return "redirect:/service";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        Service service = iServiceService.findById(id);
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(service, serviceDto);
        model.addAttribute("serviceDto", serviceDto);
        return "service/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute ServiceDto serviceDto,
                       BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("serviceDto", serviceDto);
            return "service/edit";
        }

        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        iServiceService.save(service);
        return "redirect:/service";
    }
}

