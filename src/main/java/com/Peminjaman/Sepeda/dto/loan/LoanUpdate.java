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
    private  String perpanjanganWaktu;
    private  Long biayaTambahan;

    public static LoanUpdate set (Loan loan){

       return new LoanUpdate(loan.getPerpanjanganWaktu().toString(),loan.getBiayaTambahan());
    }
}
