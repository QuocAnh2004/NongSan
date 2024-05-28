package com.asm.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asm.entity.Products;

public interface ProductsDAO extends JpaRepository<Products, Integer> {
    // Bổ sung các phương thức tùy chỉnh nếu cần
}
