package com.Peminjaman.Sepeda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @Column(name="EmployeeID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeID;
    @Column(name="Name")
    private String name;
    @Column(name="Gender")
    private String gender;
    @Column(name="Adddress")
    private String address;

    public Employee(String name, String gender, String address) {
        this.name = name;
        this.gender = gender;
        this.address = address;
    }
}
