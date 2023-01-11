package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Lecturer;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;


public interface LecturerService {
    void reserveHall(Long lecturerId, Long hallToReserve, int fromHour, LocalDate reservationDate);

    Lecturer findLecturerByName(String name);

    Set<Lecturer> findAllLecturers();
}
