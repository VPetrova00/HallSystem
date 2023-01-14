package fmi.project.hallsystembackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lecturers")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "reservedBy")
    @JsonIgnore
    private Set<ReservationData> reservationData;

    public Lecturer() {
        this.reservationData = new HashSet<>();
    }

    public Lecturer(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ReservationData> getReservationData() {
        return this.reservationData;
    }

    public void addReservationData(ReservationData reservationData) {
        this.reservationData.add(reservationData);
    }

    public void deleteReservationData(ReservationData reservationData) { this.reservationData.remove(reservationData); }
}
