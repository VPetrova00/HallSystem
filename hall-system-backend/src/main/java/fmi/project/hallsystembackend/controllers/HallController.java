package fmi.project.hallsystembackend.controllers;

import fmi.project.hallsystembackend.services.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
