package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Hall;
import java.util.Set;

public interface HallService {
    Set<Hall> findAllHalls();
}
