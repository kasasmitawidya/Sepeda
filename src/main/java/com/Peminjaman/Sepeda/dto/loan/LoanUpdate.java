package com.Peminjaman.Sepeda.dto.loan;

import com.Peminjaman.Sepeda.entity.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanUpdate {
    private  LocalDate tgl_peminjaman;
    private  LocalDate tgl_Pengembalian;
    private  Long biayaPeminjaman;

    public static LoanUpdate set (Loan loan){
       return new LoanUpdate(loan.getTgl_peminjaman(),loan.getTgl_Pengembalian(),loan.getBiayaPeminjaman());
    }
}
