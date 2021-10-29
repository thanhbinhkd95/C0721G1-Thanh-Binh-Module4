package com.example.controller;

import com.example.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @Autowired
    ITranslateService translateService;

    @GetMapping("/")
    public String showForm(){
        return "index";
    }


    @PostMapping("dictionary")
    public String translate(@RequestParam String search, Model model){
        Map<String,String> dicMap = translateService.storeDictionary();
        String result = dicMap.get(search);
        if(result == null){
            model.addAttribute("message","Not found");
            return "index";
        }else {
            model.addAttribute("result",result);
            return "dictionary";
        }
    }
}
