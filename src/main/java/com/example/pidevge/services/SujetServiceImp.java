package com.example.pidevge.services;

import com.example.pidevge.Entities.Sujet;
import com.example.pidevge.Repositories.SujetRepository;
import com.example.pidevge.interfaces.ISujetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class SujetServiceImp implements ISujetService {
    SujetRepository sujetRepository;

    public List<Sujet> getAllSujets() {
        return sujetRepository.findAll();
    }

    public Sujet getSujetById(Long id) {
        return sujetRepository.findById(id).orElse(null);
    }

    public Sujet createSujet(Sujet sujet) {
        return sujetRepository.save(sujet);
    }

    public Sujet updateSujet(Sujet sujet) {
        return sujetRepository.save(sujet);
    }

    public void deleteSujetById(Long id) {
        sujetRepository.deleteById(id);
    }

}
