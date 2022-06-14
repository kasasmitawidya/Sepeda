package com.Peminjaman.Sepeda.services;

import com.Peminjaman.Sepeda.dao.BicycleRepositori;
import com.Peminjaman.Sepeda.dao.LoanRepository;
import com.Peminjaman.Sepeda.dto.bicycle.BicycleHeaderDto;
import com.Peminjaman.Sepeda.dto.bicycle.BicycleInsert;
import com.Peminjaman.Sepeda.dto.bicycle.BicycleUpdate;
import com.Peminjaman.Sepeda.dto.employee.EmployeeHeaderDto;
import com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto;
import com.Peminjaman.Sepeda.entity.Bicycle;
import com.Peminjaman.Sepeda.entity.Employee;
import com.Peminjaman.Sepeda.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BicycleService {

    private BicycleRepositori bicycleRepositori;
    private LoanRepository loanRepository;

    @Autowired
    public BicycleService(BicycleRepositori bicycleRepositori, LoanRepository loanRepository) {
        this.bicycleRepositori = bicycleRepositori;
        this.loanRepository = loanRepository;
    }

    public List<BicycleHeaderDto> findall(){
        Stream<Bicycle> bicycleStream = bicycleRepositori.findAll().stream();
        return BicycleHeaderDto.tolist(bicycleStream.collect(Collectors.toList()));
  }

    public BicycleHeaderDto insert(BicycleInsert bicycleInsert){
        long totalSepeda = bicycleRepositori.totalsepeda(bicycleInsert.getJenisSepeda());
        Bicycle bicycle= bicycleInsert.convert();
        bicycle.setSepedaID(String.format("%s%d",bicycleInsert.getJenisSepeda(),totalSepeda+1));
        bicycleRepositori.save(bicycle);
        return BicycleHeaderDto.set(bicycle);
    }
    public BicycleUpdate update(String id, BicycleUpdate bicycleUpdate){
        Bicycle oldBicycle =bicycleRepositori.getById(id);
        oldBicycle.setWarnaSepeda(bicycleUpdate.getWarnaSepeda());
        bicycleRepositori.save(oldBicycle);
        return BicycleUpdate.set(oldBicycle);
    }

    public BicycleHeaderDto delete(String bicycleID){
        Bicycle bicycle =bicycleRepositori.findById(bicycleID).
                orElseThrow(()-> new EntityNotFoundException("Bicycle tidak ditemukan"));
        bicycleRepositori.delete(bicycle);
        return BicycleHeaderDto.set(bicycle);
    }

    public List<LoanHeaderDto> findLoanBYBicycle(Integer bicycleID){
        List<Loan> listloant = loanRepository.findbySepeda(bicycleID);
        Stream<LoanHeaderDto> loanStream = LoanHeaderDto.tolist(listloant).stream();
        return loanStream.collect(Collectors.toList());

    }
}
