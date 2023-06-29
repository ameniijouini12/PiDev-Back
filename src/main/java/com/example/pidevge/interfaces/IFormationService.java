package com.example.pidevge.interfaces;

import com.example.pidevge.Entities.Formation;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

public interface IFormationService {
    public List<Formation> retrieveAllFormations();

    public Formation addFormation (Formation formation);

    public Formation updateFormation (Formation formation);

    public Formation retrieveFormation(Integer  idFormation);

    public void removeFormation(Integer idFormation);

    public String saveImage(MultipartFile image) throws IOException;
}
