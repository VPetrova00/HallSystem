package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Lecturer;

import java.util.Date;
import java.util.Set;


public interface LecturerService {
    void reserveHall(Long lecturerId, Long hallToReserve, int fromHour, Date reservationDate);

    Lecturer findLecturerByName(String name);

    Set<Lecturer> findAllLecturers();
}
