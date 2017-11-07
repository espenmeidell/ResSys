package no.espenmeidell.ressys.services;

import no.espenmeidell.ressys.models.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservations();

    List<Reservation> getReservationsOnDate(LocalDate localDate);

    Reservation save(Reservation reservation);

}
