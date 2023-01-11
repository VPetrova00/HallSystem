package fmi.project.hallsystembackend.controllers;

import fmi.project.hallsystembackend.models.Lecturer;
import fmi.project.hallsystembackend.services.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/lecturers")
public class LecturerController {

    private final LecturerService lecturerService;

    @Autowired
    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/{lecturerId}/reserve/{hallId}/{fromHour}")
    public void reserveHall(@PathVariable Long lecturerId, @PathVariable Long hallId, @PathVariable int fromHour, @RequestParam(name = "reservationDate") @DateTimeFormat(pattern = "dd.MM.yyyy") Date reservationDate) {
        this.lecturerService.reserveHall(lecturerId, hallId, fromHour, reservationDate);
    }

    @GetMapping("/{name}")
    public Lecturer getLecturerByName(@PathVariable String name) {
        return this.lecturerService.findLecturerByName(name);
    }

    @GetMapping("/")
    public Set<Lecturer> getAllLecturers() {
        return this.lecturerService.findAllLecturers();
    }
}
