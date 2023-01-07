package fmi.project.hallsystembackend.repositories;

import fmi.project.hallsystembackend.models.Lecturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LecturerRepository extends CrudRepository<Lecturer, Long> {
    List<Lecturer> findAll();
}
