package com.Peminjaman.Sepeda.controller;

import com.Peminjaman.Sepeda.RestRespon;
import com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto;
import com.Peminjaman.Sepeda.dto.loan.LoanInsertDto;
import com.Peminjaman.Sepeda.dto.loan.LoanUpdate;
import com.Peminjaman.Sepeda.dto.loan.LoanUpdateStatus;
import com.Peminjaman.Sepeda.services.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("loan")
public class LoanController {

    private LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<RestRespon<List<LoanHeaderDto>>> findall(){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.findall(),
                "Data Berhasil Ditemukan",
                "200"
        ));
    }
    @PostMapping
    private ResponseEntity<RestRespon<LoanHeaderDto>> insert (@RequestBody LoanInsertDto newLoan){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.insert(newLoan),
                "Loan berhasil ditambahkan",
                "201"
        ));
    }

    @PutMapping("{loanID}")
    public ResponseEntity<RestRespon<LoanUpdate>> update(@PathVariable Integer loanID, @RequestBody LoanUpdate update){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.update(loanID,update),
                "Data berhasil di update",
                "200"
        ));
    }

    @DeleteMapping("{loanID}")
    public ResponseEntity<RestRespon<LoanHeaderDto>> delete(@PathVariable Integer loanID){
        return  ResponseEntity.ok().body(new RestRespon<>(
                service.delete(loanID),
                "Data berhasil di hapus",
                "201"
        ));
    }

    @PostMapping("updatestatus/{loanID}")
    public ResponseEntity<RestRespon<LoanUpdateStatus>> updatestatus(@PathVariable Integer loanID, @RequestBody LoanUpdateStatus update){
        return ResponseEntity.ok().body(new RestRespon<>(
                service.updateStatus(loanID,update),
                "Data berhasil di update",
                "200"
        ));
    }
}
