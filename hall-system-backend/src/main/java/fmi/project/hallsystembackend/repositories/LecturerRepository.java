package fmi.project.hallsystembackend.repositories;

import fmi.project.hallsystembackend.models.Lecturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;

@Repository
public interface LecturerRepository extends CrudRepository<Lecturer, Long> {
    Lecturer findLecturerByName(String name);
    Set<Lecturer> findAll();
}
