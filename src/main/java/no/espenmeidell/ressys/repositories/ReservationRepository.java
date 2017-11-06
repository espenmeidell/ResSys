package no.espenmeidell.ressys.repositories;

import no.espenmeidell.ressys.models.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, String>{

}
