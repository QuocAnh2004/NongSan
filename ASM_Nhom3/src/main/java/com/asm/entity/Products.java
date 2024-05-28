package com.asm.entity;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price_product", nullable = false)
    private float price;

    @Column(name = "sale_price")
    private float salePrice;

    @ManyToOne
    @JoinColumn(name = "unit", nullable = false)
    private Units unit;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "import_date")
    private Date importDate;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "exp_date")
    private Date expDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Suppliers supplier;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    // Getters and setters
}
