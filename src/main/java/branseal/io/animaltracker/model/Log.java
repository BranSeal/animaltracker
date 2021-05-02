package branseal.io.animaltracker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "log")
@EntityListeners(AuditingEntityListener.class)
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="log_seq")
    @SequenceGenerator(name = "log_seq", sequenceName = "log_seq_table")
    private Long id;

    private @CreatedDate Instant createdDate;

    private String type;

    private String value;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonBackReference
    private Animal animal;

    public Log() {}

    public Log(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
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
                && Objects.equals(createdDate, log.createdDate)
                && Objects.equals(type, log.type)
                && Objects.equals(value, log.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdDate, type, value, animal);
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", createdDate='" + createdDate + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
