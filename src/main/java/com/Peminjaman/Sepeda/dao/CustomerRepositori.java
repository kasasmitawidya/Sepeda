package com.Peminjaman.Sepeda.dao;

import com.Peminjaman.Sepeda.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepositori extends JpaRepository<Customers,Integer> {
}
