package com.Peminjaman.Sepeda.dao;

import com.Peminjaman.Sepeda.entity.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BicycleRepositori extends JpaRepository<Bicycle,String> {

    @Query(value = """
                 SELECT count(sepeda.SepedaID)
                       FROM Bicycle as sepeda
                       WHERE sepeda.JenisSepeda = :sepeda
            """, nativeQuery=true)
    long totalsepeda (String sepeda);

    @Query(value= """
               SELECT sepeda.Status
               FROM Bicycle as sepeda
               WHERE sepeda.SepedaID = :sepedaID
                        """, nativeQuery=true)
    String statusSepeda(String sepedaID );

}
