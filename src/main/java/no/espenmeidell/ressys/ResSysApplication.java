package no.espenmeidell.ressys;

import no.espenmeidell.ressys.models.ReservableEntity;
import no.espenmeidell.ressys.models.Reservation;
import no.espenmeidell.ressys.repositories.ReservableEntityRepository;
import no.espenmeidell.ressys.repositories.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalDate;

@SpringBootApplication
public class ResSysApplication {

    private static final Logger log = LoggerFactory.getLogger(ResSysApplication.class);


    public static void main(String[] args) {
		SpringApplication.run(ResSysApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(ReservableEntityRepository entityRepository, ReservationRepository reservationRepository) {
	    return (args) -> {
            ReservableEntity heinfjord = entityRepository.save(new ReservableEntity("Heinfjord", 25));
            ReservableEntity nico = entityRepository.save(new ReservableEntity("Nico", 8));
            ReservableEntity holmsa = entityRepository.save(new ReservableEntity("Holmså", 20));

            log.info("Using Entity findAll():");
            entityRepository.findAll().forEach(reservableEntity -> log.info(reservableEntity.toString()));

            reservationRepository.save(new Reservation("Espen Meidell",
                    "",
                    "",
                    nico,
                    2,
                    LocalDate.now().plusDays(5),
                    LocalDate.now().plusDays(10)));

            log.info("Using Reservation findAll():");
            reservationRepository.findAll().forEach(reservation -> log.info(reservation.toString()));
        };
    }
}
