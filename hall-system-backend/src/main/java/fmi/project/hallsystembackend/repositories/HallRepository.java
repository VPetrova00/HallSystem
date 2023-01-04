package fmi.project.hallsystembackend.repositories;

import fmi.project.hallsystembackend.models.Hall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface HallRepository extends CrudRepository<Hall, Long> {
    Set<Hall> findAll();


}
