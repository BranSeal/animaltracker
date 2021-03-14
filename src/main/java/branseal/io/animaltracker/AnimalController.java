package branseal.io.animaltracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class AnimalController {

    private final AnimalRepository animalRepository;

    AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping("/animals")
    List<Animal> all() {
        return animalRepository.findAll();
    }

    @GetMapping("/animals/{id}")
    Animal one(@PathVariable Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new AnimalNotFoundException(id));
    }
}
