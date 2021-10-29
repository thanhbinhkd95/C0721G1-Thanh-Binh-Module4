package com.practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SanwichController {

    @RequestMapping("/")
    public String showMainpage(){
        return "sandwich_condiments";
    }

    @GetMapping("/condiment")
    public String resultMenu(@RequestParam("condiment") String[] condiment, Model model){
        model.addAttribute("listcondiment",condiment);
        return "sandwich_condiments";
    }
}
