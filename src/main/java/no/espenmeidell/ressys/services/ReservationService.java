package no.espenmeidell.ressys.services;

import no.espenmeidell.ressys.models.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {

    public List<Reservation> getAllReservations();

    public List<Reservation> getReservationsOnDate(LocalDate localDate);

}
