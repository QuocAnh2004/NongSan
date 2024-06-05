package com.asm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asm.entity.Customers;
import com.asm.entity.Users;
import com.asm.entity.dao.CustomersDAO;
import com.asm.entity.dao.UsersDAO;
import com.asm.services.SessionService;

//EditProfileController.java
@Controller
@RequestMapping("/app")
public class EditProfileController {

 @Autowired
 private SessionService sessionService;

 @Autowired
 private CustomersDAO customersDAO;
 
 @Autowired
 private UsersDAO usersDAO;
 
 @GetMapping("/user/editProfile")
 public String editProfileForm(Model model) {
     Object loggedInUserObj = sessionService.get("loggedInUser");
     Users user = null;

     if (loggedInUserObj instanceof String) {
         String username = (String) loggedInUserObj;
         user = usersDAO.findByUsername(username);
     } else if (loggedInUserObj instanceof Users) {
         user = (Users) loggedInUserObj;
     }

     if (user != null) {
         Customers loggedInCustomer = customersDAO.findByUserId(user.getUserId()).get(0);
         model.addAttribute("customer", loggedInCustomer); // Thêm đối tượng customer vào model
         return "user/editProfile";
     } else {
         return "redirect:/user/login";
     }
 }


 @PostMapping("/user/editProfile")
 public String editProfile(@ModelAttribute("customer") Customers customer, Model model) {
     // Lấy đối tượng người dùng hiện đang đăng nhập từ session
     Object loggedInUserObj = sessionService.get("loggedInUser");
     Users loggedInUser = null;

     if (loggedInUserObj instanceof String) {
         String username = (String) loggedInUserObj;
         loggedInUser = usersDAO.findByUsername(username);
     } else if (loggedInUserObj instanceof Users) {
         loggedInUser = (Users) loggedInUserObj;
     }

     if (loggedInUser != null) {
    	 List<Customers> existingCustomers = customersDAO.findByUserId(loggedInUser.getUserId());
         if (!existingCustomers.isEmpty()) {
             Customers existingCustomer = existingCustomers.get(0);
             // Cập nhật thông tin khách hàng hiện có
             existingCustomer.setFirstName(customer.getFirstName());
             existingCustomer.setLastName(customer.getLastName());
             existingCustomer.setEmail(customer.getEmail());
             existingCustomer.setAddress(customer.getAddress());
             existingCustomer.setPhoneNumber(customer.getPhoneNumber());
             existingCustomer.setDateOfBirth(customer.getDateOfBirth());
             existingCustomer.setGender(customer.isGender());
             existingCustomer.setIsActive(customer.isIsActive());
             customersDAO.save(existingCustomer);
         }else {
        	 model.addAttribute("error", "No account!");
             return "user/login";
         }
         sessionService.set("loggedInCustomer", customer);
         return "redirect:/app/user/editProfile";
     } else {
         return "redirect:/app/user/login";
     }
 }
}
