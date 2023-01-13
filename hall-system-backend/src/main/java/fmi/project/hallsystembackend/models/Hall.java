package fmi.project.hallsystembackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "halls")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int hallNumber;

    @Column(nullable = false)
    private String facultyName;

    @Column
    private int capacity;

    @Column
    private boolean isComputerHall;

    @Column
    private boolean hasProjector;

    @OneToMany(mappedBy = "reservedHall")
    @JsonIgnore
    private Set<ReservationData> reservationData;

    public Hall() {
        this.reservationData = new HashSet<>();
    }

    public Hall(Long id, int hallNumber, String facultyName, int capacity, boolean isComputerHall, boolean hasProjector) {
        this.id = id;
        this.hallNumber = hallNumber;
        this.facultyName = facultyName;
        this.capacity = capacity;
        this.isComputerHall = isComputerHall;
        this.hasProjector = hasProjector;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isComputerHall() {
        return isComputerHall;
    }

    public void setComputerHall(boolean computerHall) {
        isComputerHall = computerHall;
    }

    public boolean isHasProjector() {
        return hasProjector;
    }

    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public Set<ReservationData> getReservationData() {
        return this.reservationData;
    }

    public void addReservationData(ReservationData reservationData) {
        this.reservationData.add(reservationData);
    }

    public void deleteReservationData(ReservationData reservationData) { this.reservationData.remove(reservationData); }
}
