package no.espenmeidell.ressys.services;

import no.espenmeidell.ressys.models.ReservableEntity;
import no.espenmeidell.ressys.repositories.ReservableEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService implements ReservableEntityService{
    private ReservableEntityRepository reservableEntityRepo;

    @Autowired
    public ApplicationService(ReservableEntityRepository reservableEntityRepo) {
        this.reservableEntityRepo = reservableEntityRepo;
    }

    @Override
    public List<ReservableEntity> getAllEntities() {
        return (List<ReservableEntity>) reservableEntityRepo.findAll();
    }
}
