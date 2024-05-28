package com.asm.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Customers")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @OneToOne
    @JoinColumn(name = "users_id_customer", nullable = false)
    private Users user;

    @Column(name = "first_name_customer", nullable = false, length = 255)
    private String firstName;

    @Column(name = "last_name_customer", nullable = false, length = 255)
    private String lastName;

    @Column(name = "email_customer", nullable = false, length = 255)
    private String email;

    @Column(name = "address_customer", nullable = false, length = 255)
    private String address;

    @Column(name = "phone_number_customer", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "date_sign_up_customer", nullable = false)
    private Date dateSignUp;

    @Column(name = "date_of_birth_customer", nullable = false)
    private Date dateOfBirth;

    @Column(name = "genders_customer", nullable = false)
    private boolean gender;

    @Column(name = "is_active_customer", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "customer")
    private List<Reviews> reviews;
    // Getters and setters
}

