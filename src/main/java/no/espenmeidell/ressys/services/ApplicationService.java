package no.espenmeidell.ressys.services;

import no.espenmeidell.ressys.models.ReservableEntity;
import no.espenmeidell.ressys.models.Reservation;
import no.espenmeidell.ressys.repositories.ReservableEntityRepository;
import no.espenmeidell.ressys.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService implements ReservableEntityService, ReservationService{
    private ReservableEntityRepository reservableEntityRepo;
    private ReservationRepository reservationRepo;

    @Autowired
    public ApplicationService(ReservableEntityRepository reservableEntityRepo,
                              ReservationRepository reservationRepository) {
        this.reservableEntityRepo = reservableEntityRepo;
        this.reservationRepo = reservationRepository;
    }

    @Override
    public List<ReservableEntity> getAllEntities() {
        return (List<ReservableEntity>) reservableEntityRepo.findAll();
    }

    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepo.findAll();
    }
}
