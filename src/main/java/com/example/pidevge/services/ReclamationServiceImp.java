package com.example.pidevge.services;

import com.example.pidevge.Entities.Reclamation;
import com.example.pidevge.Entities.Reclamation;
import com.example.pidevge.Repositories.ReclamationRepository;
import com.example.pidevge.interfaces.IReclamationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ReclamationServiceImp implements IReclamationService {
    @Autowired
    ReclamationRepository reclamationRepository ;
    @Override
    public List<Reclamation> retrieveAllReclamations() {
        return  reclamationRepository.findAll();
    }

    @Override
    public Reclamation addReclamation(Reclamation Reclamation) {
        return reclamationRepository.save(Reclamation);
    }

    @Override
    public Reclamation updateReclamation(Reclamation Reclamation) {
        return reclamationRepository.save(Reclamation);
    }

    @Override
    public Reclamation retrieveReclamation(Integer idReclamation) {
        return reclamationRepository.findById(idReclamation).get();
    }

    @Override
    public void removeReclamation(Integer idReclamation) {
        Reclamation Reclamation=retrieveReclamation(idReclamation);
        reclamationRepository.delete(Reclamation);
    }

}
