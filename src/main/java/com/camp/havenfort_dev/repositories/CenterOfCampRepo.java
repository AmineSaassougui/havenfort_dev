package com.camp.havenfort_dev.repositories;

import com.camp.havenfort_dev.entities.CenterOfCamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CenterOfCampRepo extends JpaRepository<CenterOfCamp,Long> {
    @Query("SELECT cen FROM CenterOfCamp cen WHERE cen.nomCenter = :nom and cen.lieuCenter = :lieu")
    CenterOfCamp getCenterOfCampByNomAndLieu(@Param(("nom")) String nomC,@Param(("lieu")) String LieuC);
}
