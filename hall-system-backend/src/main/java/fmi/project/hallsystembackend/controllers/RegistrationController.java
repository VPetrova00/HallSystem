package fmi.project.hallsystembackend.controllers;

import fmi.project.hallsystembackend.models.Lecturer;
import fmi.project.hallsystembackend.models.Status;
import fmi.project.hallsystembackend.repositories.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import fmi.project.hallsystembackend.services.RegistrationService;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/lecturer/register")
    public Status registerLecturer(@Valid @RequestBody Lecturer newLecturer) {
        Status status = this.registrationService.register(newLecturer);
        return status;
    }
}
