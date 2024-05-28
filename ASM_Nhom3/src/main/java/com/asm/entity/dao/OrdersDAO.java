package com.asm.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asm.entity.Orders;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {
    // Bổ sung các phương thức tùy chỉnh nếu cần
}
