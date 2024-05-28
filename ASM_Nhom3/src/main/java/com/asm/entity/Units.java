package com.asm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Units")
public class Units {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unit")
    private int unitId;

    @Column(name = "name_unit", nullable = false, length = 100)
    private String name;

    // Getters and setters
}

