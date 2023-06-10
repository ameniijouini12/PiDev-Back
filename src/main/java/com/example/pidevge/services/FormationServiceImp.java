package com.example.pidevge.services;

import com.example.pidevge.Entities.Formation;
import com.example.pidevge.Entities.User;
import com.example.pidevge.Repositories.FormationRepository;
import com.example.pidevge.Repositories.UserRepository;
import com.example.pidevge.interfaces.IFormationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class FormationServiceImp implements IFormationService {
    @Autowired
    FormationRepository fromationRepository ;
    @Override
    public List<Formation> retrieveAllFormations() {
        return  fromationRepository.findAll();
    }

    @Override
    public Formation addFormation(Formation formation) {
        return fromationRepository.save(formation);
    }

    @Override
    public Formation updateFormation(Formation formation) {
        return fromationRepository.save(formation);
    }

    @Override
    public Formation retrieveFormation(Integer idFormation) {
        return fromationRepository.findById(idFormation).get();
    }

    @Override
    public void removeFormation(Integer idFormation) {
        Formation formation=retrieveFormation(idFormation);
        fromationRepository.delete(formation);
    }

}
