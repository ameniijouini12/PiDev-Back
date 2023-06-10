package com.example.pidevge.interfaces;

import com.example.pidevge.Entities.Formation;


import java.util.List;

public interface IFormationService {
    public List<Formation> retrieveAllFormations();

    public Formation addFormation (Formation formation);

    public Formation updateFormation (Formation formation);

    public Formation retrieveFormation(Integer  idFormation);

    public void removeFormation(Integer idFormation);
}
