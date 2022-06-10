package com.Peminjaman.Sepeda.dao;

import com.Peminjaman.Sepeda.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositori extends JpaRepository<Employee,Integer> {
}
