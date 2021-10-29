package com.practices.contoller;

import com.practices.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService calculatorService;

    @RequestMapping("/")
    public String showPage(){
        return "calculator";
    }


    @GetMapping("/calculator-page")
    public String calculatorSimple(@RequestParam double numberone,
                                   @RequestParam double numbertwo,
                                   @RequestParam String calculator,
                                   Model model){
        double result = 0;
        try{
            result = calculatorService.calculator(numberone,numbertwo,calculator);
        }catch (ArithmeticException e){
            model.addAttribute("message","Not division zero");
            e.getMessage();
        }
            model.addAttribute("calculate",calculator);

            model.addAttribute("result",result);
            return "calculator";
    }
}
