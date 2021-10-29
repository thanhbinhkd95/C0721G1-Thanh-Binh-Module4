package com.product.controller;

import com.product.model.bean.Product;
import com.product.model.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productServiceImpl;

    @RequestMapping("/")
    public String showList(Model model){
        List<Product> productList = productServiceImpl.findAll();
        model.addAttribute("productList",productList);
        model.addAttribute("product",new Product());
        return "list";
    }
    @PostMapping("/product/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect){
        redirect.addFlashAttribute("success","Delete Successfull !");
        productServiceImpl.remove(id);
        return "redirect:/";
    }
    @PostMapping("/product/create")
    public String create(Product product,RedirectAttributes redirect){
        productServiceImpl.save(product);
        redirect.addFlashAttribute("success","Insert Successfull !");
        return "redirect:/";
    }
    @GetMapping("product/view")
    public String viewInformation(@RequestParam int id,Model model){
        model.addAttribute("product",productServiceImpl.findById(id));
        return "view";
    }
    @GetMapping("product/edit")
    public String editForm(@RequestParam int id,Model model){
        model.addAttribute("products",productServiceImpl.findById(id));
        return "edit";
    }
    @PostMapping("/product/search")
    public String searchProduct(@RequestParam String searchProduct,Model model){
        List<Product> productList = productServiceImpl.seachProduct(searchProduct);
        model.addAttribute("productList",productList);
        return "list";
    }
    @PostMapping(value = "/product/update")
    public String save(Product product){
        productServiceImpl.update(product.getId(),product);
        return "redirect:/";

    }

}
