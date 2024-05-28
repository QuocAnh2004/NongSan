package com.asm.entity.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.asm.entity.Reviews;

public interface ReviewsDAO extends JpaRepository<Reviews, Integer> {
    // Bổ sung các phương thức tùy chỉnh nếu cần
}
