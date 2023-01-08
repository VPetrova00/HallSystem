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
            value = "SELECT * FROM halls " +
                    "INNER JOIN lecturers_halls ON halls.id = lecturers_halls.hall_id " +
                    "INNER JOIN lecturers ON lecturers_halls.lecturer_id = lecturers.id " +
                    "WHERE lecturers.name = :lecturer",
            nativeQuery=true
    )

    Set<Hall> getReservedHalls(@Param("lecturer") String lecturer);
}
