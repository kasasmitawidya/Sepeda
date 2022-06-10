package com.Peminjaman.Sepeda.dto.employee;

import com.Peminjaman.Sepeda.dto.loan.LoanUpdate;
import com.Peminjaman.Sepeda.entity.Employee;
import com.Peminjaman.Sepeda.entity.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdate {
    private  String address;

    public static EmployeeUpdate set (Employee employee){
        return new EmployeeUpdate(employee.getAddress());
    }
}
