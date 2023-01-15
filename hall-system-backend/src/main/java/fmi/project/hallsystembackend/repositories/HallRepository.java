package fmi.project.hallsystembackend.repositories;

import fmi.project.hallsystembackend.models.Hall;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface HallRepository extends CrudRepository<Hall, Long> {
    Set<Hall> findAll();

    Hall findHallById(Long id);

    @Query(
            value = "SELECT DISTINCT halls.id, halls.hall_number, halls.faculty_name, halls.capacity, halls.has_projector, halls.is_computer_hall, reservation_data.reserved_date, reservation_data.reserved_hour FROM halls " +
                    "INNER JOIN reservation_data ON halls.id = reservation_data.hall_id " +
                    "INNER JOIN lecturers ON reservation_data.lecturer_id = lecturers.id " +
                    "WHERE lecturers.name = :lecturer",
            nativeQuery=true
    )
    Set<Object[]> getReservedHalls(@Param("lecturer") String lecturer);
}
