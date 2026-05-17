package com.healthcare.api.entity;

import jakarta.persistence.*;

@Entity
public class MicroArea {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (unique = true, nullable = false)
    private String code;
}
