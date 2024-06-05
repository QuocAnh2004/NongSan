package com.asm.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asm.entity.OrderDetails;

public interface OrderDetailsDAO extends JpaRepository<OrderDetails, Integer> {
    // Bổ sung các phương thức tùy chỉnh nếu cần
}
