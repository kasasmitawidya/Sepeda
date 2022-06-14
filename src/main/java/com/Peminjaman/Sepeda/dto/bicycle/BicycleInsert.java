package com.Peminjaman.Sepeda.dto.bicycle;

import com.Peminjaman.Sepeda.entity.Bicycle;
import com.Peminjaman.Sepeda.entity.Customers;
import lombok.Data;

@Data
public class BicycleInsert {
    private final String jenisSepeda;
    private final String merekSepeda;
    private final String warnaSepeda;

    public Bicycle convert(){
        return new Bicycle(jenisSepeda,merekSepeda,warnaSepeda); }
}
