package com.asm.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asm.entity.Vouchers;

public interface VouchersDAO extends JpaRepository<Vouchers, Integer> {
    // Bổ sung các phương thức tùy chỉnh nếu cần
}
