package com.Peminjaman.Sepeda.dto.loan;

import com.Peminjaman.Sepeda.entity.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanUpdateStatus {
    private  String status;

    public static LoanUpdateStatus set (Loan loan){
        return new LoanUpdateStatus(loan.getStatusPeminjaman());
    }
}
