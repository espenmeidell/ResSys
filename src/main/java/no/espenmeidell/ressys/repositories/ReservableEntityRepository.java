package no.espenmeidell.ressys.repositories;

import no.espenmeidell.ressys.models.ReservableEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservableEntityRepository extends CrudRepository<ReservableEntity, Long> {

    List<ReservableEntity> findByName(String name);

}
