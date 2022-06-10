package com.Peminjaman.Sepeda.services;

import com.Peminjaman.Sepeda.dao.EmployeeRepositori;
import com.Peminjaman.Sepeda.dao.LoanRepository;
import com.Peminjaman.Sepeda.dto.employee.EmployeeHeaderDto;
import com.Peminjaman.Sepeda.dto.employee.EmployeeInsert;
import com.Peminjaman.Sepeda.dto.employee.EmployeeUpdate;
import com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto;
import com.Peminjaman.Sepeda.dto.loan.LoanInsertDto;
import com.Peminjaman.Sepeda.dto.loan.LoanUpdate;
import com.Peminjaman.Sepeda.entity.Employee;
import com.Peminjaman.Sepeda.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public List<LoanHeaderDto> findall(){
        Stream<Loan> loanStream = loanRepository.findAll().stream();
        return LoanHeaderDto.tolist(loanStream.collect(Collectors.toList()));
    }

    public LoanHeaderDto insert(LoanInsertDto loanInsertDto){

        Loan loan = loanInsertDto.convert();
        loanRepository.save(loan);
        return LoanHeaderDto.set(loan);
    }
    public LoanUpdate update(Integer id, LoanUpdate loanUpdate){
        Loan olddata = loanRepository.getById(id);
        olddata.setTgl_peminjaman(loanUpdate.getTgl_peminjaman());
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
