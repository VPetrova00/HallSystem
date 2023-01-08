package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Lecturer;
import fmi.project.hallsystembackend.models.Status;

public interface RegistrationService {
    Status register(Lecturer newLecturer);
}
