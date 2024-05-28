package com.asm.entity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.asm.entity.Users;

public interface UsersDAO extends JpaRepository<Users, String> {
    // Bổ sung các phương thức tùy chỉnh nếu cần
}
