package fmi.project.hallsystembackend.controllers;

import fmi.project.hallsystembackend.repositories.HallRepository;
import fmi.project.hallsystembackend.repositories.LecturerRepository;
import fmi.project.hallsystembackend.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fmi.project.hallsystembackend.models.Hall;

import java.util.Set;

@RestController
@RequestMapping("/hall")
public class HallController {
    private final HallService hallService;

    @Autowired
    public HallController(HallService hallService) {
        this.hallService = hallService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public Set<Hall> getAllHalls() {
        return this.hallService.findAllHalls();
    }

    @GetMapping("/{id}")
    public Hall getHallById(@PathVariable Long id) {
        return this.hallService.findHallById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lecturer/{name}")
    public Set<Hall> getReservedHalls(@PathVariable String name) {
        return this.hallService.getReservedHalls(name);
    }

    @GetMapping("/freeIntervals/{id}")
    public Set<Integer> getFreeIntervals(@PathVariable Long id) {
        return this.hallService.getFreeIntervals(id);
    }

}


