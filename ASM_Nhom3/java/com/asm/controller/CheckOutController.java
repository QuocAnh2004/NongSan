package com.asm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asm.services.ShoppingCartService;


@Controller
@RequestMapping("app")
public class CheckOutController {
	 @Autowired
	 ShoppingCartService shoppingCartService;
	 
    @RequestMapping("/user/checkout")
    public String checkout(Model model) {
    	model.addAttribute("subtotal", shoppingCartService.getAmount());
    	model.addAttribute("cartCount", shoppingCartService.getCount());
        model.addAttribute("subtotal", shoppingCartService.getAmount());
    	return "user/checkout";
    }
}