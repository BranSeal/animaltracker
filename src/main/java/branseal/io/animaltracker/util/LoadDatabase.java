package branseal.io.animaltracker.util;

import branseal.io.animaltracker.model.Animal;
import branseal.io.animaltracker.repository.AnimalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AnimalRepository repository) {
        return args -> {
            Animal a1 = new Animal("Honey", LocalDate.of(2016, 7, 1));
            log.info("Loading " + repository.save(a1));
            Animal a2 = new Animal("Peppa", LocalDate.of(2019, 7, 15));
            log.info("Loading " + repository.save(a2));
        };
    }
}
