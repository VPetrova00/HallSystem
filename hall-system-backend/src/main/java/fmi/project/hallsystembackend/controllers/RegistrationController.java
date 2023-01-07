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

    private final LecturerRepository lecturerRepository;
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(LecturerRepository lecturerRepository, RegistrationService registrationService) {
        this.lecturerRepository = lecturerRepository;
        this.registrationService = registrationService;
    }

    @PostMapping("/lecturer/register")
    public Status registerLecturer(@Valid @RequestBody Lecturer newLecturer) {
        List<Lecturer> lecturers = lecturerRepository.findAll();
        System.out.println("New lecturer: " + newLecturer.toString());
        for (Lecturer lecturer : lecturers) {
            System.out.println("Registered lecturer: " + newLecturer.getName());
            if (lecturer.equals(newLecturer)) {
                System.out.println("Lecturer already exists!");
                return Status.LECTURER_ALREADY_EXISTS;
            }
        }
        lecturerRepository.save(newLecturer);
        return Status.SUCCESS;
    }
}
