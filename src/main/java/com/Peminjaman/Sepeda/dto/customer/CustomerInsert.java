package com.Peminjaman.Sepeda.dto.customer;

import com.Peminjaman.Sepeda.entity.Customers;
import com.Peminjaman.Sepeda.entity.Employee;
import lombok.Data;

@Data

public class CustomerInsert {
    private final String name;
    private final String address;
    private final String phone;
    private final String email;

    public Customers convert(){
        return new Customers(name,address,phone,email); }
}
