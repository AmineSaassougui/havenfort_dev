package com.camp.havenfort_dev.Repositories;

import com.camp.havenfort_dev.entities.ActivityLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ActivityLikeRepo extends JpaRepository<ActivityLike,Long> {
    @Query("SELECT al.react FROM ActivityLike al INNER JOIN al.user ali INNER JOIN al.activity ala WHERE ali.id=:idUser and ala.idActivity=:idActivity")
    public String reactIs(Long idUser, Long idActivity);


    @Query("SELECT ali.idActivityLike FROM ActivityLike ali INNER join ali.user al INNER JOIN ali.activity ala WHERE al.id =:idUser and ala.idActivity=:idActivity")
    public Long deleteActivityLikeBy(Long idUser, Long idActivity);
}








