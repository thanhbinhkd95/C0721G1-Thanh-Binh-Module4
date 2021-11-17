package com.example.blogsortpage.controller;

import com.example.blogsortpage.model.entity.AppUser;
import com.example.blogsortpage.model.service.IAppRoleService;
import com.example.blogsortpage.model.service.IAppUserService;
import com.example.blogsortpage.model.service.IUserRoleService;
import com.example.blogsortpage.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    IAppUserService appUserService;

    @Autowired
    IAppRoleService appRoleService;

    @Autowired
    IUserRoleService userRoleService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }


    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
    @GetMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("user",new AppUser());
        return "registerPage";
    }
    @PostMapping("/create-user")
    public String createUser(@ModelAttribute AppUser user,@RequestParam Long[] role){
        List<AppUser> userList = this.appUserService.findAll();
        for(AppUser appUser : userList){
            if(appUser.getUserName().equals(user.getUserName())){
                return "welcomePage";
            }
        }
        String pass = bCryptPasswordEncoder.encode(user.getEncrytedPassword());
        user.setEncrytedPassword(pass);
        this.appUserService.save(user);
        for(int i = 0 ; i<role.length;i++){
            this.userRoleService.save(user,role[i].longValue());
        }
        return "welcomePage";
    }
}
