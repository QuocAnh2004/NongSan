package com.asm.entity.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.asm.entity.Products;

public interface ProductsDAO extends JpaRepository<Products, Integer> {

	// PHÂN TRANG VỚI THAM SỐ PAGEABLE
    Page<Products> findAll(Pageable pageable);

}
