package no.espenmeidell.ressys.repositories;

import no.espenmeidell.ressys.models.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, String>{
    List<Reservation> findAllByFromDateBeforeAndToDateAfter(LocalDate fromDate, LocalDate toDate);
}
