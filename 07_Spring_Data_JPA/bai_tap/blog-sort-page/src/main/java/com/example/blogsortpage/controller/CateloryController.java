package com.example.blogsortpage.controller;

import com.example.blogsortpage.model.entity.Catelory;
import com.example.blogsortpage.model.service.ICateloryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/catelory")
public class CateloryController {

    @Autowired
    private ICateloryService cateloryService;

    @GetMapping(value = "/")
    public String showListCatelory(Model model){
        model.addAttribute("caleloryList", cateloryService.findAll());
        return "catelory/list";
    }
    @GetMapping(value = "/catelory-create")
    public String showCreateCatelory(Model model){
        model.addAttribute("catelory",new Catelory());
        return "catelory/create";

    }

    @PostMapping(value = "/catelory-create/create")
    public String createCatelory(@ModelAttribute Catelory catelory){
        this.cateloryService.save(catelory);
        return "redirect:/catelory";
    }
    @GetMapping(value = "/catelory-edit/edit")
    public String showEditCatelory(@RequestParam int id, Model model){
        model.addAttribute("catelory",this.cateloryService.findById(id));
        model.addAttribute("cateloryList",this.cateloryService.findAll());
        return "catelory/edit";
    }
    @PostMapping(value = "/catelory-edit/edit")
    public String editCatelory(@ModelAttribute Catelory catelory){
        this.cateloryService.update(catelory);
        return "redirect:/catelory";
    }
    @GetMapping(value = "/catelory-delete/delete")
    public String deleteCatelory(@RequestParam int id){
        this.cateloryService.delete(id);
        return "redirect:/catelory";
    }

}
