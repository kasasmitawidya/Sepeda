package com.Peminjaman.Sepeda.services;

import com.Peminjaman.Sepeda.dao.BicycleRepositori;
import com.Peminjaman.Sepeda.dao.EmployeeRepositori;
import com.Peminjaman.Sepeda.dao.LoanRepository;
import com.Peminjaman.Sepeda.dto.employee.EmployeeHeaderDto;
import com.Peminjaman.Sepeda.dto.employee.EmployeeInsert;
import com.Peminjaman.Sepeda.dto.employee.EmployeeUpdate;
import com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto;
import com.Peminjaman.Sepeda.dto.loan.LoanInsertDto;
import com.Peminjaman.Sepeda.dto.loan.LoanUpdate;
import com.Peminjaman.Sepeda.entity.Bicycle;
import com.Peminjaman.Sepeda.entity.Employee;
import com.Peminjaman.Sepeda.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LoanService {

    private LoanRepository loanRepository;
    private BicycleRepositori bicycleRepositori;

    @Autowired
    public LoanService(LoanRepository loanRepository, BicycleRepositori bicycleRepositori) {
        this.loanRepository = loanRepository;
        this.bicycleRepositori = bicycleRepositori;
    }

    public List<LoanHeaderDto> findall(){
        Stream<Loan> loanStream = loanRepository.findAll().stream();
        return LoanHeaderDto.tolist(loanStream.collect(Collectors.toList()));
    }

    public LoanHeaderDto insert(LoanInsertDto loanInsertDto){
        Bicycle sepeda = bicycleRepositori.findById(loanInsertDto.getSepedaID()).orElseThrow(()-> new EntityNotFoundException("Sepeda tidak ditemukan"));
        String statusSepeda = bicycleRepositori.statusSepeda(loanInsertDto.getSepedaID());
        if(statusSepeda.equals("Available")){
            Loan loan = loanInsertDto.convert();
            loan.setTotalBiaya(loan.getBiayaPeminjaman());
            loanRepository.save(loan);
            sepeda.setStatus("Not Available");
            sepeda.getStatus();
            bicycleRepositori.save(sepeda);
            return LoanHeaderDto.set(loan);
        }
        return null;

    }
    public LoanUpdate update(Integer id, LoanUpdate loanUpdate){
        Loan olddata = loanRepository.getById(id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        olddata.setPerpanjanganWaktu(LocalDate.parse(loanUpdate.getPerpanjanganWaktu(),formatter));
        olddata.setBiayaTambahan(loanUpdate.getBiayaTambahan());
        olddata.setTotalBiaya(olddata.getBiayaPeminjaman()+loanUpdate.getBiayaTambahan());
        loanRepository.save(olddata);
        return LoanUpdate.set(olddata);
    }

    public LoanHeaderDto delete(Integer loanID){
        Loan loan =loanRepository.findById(loanID).
                orElseThrow(()-> new EntityNotFoundException("Employee tidak ditemukan"));
        loanRepository.delete(loan);
        return LoanHeaderDto.set(loan);
    }
}
