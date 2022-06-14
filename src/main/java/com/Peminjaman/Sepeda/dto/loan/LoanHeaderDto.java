package com.Peminjaman.Sepeda.dto.loan;

import com.Peminjaman.Sepeda.dto.employee.EmployeeHeaderDto;
import com.Peminjaman.Sepeda.entity.Employee;
import com.Peminjaman.Sepeda.entity.Loan;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class LoanHeaderDto {
    private final Integer iDpeminjaman;
    private final String sepedaID;
    private final Integer customerID;
    private final  Integer employeeID;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private final LocalDate tgl_peminjaman;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private final LocalDate tgl_Pengembalian;
    private final Long biayaPeminjaman;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private final LocalDate perpanjanganWaktu;
    private final Long biayaTambahan;
    private final Long totalBiaya;

    public static LoanHeaderDto set(Loan loan){
        return new LoanHeaderDto(loan.getIDpeminjaman(),
                loan.getSepedaID(),loan.getCustomerID(),loan.getEmployeeID(),
                loan.getTgl_peminjaman(),loan.getTgl_Pengembalian(),loan.getBiayaPeminjaman(),loan.getPerpanjanganWaktu(),loan.getBiayaTambahan(),loan.getTotalBiaya());
    }

    public static List<LoanHeaderDto> tolist (List<Loan> loans){
        List<LoanHeaderDto> result = new ArrayList<>();
        for (var loan : loans){
            result.add(set(loan));
        }
        return  result;
    }
}
