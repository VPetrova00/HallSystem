package fmi.project.hallsystembackend.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lecturers")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "lecturers_halls", joinColumns = { @JoinColumn(name = "lecturer_id") },
    inverseJoinColumns = { @JoinColumn(name = "hall_id") })
    private Set<Hall> reservedHalls;

    public Lecturer() {}

    public Lecturer(Long id, String name, String email, String password, Set<Hall> reservedHalls) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.reservedHalls = reservedHalls;
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

    public Set<Hall> getReservedHalls() {
        return reservedHalls;
    }

    public void setReservedHalls(Set<Hall> reservedHalls) {
        this.reservedHalls = reservedHalls;
    }
}
