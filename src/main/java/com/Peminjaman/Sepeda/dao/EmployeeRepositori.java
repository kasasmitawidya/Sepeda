package com.Peminjaman.Sepeda.dao;

import com.Peminjaman.Sepeda.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepositori extends JpaRepository<Employee,Integer> {


}
