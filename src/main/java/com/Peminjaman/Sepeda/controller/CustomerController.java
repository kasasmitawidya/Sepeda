package com.Peminjaman.Sepeda.controller;

import com.Peminjaman.Sepeda.RestRespon;
import com.Peminjaman.Sepeda.dto.customer.CustomerHeaderDto;
import com.Peminjaman.Sepeda.dto.customer.CustomerInsert;
import com.Peminjaman.Sepeda.dto.customer.CustomerUpdate;
import com.Peminjaman.Sepeda.dto.employee.EmployeeHeaderDto;
import com.Peminjaman.Sepeda.dto.employee.EmployeeInsert;
import com.Peminjaman.Sepeda.dto.employee.EmployeeUpdate;
import com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto;
import com.Peminjaman.Sepeda.services.CustomerService;
import com.Peminjaman.Sepeda.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("customer")
public class CustomerController {

    private CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<RestRespon<List<CustomerHeaderDto>>> findall(){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.findall(),
                "Data Berhasil Ditemukan",
                "200"
        ));
    }
    @PostMapping
    private ResponseEntity<RestRespon<CustomerHeaderDto>> insert (@RequestBody CustomerInsert newCustomer){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.insert(newCustomer),
                "Data berhasil ditambahkan",
                "201"
        ));
    }


    @PutMapping("{customerID}")
    public ResponseEntity<RestRespon<CustomerUpdate>> update(@PathVariable Integer customerID, @RequestBody CustomerUpdate update){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.update(customerID,update),
                "Data berhasil di update",
                "200"
        ));
    }

    @DeleteMapping("{customerID}")
    public ResponseEntity<RestRespon<CustomerHeaderDto>> delete(@PathVariable Integer customerID){
        return  ResponseEntity.ok().body(new RestRespon<>(
                service.delete(customerID),
                "Data berhasil di hapus",
                "201"
        ));
    }

    @GetMapping("{customerID}")
    public   ResponseEntity<RestRespon<List<LoanHeaderDto>>> findLoanByCustomerID(@PathVariable Integer customerID){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.findLoanBYcustomer(customerID),
                "Data Berhasil Ditemukan",
                "200"
        ));
    }

}
