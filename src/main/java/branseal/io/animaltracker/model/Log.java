package branseal.io.animaltracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity(name = "Log")
public class Log {
    private @Id @GeneratedValue Long id;
    private final String timestamp;
    private String type;
    private String value;
    private @ManyToOne Animal animal;

    public Log() {
        this.timestamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss z"));
    }

    public Log(Long id, String timestamp, String type, String value) {
        this.id = id;
        this.timestamp = timestamp;
        this.type = type;
        this.value = value;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(id, log.id) && Objects.equals(timestamp, log.timestamp) && Objects.equals(type, log.type) && Objects.equals(value, log.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, type, value);
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", timestamp='" + timestamp + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
