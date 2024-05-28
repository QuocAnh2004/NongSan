package com.asm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "name_supplier", nullable = false, length = 255)
    private String name;

    @Column(name = "contact_name", length = 255)
    private String contactName;

    @Column(name = "contact_email", length = 255)
    private String contactEmail;

    @Column(name = "contact_phone", length = 50)
    private String contactPhone;

    @Column(name = "supplier_address", length = 255)
    private String address;

    // Getters and setters
}

