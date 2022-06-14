package com.Peminjaman.Sepeda.dto.bicycle;

import com.Peminjaman.Sepeda.entity.Bicycle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BicycleStatusUpdate {
    private String status;
    public static BicycleUpdate set(Bicycle oldBicycle) {
        return new BicycleUpdate(oldBicycle.getStatus());
    }

}
