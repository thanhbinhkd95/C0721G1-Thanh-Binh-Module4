package com.example.customeri18n.controller;

import com.example.customeri18n.model.entity.Customer;
import com.example.customeri18n.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/")
    public ModelAndView showList(){
        return new ModelAndView("list","customerList",customerService.findAll());
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }

    @PostMapping("/create-customer")
    public String createCustomer(@ModelAttribute Customer customer, RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addFlashAttribute("message","Success");
        return "redirect:/";

    }
}
