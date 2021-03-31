package branseal.io.animaltracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity(name = "Log")
public class Log {
    private @Id @GeneratedValue Long id;
    // ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss z"))
    private String timestamp;
    private String type;
    private String value;
    private @ManyToOne Animal animal;

    public Log() {}

    public Log(String timestamp, String type, String value, Animal animal) {
        this.timestamp = timestamp;
        this.type = type;
        this.value = value;
        this.animal = animal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(id, log.id)
                && Objects.equals(timestamp, log.timestamp)
                && Objects.equals(type, log.type)
                && Objects.equals(value, log.value)
                && Objects.equals(animal, log.animal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, type, value, animal);
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", timestamp='" + timestamp + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", animal=" + animal +
                '}';
    }
}
