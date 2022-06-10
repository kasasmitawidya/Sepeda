package com.Peminjaman.Sepeda.dto.employee;

import com.Peminjaman.Sepeda.dto.customer.CustomerHeaderDto;
import com.Peminjaman.Sepeda.entity.Customers;
import com.Peminjaman.Sepeda.entity.Employee;
import lombok.Data;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
@Data
public class EmployeeHeaderDto {
    private final Integer employeeID;
    private final String name;
    private final String gender;
    private final String address;

    public static EmployeeHeaderDto set(Employee employee){
        return new EmployeeHeaderDto(employee.getEmployeeID(),
                employee.getName(),employee.getGender(),employee.getAddress());
    }

    public static List<EmployeeHeaderDto> tolist (List<Employee> employees){
        List<EmployeeHeaderDto> result = new ArrayList<>();
        for (var employee : employees){
            result.add(set(employee));
        }
        return  result;
    }
}
