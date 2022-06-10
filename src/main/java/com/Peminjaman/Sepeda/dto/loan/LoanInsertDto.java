package com.Peminjaman.Sepeda.dto.loan;

import com.Peminjaman.Sepeda.entity.Loan;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class LoanInsertDto {
    private final Integer sepedaID;
    private final Integer customerID;
    private final  Integer employeeID;
    private final String tgl_peminjaman;
    private final String tgl_Pengembalian;
    private final Long biayaPeminjaman;

    public Loan convert(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Loan(sepedaID,customerID,employeeID,LocalDate.parse(tgl_peminjaman,formatter),LocalDate.parse(tgl_Pengembalian,formatter),biayaPeminjaman);
    }

}
