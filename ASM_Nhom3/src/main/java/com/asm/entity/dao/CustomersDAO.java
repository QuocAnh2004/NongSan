package com.asm.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asm.entity.Customers;

public interface CustomersDAO extends JpaRepository<Customers, Integer> {
    // Bổ sung các phương thức tùy chỉnh nếu cần
}
