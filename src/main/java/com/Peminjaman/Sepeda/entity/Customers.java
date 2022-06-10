package com.Peminjaman.Sepeda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="Customer")
public class Customers {
    @Id
    @Column(name="CustomerID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer customerID;
    @Column(name="Name")
    private String name;
    @Column(name="Address")
    private String address;
    @Column(name="Phone")
    private String phone;
    @Column(name="Email")
    private String email;

    public Customers(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public Customers() {
    }
}