package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Hall;

public interface LecturerService {
    void reserveHall(Hall hallToReserve);
}
