package com.Peminjaman.Sepeda.services;

import com.Peminjaman.Sepeda.dao.BicycleRepositori;
import com.Peminjaman.Sepeda.dao.CustomerRepositori;
import com.Peminjaman.Sepeda.dao.LoanRepository;
import com.Peminjaman.Sepeda.dto.bicycle.BicycleHeaderDto;
import com.Peminjaman.Sepeda.dto.bicycle.BicycleInsert;
import com.Peminjaman.Sepeda.dto.bicycle.BicycleUpdate;
import com.Peminjaman.Sepeda.dto.customer.CustomerHeaderDto;
import com.Peminjaman.Sepeda.dto.customer.CustomerInsert;
import com.Peminjaman.Sepeda.dto.customer.CustomerUpdate;
import com.Peminjaman.Sepeda.dto.employee.EmployeeHeaderDto;
import com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto;
import com.Peminjaman.Sepeda.entity.Bicycle;
import com.Peminjaman.Sepeda.entity.Customers;
import com.Peminjaman.Sepeda.entity.Employee;
import com.Peminjaman.Sepeda.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerService {

    private CustomerRepositori customerRepositori;
    private LoanRepository loanRepository;

    @Autowired
    public CustomerService(CustomerRepositori customerRepositori, LoanRepository loanRepository) {
        this.customerRepositori = customerRepositori;
        this.loanRepository = loanRepository;
    }

    public List<CustomerHeaderDto> findall(){
        return CustomerHeaderDto.tolist(customerRepositori.findAll());
    }

    public CustomerHeaderDto insert(CustomerInsert customerInsert){
        Customers customer= customerInsert.convert();
        customerRepositori.save(customer);
        return CustomerHeaderDto.set(customer);
    }
    public CustomerUpdate update(Integer id, CustomerUpdate customerUpdate){
        Customers olddata =customerRepositori.getById(id);
        olddata.setAddress(customerUpdate.getAddress());
        olddata.setPhone(customerUpdate.getPhone());
        olddata.setEmail(customerUpdate.getEmail());
        customerRepositori.save(olddata);
        return CustomerUpdate.set(olddata);
    }

    public CustomerHeaderDto delete(Integer customerID){
        Customers customers =customerRepositori.findById(customerID).
                orElseThrow(()-> new EntityNotFoundException("Customer tidak ditemukan"));
        customerRepositori.delete(customers);
        return CustomerHeaderDto.set(customers);
    }

    public List<LoanHeaderDto> findLoanBYcustomer(Integer customerID){
        List<Loan> listloant = loanRepository.findbyCustomer(customerID);
        Stream<LoanHeaderDto> loanStream = LoanHeaderDto.tolist(listloant).stream();
        return loanStream.collect(Collectors.toList());

    }
}
