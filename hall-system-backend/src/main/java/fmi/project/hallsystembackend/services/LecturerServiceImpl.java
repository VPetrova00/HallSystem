package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Hall;
import fmi.project.hallsystembackend.models.Lecturer;
import fmi.project.hallsystembackend.repositories.HallRepository;
import fmi.project.hallsystembackend.repositories.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LecturerServiceImpl implements LecturerService {
    private final LecturerRepository lecturerRepository;
    private final HallRepository hallRepository;

    @Autowired
    public LecturerServiceImpl(LecturerRepository lecturerRepository, HallRepository hallRepository) {
        this.lecturerRepository = lecturerRepository;
        this.hallRepository = hallRepository;
    }

    @Override
    public void reserveHall(Long lecturerId, Long hallId, int fromHour) {
        Hall hallToReserve = this.hallRepository.findHallById(hallId);
        hallToReserve.reserveInterval(fromHour);
        Optional<Lecturer> lecturer = this.lecturerRepository.findById(lecturerId);

        lecturer.ifPresent(value -> value.addReservedHall(hallToReserve));
        this.hallRepository.save(hallToReserve);
        lecturer.ifPresent(this.lecturerRepository::save);
    }

    @Override
    public Lecturer findLecturerByName(String name) {
        return this.lecturerRepository.findLecturerByName(name);
    }
}
