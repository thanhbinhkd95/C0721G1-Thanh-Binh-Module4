package com.example.shopingcart.controller;

import com.example.shopingcart.model.entity.Cart;
import com.example.shopingcart.model.entity.Product;
import com.example.shopingcart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/")
    public ModelAndView showShop(@ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("listProduct", productService.findAll());
        modelAndView.addObject("size",cart.getSize());
        return modelAndView;
    }
//    @PostMapping("/cart/add")
//    public String addToCart(@RequestParam Integer id,
//                            @RequestParam Integer amount,
//                            Model model,
//                            @ModelAttribute("cart") Cart cart){
//        Product product =  this.productService.findById(id);
//        model.addAttribute("product",product);
//        if(product != null){
//            cart.addToCart(product,amount);
//            model.addAttribute("size",cart.getSize());
//            model.addAttribute("message","Add product" + product.getName() + "with amount :" +cart.getAmount(product) + " succcess full");
//        }
//        return "product/view";
//    }
    @GetMapping("/product/view")
    public String viewProduct(@RequestParam Integer id,
                              Model model,
                              @SessionAttribute("cart") Cart cart){
        model.addAttribute("product", this.productService.findById(id));
        model.addAttribute("size", cart.getSize());
        return "product/view";
    }
//    @GetMapping("/cart")
//    public String goToCart(Model model,
//                           @ModelAttribute("cart") Cart cart){
//        model.addAttribute("listProduct", cart.getCart());
//        model.addAttribute("total", cart.getTotal());
//        return "cart/cart";
//    }

//    @PostMapping("/cart/remove")
//    public String removeProductFromCart(@RequestParam Integer id,
//                                        @ModelAttribute("cart") Cart cart,
//                                        RedirectAttributes redirect){
//        Product product = this.productService.findById(id);
//        cart.removeProduct(product);
//        redirect.addFlashAttribute("message", "Remove Product "+product.getName()+" successfully!");
//        return "redirect:/cart";
//    }

}