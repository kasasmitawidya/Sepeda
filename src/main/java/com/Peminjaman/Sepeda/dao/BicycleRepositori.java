package com.Peminjaman.Sepeda.dao;

import com.Peminjaman.Sepeda.entity.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BicycleRepositori extends JpaRepository<Bicycle,Integer> {
}
