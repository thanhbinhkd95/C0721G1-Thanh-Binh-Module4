package com.example.blogapplication.controller;

import com.example.blogapplication.model.entity.Blog;
import com.example.blogapplication.model.service.IBlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @RequestMapping(value = "/")
    public String showView(Model model){
        model.addAttribute("blogList",blogService.findAll());
        return "list";
    }
    @RequestMapping(value = "/create-blog")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping(value = "/create")
    public String createNewBlog(@ModelAttribute Blog blog,RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("message","Create Successfull");
        return "redirect:/";
    }
    @GetMapping(value = "/blog/view")
    public String showViewBlog(@RequestParam int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "view";
    }
    @GetMapping(value = "/blog/edit")
    public String showEditBlog(@RequestParam int id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "edit";
    }
    @PostMapping(value = "/edit")
    public String editBlog(@ModelAttribute Blog blog,RedirectAttributes redirect){

        blogService.update(blog);
        redirect.addFlashAttribute("message","Edit Successfull");
        return "redirect:/";
    }

    @GetMapping(value = "/blog/delete")
    public String deleteBlog(@RequestParam int id, RedirectAttributes redirect){
        blogService.delete(id);
        redirect.addFlashAttribute("message","Delete Successfull!");
        return "redirect:/";
    }
}
