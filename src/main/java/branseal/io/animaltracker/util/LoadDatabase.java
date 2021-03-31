package branseal.io.animaltracker.util;

import branseal.io.animaltracker.model.Animal;
import branseal.io.animaltracker.model.Log;
import branseal.io.animaltracker.repository.AnimalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AnimalRepository repository) {
        return args -> {
            List<Log> a1Food = new ArrayList<>();
            List<Log> a1Weight = new ArrayList<>();
            List<Log> a1Meds = new ArrayList<>();
            Animal a1 = new Animal("Honey", "03/20/2016", a1Food, a1Weight, a1Meds );
            log.info("Loading " + repository.save(a1));

            List<Log> a2Food = new ArrayList<>();
            List<Log> a2Weight = new ArrayList<>();
            List<Log> a2Meds = new ArrayList<>();
            Animal a2 = new Animal("Peppa", "01/02/2019", a2Food, a2Weight, a2Meds);
            log.info("Loading " + repository.save(a2));
        };
    }
}
