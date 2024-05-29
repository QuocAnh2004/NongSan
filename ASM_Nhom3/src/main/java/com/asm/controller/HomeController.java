package com.asm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asm.entity.Products;
import com.asm.entity.dao.ProductsDAO;

@Controller
@RequestMapping("home")
public class HomeController {

	@Autowired
	ProductsDAO productsDAO;

	@RequestMapping("/index")
	public String index(Model model) {
		Pageable pageable = PageRequest.of(0, 8); // Lấy 8 sản phẩm đầu tiên
	    Page<Products> productsPage = productsDAO.findAll(pageable);
	    List<Products> products = productsPage.getContent();
	    model.addAttribute("products", products);
		return "user/index";
	}

}
