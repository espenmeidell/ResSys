package no.espenmeidell.ressys;

import no.espenmeidell.ressys.exceptions.OverbookException;
import no.espenmeidell.ressys.models.ReservableEntity;
import no.espenmeidell.ressys.models.Reservation;
import no.espenmeidell.ressys.repositories.ReservableEntityRepository;
import no.espenmeidell.ressys.repositories.ReservationRepository;
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

import static org.junit.Assert.*;

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
    public void testGetAllReservations() {
        assertEquals(0, reservationService.getAllReservations().size());
        Reservation r1 = new Reservation("", "", "", cabin1, 1, LocalDate.now(), LocalDate.now().plusDays(1));
        reservationRepository.save(r1);
        assertEquals(1, reservationService.getAllReservations().size());
        assertEquals(r1, reservationService.getAllReservations().get(0));
    }

    @Test
    public void testGetAllReservationsOnDate() {
        assertEquals(0, reservationService.getAllReservations().size());
        reservationRepository.save(new Reservation("",
                "",
                "",
                cabin1,
                1,
                LocalDate.of(2017, 12, 10),
                LocalDate.of(2017, 12, 20)));
        assertEquals(0, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 9)).size());
        assertEquals(1, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 10)).size());
        assertEquals(0, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 20)).size());
        reservationRepository.save(new Reservation("",
                "",
                "",
                cabin1,
                1,
                LocalDate.of(2017, 12, 15),
                LocalDate.of(2017, 12, 25)));
        assertEquals(2, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 15)).size());
        assertEquals(1, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 20)).size());
        assertEquals(0, reservationService.getReservationsOnDate(LocalDate.of(2017, 12, 25)).size());
    }

    @Test
    public void testBasicReservationSave() {
        Reservation r1 = new Reservation("",
                "",
                "",
                cabin1,
                1,
                LocalDate.of(2020, 10, 10),
                LocalDate.of(2020, 10, 25));
        assertEquals(r1, reservationService.save(r1));
        assertEquals(1, reservationService.getAllReservations().size());
    }

    @Test(expected = OverbookException.class)
    public void testSingleOverbook(){
        Reservation r1 = new Reservation("",
                "",
                "",
                cabin1,
                11,
                LocalDate.of(2020, 10, 10),
                LocalDate.of(2020, 10, 25));
        reservationService.save(r1);
    }

    @Test(expected = OverbookException.class)
    public void testMultipleOverBook() {
        for (int i = 0; i < 100; i++) {
            Reservation r1 = new Reservation("",
                    "",
                    "",
                    cabin1,
                    1,
                    LocalDate.of(2020, 10, 10),
                    LocalDate.of(2020, 10, 25));
            reservationService.save(r1);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPastReservation() {
        Reservation r1 = new Reservation("",
                "",
                "",
                cabin1,
                5,
                LocalDate.of(2010, 10, 10),
                LocalDate.of(2010, 10, 25));
        reservationService.save(r1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEndBeforeStart() {
        Reservation r1 = new Reservation("",
                "",
                "",
                cabin1,
                5,
                LocalDate.of(2020, 10, 10),
                LocalDate.of(2020, 10, 1));
        reservationService.save(r1);
    }




}
