package com.example.pidevge.interfaces;
import com.example.pidevge.Entities.Sujet;

import java.util.List;

public interface ISujetService {
    public List<Sujet> getAllSujets();
    public Sujet getSujetById(Long id);
    public Sujet createSujet(Sujet sujet);
    public Sujet updateSujet(Sujet sujet);
    public void deleteSujetById(Long id);
}
