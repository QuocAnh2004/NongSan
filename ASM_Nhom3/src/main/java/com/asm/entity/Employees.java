package com.asm.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @OneToOne
    @JoinColumn(name = "users_id_employee", nullable = false)
    private Users user;

    @Column(name = "first_name_employee", nullable = false, length = 255)
    private String firstName;

    @Column(name = "last_name_employee", nullable = false, length = 255)
    private String lastName;

    @Column(name = "email_employee", nullable = false, length = 255)
    private String email;

    @Column(name = "phone_number_employee", nullable = false, length = 50)
    private String phoneNumber;

    @Column(name = "address_employee", nullable = false, length = 255)
    private String address;

    @Column(name = "picture_employee", length = 255)
    private String picture;

    @Column(name = "date_of_birth_employee", nullable = false)
    private Date dateOfBirth;

    @Column(name = "genders_employee", nullable = false)
    private boolean gender;

    @Column(name = "is_active__employee", nullable = false)
    private boolean isActive;

    // Getters and setters
}

