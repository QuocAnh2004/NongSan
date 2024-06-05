package com.asm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asm.entity.Customers;
import com.asm.entity.Users;
import com.asm.entity.dao.CustomersDAO;
import com.asm.entity.dao.UsersDAO;
import com.asm.services.SessionService;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/app")
public class LoginController {
 
	 @Autowired
	 private SessionService sessionService;
	 @Autowired
	 private UsersDAO usersDAO;
	 @Autowired
	 private CustomersDAO customersDAO;
	 
	 @GetMapping("/user/login")
	 public String loginForm(Model model) {
	     // Kiểm tra nếu người dùng đã đăng nhập, chuyển hướng đến trang chính
	     if (sessionService.get("loggedInUser") != null) {
	         return "redirect:/app/user/index";
	     }
	     model.addAttribute("user", new Users());
	     return "user/login";
	 }
	// vinh
	 @PostMapping("/user/login")
	 public String login(@Valid @ModelAttribute("user") Users user, BindingResult result, Model model) {
	     if (loginSuccessful(user)) {
	         sessionService.set("loggedInUser", user.getUsername());
	         List<Customers> customersList = customersDAO.findByUserId(user.getUserId());
	         
	         Users usersIdByUserName =  usersDAO.findByUserIdByUsername(user.getUsername());    
	         System.out.println("User id by user name "+ usersIdByUserName); // có
	         System.out.println("User name "+ user.getUsername()); // có
	         System.out.println("User role by user id "+ usersIdByUserName.getUserRole()); // có
	         model.addAttribute("role", usersIdByUserName.getUserRole().getRoleId());
	         System.out.println(" role by user id "+usersIdByUserName.getUserRole().getRoleId()); // có
	         
	         model.addAttribute("role", usersIdByUserName.getUserRole().getRoleId());
	         sessionService.set("roleUserLogin", usersIdByUserName.getUserRole().getRoleId());
	         sessionService.set("loggedInCustomers", customersList);
	         return "redirect:/app/user/index";
	     } else {
	         model.addAttribute("error", "Invalid username or password");
	         return "user/login";
	     }
	 }
	 @GetMapping("/user/index")
	 public String index(Model model) {
	     return "user/index";
	 }
	 
	 @GetMapping("/user/logout")
	 public String logout() {
	     sessionService.remove("loggedInUser");
	     sessionService.remove("loggedInCustomer");
	     return "redirect:/app/user/index";
	 }

	 // Phương thức kiểm tra đăng nhập thành công
	 private boolean loginSuccessful(Users user) {
	     Users existingUser = usersDAO.findByUsername(user.getUsername());
	     return existingUser != null && existingUser.getPasswordUser().equals(user.getPasswordUser
	    		 ());
	 }
}
