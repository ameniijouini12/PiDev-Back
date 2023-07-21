package com.example.pidevge.services;

import com.example.pidevge.Entities.Formation;
import com.example.pidevge.Entities.User;
import com.example.pidevge.Repositories.FormationRepository;
import com.example.pidevge.Repositories.UserRepository;
import com.example.pidevge.interfaces.IFormationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class FormationServiceImp implements IFormationService {
    private static final String UPLOAD_DIR = "upload-dir";
    @Autowired
    FormationRepository fromationRepository ;
    @Autowired
    UserRepository userRepository ;
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

    @Override
    public List<Formation> filterFormationsByCriteria(String keyword, LocalDateTime startDate) {
        if (StringUtils.isEmpty(keyword) && startDate == null) {
            return fromationRepository.findAll();
        } else {
            if (StringUtils.isEmpty(keyword)) {
                return fromationRepository.findByDateDebutGreaterThanEqual(startDate);
            } else if (startDate == null) {
                return fromationRepository.findByNomContainingIgnoreCase(keyword);
            } else {
                return fromationRepository.findByNomContainingIgnoreCaseAndDateDebutGreaterThanEqual(keyword, startDate);
            }
        }
    }
    /*public void assignFormationToUser(Integer idUser, Integer idFormation){
        Formation f= fromationRepository.findById(idFormation).orElse(null);
        User d= userRepository.findById(idUser).orElse(null);
        f.getUser().add;
        fromationRepository.save(f);
    }*/


    @Override
    public void assignFormationToUser(Integer idFormation, Integer idUser) {
        Formation formation = fromationRepository.findById(idFormation).orElse(null);
        User user = userRepository.findById(idUser).orElse(null);

        if (formation != null && user != null) {
            formation.setUser(user);
            fromationRepository.save(formation);
        } else {
            log.error("Formation or User not found with provided IDs.");

        }
    }



}
