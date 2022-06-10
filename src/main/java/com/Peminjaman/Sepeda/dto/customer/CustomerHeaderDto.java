package com.Peminjaman.Sepeda.dto.customer;

import com.Peminjaman.Sepeda.dto.bicycle.BicycleHeaderDto;
import com.Peminjaman.Sepeda.entity.Bicycle;
import com.Peminjaman.Sepeda.entity.Customers;
import lombok.Data;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
@Data
public class CustomerHeaderDto {
    private final  Integer customerID;
    private final String name;
    private final String address;
    private final String phone;
    private final String email;

    public static CustomerHeaderDto set(Customers customers){
        return new CustomerHeaderDto(customers.getCustomerID(),
                customers.getName(),customers.getAddress(),customers.getPhone(),
                customers.getEmail());
    }

    public static List<CustomerHeaderDto> tolist (List<Customers> customers){
        List<CustomerHeaderDto> result = new ArrayList<>();
        for (var customer : customers){
            result.add(set(customer));
        }
        return  result;
    }
}
