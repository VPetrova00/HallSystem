package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Hall;
import fmi.project.hallsystembackend.models.Lecturer;
import fmi.project.hallsystembackend.models.ReservationData;
import fmi.project.hallsystembackend.repositories.HallRepository;
import fmi.project.hallsystembackend.repositories.LecturerRepository;
import fmi.project.hallsystembackend.repositories.ReservationDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Service
public class LecturerServiceImpl implements LecturerService {
    private final LecturerRepository lecturerRepository;
    private final HallRepository hallRepository;
    private final ReservationDataRepository reservationDataRepository;

    @Autowired
    public LecturerServiceImpl(LecturerRepository lecturerRepository, HallRepository hallRepository, ReservationDataRepository reservationDataRepository) {
        this.lecturerRepository = lecturerRepository;
        this.hallRepository = hallRepository;
        this.reservationDataRepository = reservationDataRepository;
    }

    @Override
    public void reserveHall(Long lecturerId, Long hallId, int fromHour, LocalDate reservationDate) {
        Hall hallToReserve = this.hallRepository.findHallById(hallId);
        Optional<Lecturer> lecturer = this.lecturerRepository.findById(lecturerId);

        if (lecturer.isPresent()) {
            Lecturer lecturerObj = lecturer.get();
            ReservationData reservationData = new ReservationData(fromHour, reservationDate, lecturerObj, hallToReserve);
            hallToReserve.addReservationData(reservationData);
            lecturer.get().addReservationData(reservationData);

            this.hallRepository.save(hallToReserve);
            this.lecturerRepository.save(lecturerObj);
            this.reservationDataRepository.save(reservationData);
        }
    }

    @Override
    public Lecturer findLecturerByName(String name) {
        return this.lecturerRepository.findLecturerByName(name);
    }

    @Override
    public Set<Lecturer> findAllLecturers() {
        return this.lecturerRepository.findAll();
    }

    @Override
    public void deleteHallReservation(Long lecturerId, Long hallId, Integer reservedHour, LocalDate reservedDate) {
        Long reservationId = this.lecturerRepository.getReservationId(lecturerId, hallId, reservedHour, reservedDate);
        Optional<ReservationData> reservationData = this.reservationDataRepository.findById(reservationId);
        this.reservationDataRepository.deleteById(reservationId);

        Hall hall = this.hallRepository.findHallById(hallId);
        Optional<Lecturer> lecturer = this.lecturerRepository.findById(lecturerId);

        if (lecturer.isPresent() && reservationData.isPresent()) {
            hall.deleteReservationData(reservationData.get());
            lecturer.get().deleteReservationData(reservationData.get());
            this.hallRepository.save(hall);
            this.lecturerRepository.save(lecturer.get());
        }
    }
}
