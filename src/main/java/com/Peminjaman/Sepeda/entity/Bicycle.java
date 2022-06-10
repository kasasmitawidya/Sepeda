package com.Peminjaman.Sepeda.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Bicycle")
public class Bicycle {

    @Id
    @Column(name="SepedaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer sepedaID;
    @Column(name="JenisSepeda")
    private  String jenisSepeda;
    @Column(name="WarnaSepeda")
    private  String warnaSepeda;

    public Bicycle(String jenisSepeda, String warnaSepeda) {
        this.jenisSepeda = jenisSepeda;
        this.warnaSepeda = warnaSepeda;
    }
}
