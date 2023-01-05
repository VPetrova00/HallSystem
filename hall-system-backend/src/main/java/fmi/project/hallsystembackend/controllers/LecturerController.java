package fmi.project.hallsystembackend.controllers;

import fmi.project.hallsystembackend.models.Hall;
import fmi.project.hallsystembackend.repositories.HallRepository;
import fmi.project.hallsystembackend.repositories.LecturerRepository;
import fmi.project.hallsystembackend.services.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {
    private final HallRepository hallRepository;

    private final LecturerRepository lecturerRepository;

    private final LecturerService lecturerService;

    @Autowired
    public LecturerController(HallRepository hallRepository, LecturerRepository lecturerRepository, LecturerService lecturerService) {
        this.hallRepository = hallRepository;
        this.lecturerRepository = lecturerRepository;
        this.lecturerService = lecturerService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/{lecturerId}/reserve/{hallId}/{fromHour}")
    public void reserveHall(@PathVariable Long lecturerId, @PathVariable Long hallId, @PathVariable int fromHour) {
        this.lecturerService.reserveHall(lecturerId, hallId, fromHour);
    }
}
