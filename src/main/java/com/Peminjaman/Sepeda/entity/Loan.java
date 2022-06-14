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
    private String sepedaID;

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

    @Column(name="Perpanjangan_Waktu")
    private LocalDate perpanjanganWaktu;
    @Column(name="BiayaTambahan")
    private Long biayaTambahan;
    @Column(name="Total_Biaya")
    private Long totalBiaya;


    public Loan(String sepedaID, Integer customerID, Integer employeeID, LocalDate tgl_peminjaman, LocalDate tgl_Pengembalian, Long biayaPeminjaman) {
        this.sepedaID = sepedaID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.tgl_peminjaman = tgl_peminjaman;
        this.tgl_Pengembalian = tgl_Pengembalian;
        this.biayaPeminjaman = biayaPeminjaman;
    }

    public Loan(String sepedaID, Bicycle bicycle, Integer customerID, Customers customer, Integer employeeID, Employee employee, LocalDate tgl_peminjaman, LocalDate tgl_Pengembalian, Long biayaPeminjaman, LocalDate perpanjanganWaktu, Long biayaTambahan, Long totalBiaya) {
        this.sepedaID = sepedaID;
        this.bicycle = bicycle;
        this.customerID = customerID;
        this.customer = customer;
        this.employeeID = employeeID;
        this.employee = employee;
        this.tgl_peminjaman = tgl_peminjaman;
        this.tgl_Pengembalian = tgl_Pengembalian;
        this.biayaPeminjaman = biayaPeminjaman;
        this.perpanjanganWaktu = perpanjanganWaktu;
        this.biayaTambahan = biayaTambahan;
        this.totalBiaya = totalBiaya;
    }
}
