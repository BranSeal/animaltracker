package branseal.io.animaltracker.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "animal")
public class Animal {
    private @Id @GeneratedValue Long id;

    private String name;

    private String dob;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable
    private List<Log> feedingLogs;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable
    private List<Log> weightLogs;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable
    private List<Log> medicationLogs;

    public Animal() {}

    public Animal(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public List<Log> getFeedingLogs() {
        return feedingLogs;
    }

    public void setFeedingLogs(List<Log> feedingLogs) {
        this.feedingLogs = feedingLogs;
    }

    public List<Log> getWeightLogs() {
        return weightLogs;
    }

    public void setWeightLogs(List<Log> weightLogs) {
        this.weightLogs = weightLogs;
    }

    public List<Log> getMedicationLogs() {
        return medicationLogs;
    }

    public void setMedicationLogs(List<Log> medicationLogs) {
        this.medicationLogs = medicationLogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id)
                && Objects.equals(name, animal.name)
                && Objects.equals(dob, animal.dob)
                && Objects.equals(feedingLogs,animal.feedingLogs)
                && Objects.equals(weightLogs, animal.weightLogs)
                && Objects.equals(medicationLogs, animal.medicationLogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dob, feedingLogs, weightLogs, medicationLogs);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", feedingLogs=" + feedingLogs +
                ", weightLogs=" + weightLogs +
                ", medicationLogs=" + medicationLogs +
                '}';
    }

    public void logFood(Log log) {
        if (feedingLogs == null) {
            feedingLogs = new ArrayList<>();
        }
        feedingLogs.add(log);
        log.setAnimal(this);
    }

    public void logWeight(Log log) {
        if (weightLogs == null) {
            weightLogs = new ArrayList<>();
        }
        weightLogs.add(log);
        log.setAnimal(this);
    }

    public void logMedication(Log log) {
        if (medicationLogs == null) {
            medicationLogs = new ArrayList<>();
        }
        medicationLogs.add(log);
        log.setAnimal(this);
    }
}
