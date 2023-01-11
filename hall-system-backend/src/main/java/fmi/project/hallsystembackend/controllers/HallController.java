package fmi.project.hallsystembackend.controllers;

import fmi.project.hallsystembackend.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import fmi.project.hallsystembackend.models.Hall;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/halls")
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Hall getHallById(@PathVariable Long id) {
        return this.hallService.findHallById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/lecturer/{name}/reservedHalls")
    public Set<Object[]> getReservedHalls(@PathVariable String name) {
        return this.hallService.getReservedHalls(name);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/freeIntervals/hall/{id}")
    public Set<Integer> getFreeIntervals(@PathVariable Long id, @RequestParam(name = "date") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return this.hallService.getFreeIntervals(id, date);
    }
}


