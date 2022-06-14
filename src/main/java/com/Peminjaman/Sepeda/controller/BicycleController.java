package com.Peminjaman.Sepeda.controller;

import com.Peminjaman.Sepeda.RestRespon;
import com.Peminjaman.Sepeda.dto.bicycle.BicycleHeaderDto;
import com.Peminjaman.Sepeda.dto.bicycle.BicycleInsert;
import com.Peminjaman.Sepeda.dto.bicycle.BicycleUpdate;
import com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto;
import com.Peminjaman.Sepeda.dto.loan.LoanInsertDto;
import com.Peminjaman.Sepeda.dto.loan.LoanUpdate;
import com.Peminjaman.Sepeda.services.BicycleService;
import com.Peminjaman.Sepeda.services.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("bicycle")
public class BicycleController {

    private BicycleService service;

    public BicycleController(BicycleService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<RestRespon<List<BicycleHeaderDto>>> findall(){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.findall(),
                "Data Berhasil Ditemukan",
                "200"
        ));
    }
    @PostMapping
    private ResponseEntity<RestRespon<BicycleHeaderDto>> insert (@RequestBody BicycleInsert newBicycle){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.insert(newBicycle),
                "Loan berhasil ditambahkan",
                "201"
        ));
    }

    @PutMapping("{bicycleID}")
    public ResponseEntity<RestRespon<BicycleUpdate>> update(@PathVariable String bicycleID, @RequestBody BicycleUpdate update){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.update(bicycleID,update),
                "Data berhasil di update",
                "200"
        ));
    }

    @DeleteMapping("{bicycleID}")
    public ResponseEntity<RestRespon<BicycleHeaderDto>> delete(@PathVariable String bicycleID){
        return  ResponseEntity.ok().body(new RestRespon<>(
                service.delete(bicycleID),
                "Data berhasil di hapus",
                "201"
        ));
    }

    @GetMapping("{bicycleID}")
    public   ResponseEntity<RestRespon<List<LoanHeaderDto>>> findLoanByBicycle(@PathVariable Integer bicycleID){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.findLoanBYBicycle(bicycleID),
                "Data Berhasil Ditemukan",
                "200"
        ));
    }
}
