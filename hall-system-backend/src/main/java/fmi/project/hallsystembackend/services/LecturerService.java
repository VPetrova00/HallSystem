package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Hall;

public interface LecturerService {
    void reserveHall(Long lecturerId, Long hallToReserve, int fromHour);
}
