package com.asm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.entity.Products;
import com.asm.entity.Reviews;
import com.asm.entity.dao.ProductsDAO;
import com.asm.entity.dao.ReviewsDAO;

@Controller
@RequestMapping("product")
public class ShopController {
	@Autowired
	ProductsDAO productsDAO;
	@Autowired 
	ReviewsDAO reviewsDAO;
	
	@RequestMapping("/index")
	public String product(Model model, @RequestParam("page") Optional<Integer> page) {
		Pageable pageable = PageRequest.of(page.orElse(0), 9); // truy xuất trang thứ 0 có 2 sản phẩm
		Page<Products> items_products = productsDAO.findAll(pageable); // truy vấn tất cả
		model.addAttribute("items_products", items_products);
		
		return "user/shop";
	}
	
	 // Phương thức hiển thị chi tiết sản phẩm
    @GetMapping("/detail/{id}")
    public String productDetail(@PathVariable("id") int id_product, Model model) {
        Optional<Products> product = productsDAO.findById(id_product);
        if (product.isPresent()) {
        	 // Lấy danh sách đánh giá theo id sản phẩm
            List<Reviews> reviews = reviewsDAO.find_ReviewProduct_By_ProductId(id_product);
            model.addAttribute("product", product.get());
            model.addAttribute("reviews", reviews);
            return "user/shop-detail"; // Tên của trang JSP hiển thị chi tiết sản phẩm
        } else {
            return "redirect:/product/index"; // Nếu sản phẩm không tồn tại, chuyển hướng về danh sách sản phẩm
        }
    }
}
