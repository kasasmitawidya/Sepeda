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
    private  String sepedaID;
    @Column(name="JenisSepeda")
    private  String jenisSepeda;
    @Column(name="MerekSepeda")
    private  String merekSepeda;
    @Column(name="WarnaSepeda")
    private  String warnaSepeda;
    @Column(name ="Status")
    private String status;

    public Bicycle(String jenisSepeda,String merekSepeda, String warnaSepeda) {
        this.merekSepeda = merekSepeda;
        this.jenisSepeda = jenisSepeda;
        this.warnaSepeda = warnaSepeda;
        this.status ="Available";
    }
}
