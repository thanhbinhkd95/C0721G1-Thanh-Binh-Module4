package com.example.controller;

import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @Autowired
    IConvertService convertService;
    @GetMapping("/")
    public String showIndex(){
        return "index";
    }
    @PostMapping("/converter")
    public String convert(@RequestParam int usd, Model model){
        int vnd = convertService.converUSD(usd);
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",vnd);
        return "converter";
    }
}
