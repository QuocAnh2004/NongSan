package com.asm.entity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asm.entity.Customers;

public interface CustomersDAO extends JpaRepository<Customers, Integer> {
    // Bổ sung các phương thức tùy chỉnh nếu cần
	  @Query("SELECT c FROM Customers c WHERE c.user.userId = ?1")
	    List<Customers> findByUserId(String userId);
		Customers findByEmail(String email);

}
