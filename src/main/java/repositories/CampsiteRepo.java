package repositories;

import entities.Campsite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampsiteRepo extends JpaRepository<Campsite,Long> {
}
