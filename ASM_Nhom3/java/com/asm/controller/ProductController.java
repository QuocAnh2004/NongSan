package com.asm.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.asm.entity.Categories;
import com.asm.entity.Products;
import com.asm.entity.Suppliers;
import com.asm.entity.Units;
import com.asm.entity.dao.ProductsDAO;
import com.asm.services.CategoryService;
import com.asm.services.ProductService;
import com.asm.services.SuppliersService;
import com.asm.services.UnitService;

@Controller
public class ProductController {
    @Autowired
    private UnitService unitService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SuppliersService supplierService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    ProductsDAO productDAO;
    
    @Value("${file.upload.dir}") // Sử dụng @Value để inject giá trị từ application.properties
    private String uploadDir;
//    private static final String UPLOAD_DIR = "src/main/webapp/template/user/picture/";
    
    @RequestMapping("/productForm")
    public String showProductForm(Model model) {
        // Lấy danh sách các đơn vị, danh mục và nhà cung cấp từ service
    	List<Products> product = productService.getAllProducts();
        List<Units> units = unitService.getAllUnits();
        List<Categories> categories = categoryService.getAllCategory();
        List<Suppliers> suppliers = supplierService.getAllSuppliers();
        Products item = new Products();
        model.addAttribute("dateTime", LocalDate.now());
        // Thêm danh sách các đơn vị, danh mục và nhà cung cấp vào model để hiển thị trong form JSP
        model.addAttribute("item", item);
        model.addAttribute("units", units);
        model.addAttribute("categories", categories);
        model.addAttribute("suppliers", suppliers);
        model.addAttribute("products", product);
        
        return "admin/manage_product";
    }
    
    @RequestMapping("/product/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        Products item = productDAO.findById(id).get();
        model.addAttribute("item", item);
        List<Products> items = productDAO.findAll();
        List<Units> units = unitService.getAllUnits();
        List<Categories> categories = categoryService.getAllCategory();
        List<Suppliers> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("products", items);
        model.addAttribute("units", units);
        model.addAttribute("categories", categories);
        model.addAttribute("suppliers", suppliers);
        return "/admin/manage_product";
    }
    
//    @RequestMapping("/product/create")
//    public String create(Products product) {
//        productDAO.save(product);
//        return "redirect:/productForm";
//    }
//    
//    @RequestMapping("/product/update")
//    public String update(Products item) {
//        productDAO.save(item);
//        return "redirect:/product/edit/" + item.getProductId();
//    }
    @PostMapping("/product/create")
    public String create(@ModelAttribute("item") Products product, @RequestParam("file") MultipartFile file) {
        // Kiểm tra xem tệp đã được chọn chưa
        if (file.isEmpty()) {
            // Xử lý khi không có tệp được chọn
            return "redirect:/productForm"; // hoặc trả về một thông báo lỗi
        }

        try {
            // Lấy tên tệp
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // Copy tệp vào thư mục được chỉ định
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            }

            // Lưu tên tệp vào đối tượng sản phẩm
            product.setImageUrl(fileName);
          product.setImportDate(new Date());

            // Lưu đối tượng sản phẩm vào cơ sở dữ liệu
            productDAO.save(product);
        } catch (IOException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
            // có thể trả về một trang lỗi hoặc thông báo lỗi khác
        }

        return "redirect:/productForm"; // hoặc trả về một trang khác sau khi lưu sản phẩm thành công
    }
    @PostMapping("/product/update")
    public String update(@ModelAttribute("item") Products product, @RequestParam("file") MultipartFile file) {
        // Kiểm tra xem tệp đã được chọn chưa
        if (file.isEmpty()) {
            // Xử lý khi không có tệp được chọn
            return "redirect:/productForm"; // hoặc trả về một thông báo lỗi
        }

        try {
            // Lấy tên tệp
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // Copy tệp vào thư mục được chỉ định
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            }

            // Lưu tên tệp vào đối tượng sản phẩm
            product.setImageUrl(fileName);

            // Lưu đối tượng sản phẩm vào cơ sở dữ liệu
            productDAO.save(product);
        } catch (IOException e) {
            e.printStackTrace(); // Xử lý lỗi nếu có
            // có thể trả về một trang lỗi hoặc thông báo lỗi khác
        }

        return "redirect:/product/edit/" + product.getProductId(); // hoặc trả về một trang khác sau khi lưu sản phẩm thành công
    }
    
    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        productDAO.deleteById(id);
        return "redirect:/productForm";
    }
    

}
