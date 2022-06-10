package com.Peminjaman.Sepeda.dto.employee;

import com.Peminjaman.Sepeda.entity.Employee;
import com.Peminjaman.Sepeda.entity.Loan;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class EmployeeInsert {
    private final String name;
    private final String gender;
    private final String address;

    public Employee convert(){
        return new Employee(name,gender,address); }
}
