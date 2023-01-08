package fmi.project.hallsystembackend.controllers;

import fmi.project.hallsystembackend.models.Lecturer;
import fmi.project.hallsystembackend.services.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {

    private final LecturerService lecturerService;

    @Autowired
    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/{lecturerId}/reserve/{hallId}/{fromHour}")
    public void reserveHall(@PathVariable Long lecturerId, @PathVariable Long hallId, @PathVariable int fromHour) {
        this.lecturerService.reserveHall(lecturerId, hallId, fromHour);
    }

    @GetMapping("/{name}")
    public Lecturer getLecturerByName(@PathVariable String name) {
        return this.lecturerService.findLecturerByName(name);
    }

}
