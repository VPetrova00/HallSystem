package fmi.project.hallsystembackend.repositories;

import fmi.project.hallsystembackend.models.ReservationData;
import org.springframework.data.repository.CrudRepository;

public interface ReservationDataRepository extends CrudRepository<ReservationData, Long> {
}
