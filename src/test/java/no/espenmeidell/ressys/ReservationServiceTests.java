package no.espenmeidell.ressys;

import no.espenmeidell.ressys.models.ReservableEntity;
import no.espenmeidell.ressys.models.Reservation;
import no.espenmeidell.ressys.repositories.ReservableEntityRepository;
import no.espenmeidell.ressys.repositories.ReservationRepository;
import no.espenmeidell.ressys.services.ReservableEntityService;
import no.espenmeidell.ressys.services.ReservationService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class ReservationServiceTests {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservableEntityRepository reservableEntityRepository;

    ReservableEntity cabin1;
    ReservableEntity cabin2;

    @Before
    public void setup() {
        cabin1 = reservableEntityRepository.save(new ReservableEntity("Cabin1", 10));
        cabin2 = reservableEntityRepository.save(new ReservableEntity("Cabin2", 20));
    }

    @After
    public void clear() {
        reservationRepository.deleteAll();
        reservableEntityRepository.deleteAll();
    }

    @Test
    public void checkGetAllReservations() {
        Assert.assertEquals(0, reservationService.getAllReservations().size());
        Reservation r1 = new Reservation("", "", "", cabin1, 1, LocalDate.now(), LocalDate.now().plusDays(1));
        reservationRepository.save(r1);
        Assert.assertEquals(1, reservationService.getAllReservations().size());
        Assert.assertEquals(r1, reservationService.getAllReservations().get(0));
    }

    @Test
    public void checkGetAllReservationsOnDate() {
        Assert.assertEquals(0, reservationService.getAllReservations().size());
        reservationRepository.save(new Reservation("",
                "",
                "",
                cabin1,
                1,
                LocalDate.of(2017, 12, 10),
                LocalDate.of(2017, 12, 20)));
        Assert.assertEquals(0, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 9)).size());
        Assert.assertEquals(1, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 10)).size());
        Assert.assertEquals(0, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 20)).size());
        reservationRepository.save(new Reservation("",
                "",
                "",
                cabin1,
                1,
                LocalDate.of(2017, 12, 15),
                LocalDate.of(2017, 12, 25)));
        Assert.assertEquals(2, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 15)).size());
        Assert.assertEquals(1, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 20)).size());
        Assert.assertEquals(0, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 25)).size());

    }


}
