package com.asm.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @Column(name = "users_id", length = 255)
    private String userId;

    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name = "password_user", nullable = false, length = 255)
    private String passwordUser;

    @ManyToOne
    @JoinColumn(name = "role_name_user", nullable = false)
    private UserRoles userRole;

    // Getters and setters
}
