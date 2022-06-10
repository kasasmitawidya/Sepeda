package com.Peminjaman.Sepeda.dao;

import com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto;
import com.Peminjaman.Sepeda.entity.Employee;
import com.Peminjaman.Sepeda.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan,Integer> {

    @Query("""
            Select new  com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto(pinjam.iDpeminjaman,
            bicycle.sepedaID,cus.customerID,employ.employeeID,pinjam.tgl_peminjaman,
            pinjam.tgl_Pengembalian, pinjam.biayaPeminjaman)
            FROM Loan as pinjam
            INNER JOIN pinjam.customer as cus
            INNER JOIN pinjam.employee as employ
            INNER JOIN pinjam.bicycle as bicycle
            Where employ.employeeID = :employeeID
            """)
    public List<LoanHeaderDto> findLoanByEmployeeID (Integer employeeID);

    @Query(value = """
            SELECT * from Loan
            WHERE EmployeeID = :employeeID)
            """, nativeQuery = true)
    List<Loan> findbyEmployee(Integer employeeID);

    @Query(value= """
            SELECT * from Loan
            WHERE CustomerID = :customerID)
            """, nativeQuery = true)
    List<Loan>  findbyCustomer(Integer customerID);

    @Query(value= """
            SELECT * from Loan
            WHERE SepedaID = :sepedaID)
            """, nativeQuery = true)
    List<Loan>  findbySepeda(Integer sepedaID);

   @Query("""
           Select new  com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto(pinjam.iDpeminjaman,
            bicycle.sepedaID,cus.customerID,employ.employeeID,pinjam.tgl_peminjaman,
            pinjam.tgl_Pengembalian, pinjam.biayaPeminjaman)
            FROM Loan as pinjam
            INNER JOIN pinjam.customer as cus
            INNER JOIN pinjam.employee as employ
            INNER JOIN pinjam.bicycle as bicycle
            Where cus.customerID = :customerID
            """)
    public List<LoanHeaderDto> findLoanByCustomer (Integer customerID);


    @Query("""
             Select new  com.Peminjaman.Sepeda.dto.loan.LoanHeaderDto(pinjam.iDpeminjaman,
            bicycle.sepedaID,cus.customerID,employ.employeeID,pinjam.tgl_peminjaman,
            pinjam.tgl_Pengembalian, pinjam.biayaPeminjaman)
            FROM Loan as pinjam
            INNER JOIN pinjam.customer as cus
            INNER JOIN pinjam.employee as employ
            INNER JOIN pinjam.bicycle as bicycle
            Where bicycle.sepedaID = :sepedaID
            """)
    public List<LoanHeaderDto> findLoanBySepeda (Integer sepedaID);

}
