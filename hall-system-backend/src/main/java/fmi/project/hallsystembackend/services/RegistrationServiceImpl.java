package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Lecturer;
import fmi.project.hallsystembackend.models.Status;
import fmi.project.hallsystembackend.repositories.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    private final LecturerRepository lecturerRepository;

    @Autowired
    public RegistrationServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }
    @Override
    public Status register(Lecturer newLecturer) {
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
