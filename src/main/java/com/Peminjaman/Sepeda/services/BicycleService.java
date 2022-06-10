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
        Bicycle bicycle= bicycleInsert.convert();
        bicycleRepositori.save(bicycle);
        return BicycleHeaderDto.set(bicycle);
    }
    public BicycleUpdate update(Integer id, BicycleUpdate bicycleUpdate){
        Bicycle oldBicycle =bicycleRepositori.getById(id);
        oldBicycle.setWarnaSepeda(bicycleUpdate.getWarnaSepeda());
        bicycleRepositori.save(oldBicycle);
        return BicycleUpdate.set(oldBicycle);
    }

    public BicycleHeaderDto delete(Integer bicycleID){
        Bicycle bicycle =bicycleRepositori.findById(bicycleID).
                orElseThrow(()-> new EntityNotFoundException("Bicycle tidak ditemukan"));
        bicycleRepositori.delete(bicycle);
        return BicycleHeaderDto.set(bicycle);
    }

    public List<LoanHeaderDto> findLoanBYBicycle(Integer bicycleID){
        Stream<LoanHeaderDto> loanStream = loanRepository.findLoanBySepeda(bicycleID).stream();
        return loanStream.collect(Collectors.toList());

    }
}
