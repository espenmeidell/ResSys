package no.espenmeidell.ressys.services;

import no.espenmeidell.ressys.models.ReservableEntity;

import java.time.LocalDate;
import java.util.List;

public interface ReservableEntityService {

    List<ReservableEntity> getAllEntities();

    int getNumberOfAvailablePlacesOnDate(ReservableEntity entity, LocalDate date);

}
