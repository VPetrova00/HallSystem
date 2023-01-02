package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Hall;
import fmi.project.hallsystembackend.repositories.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturerServiceImpl implements LecturerService {
    private final LecturerRepository lecturerRepository;

    @Autowired
    public LecturerServiceImpl(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    @Override
    public void reserveHall(Hall hallToReserve) {

    }
}
