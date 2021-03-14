package branseal.io.animaltracker.repository;

import branseal.io.animaltracker.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
