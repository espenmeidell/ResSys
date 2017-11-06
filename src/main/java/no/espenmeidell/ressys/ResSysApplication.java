package no.espenmeidell.ressys;

import no.espenmeidell.ressys.models.ReservableEntity;
import no.espenmeidell.ressys.repositories.ReservableEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ResSysApplication {

    private static final Logger log = LoggerFactory.getLogger(ResSysApplication.class);


    public static void main(String[] args) {
		SpringApplication.run(ResSysApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(ReservableEntityRepository repo) {
	    return (args) -> {
	        repo.save(new ReservableEntity("Heinfjord", 25));
            repo.save(new ReservableEntity("Nico", 8));
            repo.save(new ReservableEntity("Holmså", 20));

            log.info("Using findAll():");
            repo.findAll().forEach(reservableEntity -> log.info(reservableEntity.toString()));
        };
    }
}
