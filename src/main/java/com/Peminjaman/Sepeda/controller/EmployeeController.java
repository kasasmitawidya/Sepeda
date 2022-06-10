package com.Peminjaman.Sepeda.controller;

import com.Peminjaman.Sepeda.RestRespon;
import com.Peminjaman.Sepeda.dto.employee.EmployeeHeaderDto;
import com.Peminjaman.Sepeda.dto.employee.EmployeeInsert;
import com.Peminjaman.Sepeda.dto.employee.EmployeeUpdate;
import com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto;
import com.Peminjaman.Sepeda.dto.loan.LoanInsertDto;
import com.Peminjaman.Sepeda.dto.loan.LoanUpdate;
import com.Peminjaman.Sepeda.services.EmployeeService;
import com.Peminjaman.Sepeda.services.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController{

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<RestRespon<List<EmployeeHeaderDto>>> findall(){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.findall(),
                "Data Berhasil Ditemukan",
                "200"
        ));
    }
    @PostMapping
    private ResponseEntity<RestRespon<EmployeeHeaderDto>> insert (@RequestBody EmployeeInsert newEmployee){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.insert(newEmployee),
                "Data berhasil ditambahkan",
                "201"
        ));
    }


    @PutMapping("{employeeID}")
    public ResponseEntity<RestRespon<EmployeeUpdate>> update(@PathVariable Integer employeeID, @RequestBody EmployeeUpdate update){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.update(employeeID,update),
                "Data berhasil di update",
                "200"
        ));
    }

    @DeleteMapping("{employeeID}")
    public ResponseEntity<RestRespon<EmployeeHeaderDto>> delete(@PathVariable Integer employeeID){
        return  ResponseEntity.ok().body(new RestRespon<>(
                service.delete(employeeID),
                "Data berhasil di hapus",
                "201"
        ));
    }

    @GetMapping("{employeeID}")
    public   ResponseEntity<RestRespon<List<LoanHeaderDto>>> findLoanByEmployeeID(@PathVariable Integer employeeID){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.findLoanBYemployee(employeeID),
                "Data Berhasil Ditemukan",
                "200"
        ));
    }


}
