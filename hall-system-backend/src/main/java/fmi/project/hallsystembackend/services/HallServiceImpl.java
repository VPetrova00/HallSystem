package fmi.project.hallsystembackend.services;

import fmi.project.hallsystembackend.models.Hall;
import fmi.project.hallsystembackend.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HallServiceImpl implements HallService {
    private final HallRepository hallRepository;

    @Autowired
    public HallServiceImpl(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    @Override
    public Set<Hall> findAllHalls() {
        return this.hallRepository.findAll();
    }
}
