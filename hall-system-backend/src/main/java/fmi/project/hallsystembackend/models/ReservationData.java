package fmi.project.hallsystembackend.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "reservation_data")
public class ReservationData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Integer reservedHour;

    @Column(nullable = false)
    private LocalDate reservedDate;

    @ManyToOne
    @JoinColumn(name = "lecturer_id", nullable = false)
    private Lecturer reservedBy;

    @ManyToOne
    @JoinColumn(name = "hall_id", nullable = false)
    private Hall reservedHall;

    public ReservationData() {
        this.reservedBy = new Lecturer();
        this.reservedHall = new Hall();
    }

    public ReservationData(Integer reservedHour, LocalDate reservedDate, Lecturer reservedBy, Hall reservedHall) {
        this.reservedHour = reservedHour;
        this.reservedDate = reservedDate;
        this.reservedBy = reservedBy;
        this.reservedHall = reservedHall;
    }

    public ReservationData(Long id, Integer reservedHour, LocalDate reservedDate, Lecturer reservedBy, Hall reservedHall) {
        this.id = id;
        this.reservedHour = reservedHour;
        this.reservedDate = reservedDate;
        this.reservedBy = reservedBy;
        this.reservedHall = reservedHall;
    }

    public Integer getReservedHour() {
        return this.reservedHour;
    }

    public void setReservedHour(Integer reservedHour) {
        this.reservedHour = reservedHour;
    }

    public LocalDate getReservedDate() {
        return this.reservedDate;
    }

    public void setReservedDate(LocalDate reservedDate) {
        this.reservedDate = reservedDate;
    }

    public Lecturer getReservedBy() {
        return this.reservedBy;
    }

    public void addLecturerInfo(Lecturer lecturer) {
        this.reservedBy = lecturer;
    }

    public Hall getReservedHall() {
        return this.reservedHall;
    }

    public void addHallInfo(Hall hall) {
        this.reservedHall = hall;
    }
}
