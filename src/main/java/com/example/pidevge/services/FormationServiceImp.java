package com.example.pidevge.services;

import com.example.pidevge.Entities.Formation;
import com.example.pidevge.Repositories.FormationRepository;
import com.example.pidevge.interfaces.IFormationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class FormationServiceImp implements IFormationService {
    private static final String UPLOAD_DIR = "upload-dir";
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
    @Override
    public String saveImage(MultipartFile image) throws IOException {
        String fileName = UUID.randomUUID().toString(); // Generate a unique file name
        String uploadPath = Paths.get(UPLOAD_DIR, fileName).toString();
        String fullPath = Paths.get(System.getProperty("user.dir"), uploadPath).toString();

        File file = new File(fullPath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        image.transferTo(file);

        return uploadPath;
    }
}
