package branseal.io.animaltracker;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(Long id) {
        super("Unable to find animal id " + id);
    }
}
