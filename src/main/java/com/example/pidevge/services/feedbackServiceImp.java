package com.example.pidevge.services;

import com.example.pidevge.Entities.Reclamation;
import com.example.pidevge.Entities.feedback;
import com.example.pidevge.Repositories.FeedBackRepository;

import com.example.pidevge.interfaces.IfeedbackService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class feedbackServiceImp implements IfeedbackService {
    @Autowired
    FeedBackRepository feedbackRepository ;
    @Override
    public List<feedback> retrieveAllfeedbacks() {
        return  feedbackRepository.findAll();
    }

    @Override
    public feedback addfeedback(feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public feedback updatefeedback(feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public feedback retrievefeedback(Integer idReclamation) {
        return feedbackRepository.findById(idReclamation).get();
    }


    @Override
    public void removefeedback(Integer idfeedback) {
        feedback feedback=retrievefeedback(idfeedback);
        feedbackRepository.delete(feedback);
    }
}
