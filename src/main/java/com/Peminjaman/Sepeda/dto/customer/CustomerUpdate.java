package com.Peminjaman.Sepeda.dto.customer;

import com.Peminjaman.Sepeda.dto.employee.EmployeeUpdate;
import com.Peminjaman.Sepeda.entity.Customers;
import com.Peminjaman.Sepeda.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdate {
    private  String address;
    private  String phone;
    private  String email;

    public static CustomerUpdate set (Customers customer){
        return new CustomerUpdate(customer.getAddress(),customer.getPhone(),customer.getEmail());
    }

    //test
}
