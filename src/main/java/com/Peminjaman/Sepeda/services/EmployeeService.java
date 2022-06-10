package com.Peminjaman.Sepeda.services;

import com.Peminjaman.Sepeda.dao.CustomerRepositori;
import com.Peminjaman.Sepeda.dao.EmployeeRepositori;
import com.Peminjaman.Sepeda.dao.LoanRepository;
import com.Peminjaman.Sepeda.dto.customer.CustomerHeaderDto;
import com.Peminjaman.Sepeda.dto.customer.CustomerInsert;
import com.Peminjaman.Sepeda.dto.customer.CustomerUpdate;
import com.Peminjaman.Sepeda.dto.employee.EmployeeHeaderDto;
import com.Peminjaman.Sepeda.dto.employee.EmployeeInsert;
import com.Peminjaman.Sepeda.dto.employee.EmployeeUpdate;
import com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto;
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
public class EmployeeService {

    private EmployeeRepositori employeeRepositori;
    private LoanRepository loanRepository;

    @Autowired
    public EmployeeService(EmployeeRepositori employeeRepositori, LoanRepository loanRepository) {
        this.employeeRepositori = employeeRepositori;
        this.loanRepository = loanRepository;
    }

    public List<EmployeeHeaderDto> findall(){
        Stream<Employee> employeeStream = employeeRepositori.findAll().stream();
        return EmployeeHeaderDto.tolist(employeeStream.collect(Collectors.toList()));
    }

    public EmployeeHeaderDto insert(EmployeeInsert employeeInsert){
        Employee employee = employeeInsert.convert();
        employeeRepositori.save(employee);
        return EmployeeHeaderDto.set(employee);
    }
    public EmployeeUpdate update(Integer id, EmployeeUpdate employeeUpdate){
        Employee olddata =employeeRepositori.getById(id);
        olddata.setAddress(employeeUpdate.getAddress());
        employeeRepositori.save(olddata);
        return EmployeeUpdate.set(olddata);
    }

    public EmployeeHeaderDto delete(Integer employeeID){
        Employee employee =employeeRepositori.findById(employeeID).
                orElseThrow(()-> new EntityNotFoundException("Employee tidak ditemukan"));
        employeeRepositori.delete(employee);
        return EmployeeHeaderDto.set(employee);
    }

    public List<LoanHeaderDto> findLoanBYemployee(Integer employeeID){
        List<Loan> listloant = loanRepository.findbyEmployee(employeeID);
        Stream<LoanHeaderDto> loanStream = LoanHeaderDto.tolist(listloant).stream();
        return loanStream.collect(Collectors.toList());

    }

}
