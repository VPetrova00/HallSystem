package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Hall;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public interface HallService {
    Set<Hall> findAllHalls();
    Hall findHallById(Long id);
    Set<Object[]> getReservedHalls(String name);
    Set<Integer> getFreeIntervals(Long id, LocalDate date);
    Set<Integer> getReservedHours(Long id, LocalDate date);
}
