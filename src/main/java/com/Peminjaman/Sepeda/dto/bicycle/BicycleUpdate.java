package com.Peminjaman.Sepeda.dto.bicycle;

import com.Peminjaman.Sepeda.dto.customer.CustomerUpdate;
import com.Peminjaman.Sepeda.entity.Bicycle;
import com.Peminjaman.Sepeda.entity.Customers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BicycleUpdate {
    private String warnaSepeda;


    public static BicycleUpdate set(Bicycle oldBicycle) {
        return new BicycleUpdate(oldBicycle.getWarnaSepeda());
    }
}
