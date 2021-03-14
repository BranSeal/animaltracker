package branseal.io.animaltracker.util;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(Long id) {
        super("Unable to find animal id " + id);
    }
}
