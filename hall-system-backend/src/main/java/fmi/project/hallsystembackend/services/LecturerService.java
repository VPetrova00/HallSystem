package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Lecturer;


public interface LecturerService {
    void reserveHall(Long lecturerId, Long hallToReserve, int fromHour);

    Lecturer findLecturerByName(String name);
}
