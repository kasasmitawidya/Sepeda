package com.Peminjaman.Sepeda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Peminjaman")
public class Loan {
    @Id
    @Column(name="IDpeminjaman")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iDpeminjaman;

    @Column(name="SepedaID")
    private Integer sepedaID;

    @ManyToOne
    @JoinColumn(name="SepedaID", insertable=false, updatable=false)
    @Getter @Setter private Bicycle bicycle;

    @Column(name="CustomerID")
    private Integer customerID;

    @ManyToOne
    @JoinColumn(name="CustomerID", insertable=false, updatable=false)
    @Getter @Setter private Customers customer;

    @Column(name="EmployeeID")
    private Integer employeeID;

    @ManyToOne
    @JoinColumn(name="EmployeeID", insertable=false, updatable=false)
    @Getter @Setter private Employee employee;

    @Column(name="Tgl_peminjaman")
    private LocalDate tgl_peminjaman;
    @Column(name="Tgl_Pengembalian")
    private LocalDate tgl_Pengembalian;
    @Column(name="BiayaPeminjaman")
    private Long biayaPeminjaman;

    public Loan(Integer sepedaID, Integer customerID, Integer employeeID, LocalDate tgl_peminjaman, LocalDate tgl_Pengembalian, Long biayaPeminjaman) {
        this.sepedaID = sepedaID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.tgl_peminjaman = tgl_peminjaman;
        this.tgl_Pengembalian = tgl_Pengembalian;
        this.biayaPeminjaman = biayaPeminjaman;
    }
}
