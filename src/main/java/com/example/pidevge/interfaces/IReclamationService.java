package com.example.pidevge.interfaces;

import com.example.pidevge.Entities.Reclamation;

import java.util.List;

public interface IReclamationService {
    public List<Reclamation> retrieveAllReclamations();

    public Reclamation addReclamation (Reclamation Reclamation);

    public Reclamation updateReclamation (Reclamation Reclamation);

    public Reclamation retrieveReclamation(Integer  idReclamation);

    public void removeReclamation(Integer idReclamation);
}
