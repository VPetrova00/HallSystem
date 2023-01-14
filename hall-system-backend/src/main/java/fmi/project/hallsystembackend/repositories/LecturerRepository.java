package fmi.project.hallsystembackend.repositories;

import fmi.project.hallsystembackend.models.Lecturer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Set;

@Repository
public interface LecturerRepository extends CrudRepository<Lecturer, Long> {
    Lecturer findLecturerByName(String name);
    Set<Lecturer> findAll();

    @Query(
            value = "SELECT DISTINCT reservation_data.id FROM reservation_data " +
                    "WHERE reservation_data.lecturer_id = :lecturerId AND reservation_data.hall_id = :hallId AND reservation_data.reserved_hour = :hour AND reservation_data.reserved_date = :date",
            nativeQuery=true
    )
    Long getReservationId(@Param("lecturerId") Long lecturerId, @Param("hallId") Long hallId, @Param("hour") Integer reservedHour, @Param("date") LocalDate reservedDate);
}
