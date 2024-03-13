package com.honey.Hnyeeb.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "sales_master")
@Data
public class Sales {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private Long billId;

    @Column(nullable = false)
    private String types;

    @Column(nullable = false)
    private  String productName;

    @Column(nullable = false)
    private  String productSubName;

    @Column(nullable = false)
    private  String totalKg;

    @Column(nullable = false)
    private String ppKg;

    @Column(nullable = false)
    private String mrp;

    @Column(nullable = false)
    private String notes;

    @Column(nullable = false)
    private String totalPrice;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String createdAt;

}
