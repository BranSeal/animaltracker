package branseal.io.animaltracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AnimaltrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimaltrackerApplication.class, args);
	}

}
