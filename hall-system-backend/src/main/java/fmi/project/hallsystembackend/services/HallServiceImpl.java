package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Hall;
import fmi.project.hallsystembackend.models.ReservationData;
import fmi.project.hallsystembackend.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HallServiceImpl implements HallService {
    private final HallRepository hallRepository;
    private final Set<Integer> intervals;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
        this.intervals = new HashSet<Integer>();
        intervals.addAll(Arrays.asList(new Integer[] { 7,8,9,10,11,12,13,14,15,16,17,18,19,20 }));
    }

    @Override
    public Set<Hall> findAllHalls() {
        return this.hallRepository.findAll();
    }

    @Override
    public Hall findHallById(Long id) {
        return this.hallRepository.findHallById(id);
    }

    @Override
    public Set<Object[]> getReservedHalls(String name) {
        return this.hallRepository.getReservedHalls(name);
    }

    @Override
    public Set<Integer> getFreeIntervals(Long id, LocalDate date) {
        Hall hall = this.findHallById(id);
        Set<ReservationData> reservationData = hall.getReservationData().stream().filter(r -> r.getReservedDate().equals(date)).collect(Collectors.toSet());
        Set<Integer> tempIntervals = new HashSet<Integer>(this.intervals);

        for (ReservationData row : reservationData) {
            tempIntervals.remove(row.getReservedHour());
        }

        return tempIntervals;
    }

    @Override
    public Set<Integer> getReservedHours(Long id, LocalDate date) {
        Hall hall = this.findHallById(id);
        Set<ReservationData> reservationData = hall.getReservationData().stream().filter(r -> r.getReservedDate().equals(date)).collect(Collectors.toSet());
        Set<Integer> reservedIntervals = new HashSet<Integer>();

        for (ReservationData row : reservationData) {
            reservedIntervals.add(row.getReservedHour());
        }

        return reservedIntervals;
    }
}
