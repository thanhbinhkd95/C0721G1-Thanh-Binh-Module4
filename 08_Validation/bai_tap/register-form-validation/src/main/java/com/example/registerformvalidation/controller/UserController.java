package com.example.registerformvalidation.controller;

import com.example.registerformvalidation.model.dto.UserDto;
import com.example.registerformvalidation.model.entity.User;
import com.example.registerformvalidation.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/")
    public ModelAndView showListUser(){
        return new ModelAndView("list_user","userList",this.userService.fillAll());
    }

    @GetMapping("/create-user")
    public String showCreateForm(Model model){
        model.addAttribute("userDto",new UserDto());
        return "create_user";
    }
    @PostMapping("/create-user/create")
    public String createUser(@Validated  @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes redirect){
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
       if(bindingResult.hasFieldErrors()){
           return "create_user";
       }else {
           this.userService.save(user);
           redirect.addFlashAttribute("message","Create User Successfull !");
           return "redirect:/";
       }
    }
}
