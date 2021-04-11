package branseal.io.animaltracker.repository;

import branseal.io.animaltracker.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long> {

}
