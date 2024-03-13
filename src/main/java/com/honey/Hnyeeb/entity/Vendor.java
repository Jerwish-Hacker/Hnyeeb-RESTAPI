package com.honey.Hnyeeb.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String vendorName;

    @Column(nullable = false)
    private  String vendorAddress;

    @Column(nullable = false)
    private  String vendorPhoneNo;

    @Column(nullable = false)
    private String status;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public String getVendorPhoneNo() {
        return vendorPhoneNo;
    }

    public void setVendorPhoneNo(String vendorPhoneNo) {
        this.vendorPhoneNo = vendorPhoneNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
