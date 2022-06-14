package com.Peminjaman.Sepeda.dto.bicycle;

import com.Peminjaman.Sepeda.entity.Bicycle;
import lombok.Data;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
public class BicycleHeaderDto {
    private final String sepedaID;
    private final String jenisSepeda;
    private final String merekSepeda;
    private final String warnaSepeda;
    private final String status;

    public static BicycleHeaderDto set(Bicycle bicycle){
        return new BicycleHeaderDto(bicycle.getSepedaID(),bicycle.getJenisSepeda(),bicycle.getMerekSepeda(),bicycle.getWarnaSepeda(),bicycle.getStatus());
    }

    public static List<BicycleHeaderDto> tolist (List<Bicycle> bicycles){
        List<BicycleHeaderDto> result = new ArrayList<>();
        for (var bicycle : bicycles){
            result.add(set(bicycle));
        }
        return  result;
    }
}

