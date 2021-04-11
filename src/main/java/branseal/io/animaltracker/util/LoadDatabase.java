package branseal.io.animaltracker.util;

import branseal.io.animaltracker.model.Animal;
import branseal.io.animaltracker.model.Log;
import branseal.io.animaltracker.repository.AnimalRepository;
import branseal.io.animaltracker.repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AnimalRepository animalRepository, LogRepository logsRepository) {
        return args -> {
            Animal a1 = new Animal("Honey", "03/20/2016");
            a1.logFood(new Log("Wellness Core Indoor Dry Food", "45 grams"));
            a1.logWeight(new Log("", "9.8 lbs"));
            log.info("Loading " + animalRepository.save(a1));

            Animal a2 = new Animal("Peppa", "01/02/2019");
            a2.logFood(new Log("Blue Buffalo Wet Food", "1/2 can"));
            a2.logFood(new Log("Whole Hearted Chicken", "1/2 can"));
            a2.logWeight(new Log("", "8.5 lbs"));
            log.info("Loading " + animalRepository.save(a2));

            Animal a3 = new Animal("Boo", "03/20/2019");
            a3.logFood(new Log("Hills Science", "50 grams"));
            a3.logWeight(new Log("", "10 lbs"));
            log.info("Loading " + animalRepository.save(a3));
        };
    }
}
