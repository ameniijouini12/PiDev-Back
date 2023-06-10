package com.example.pidevge.interfaces;

import com.example.pidevge.Entities.feedback;
import com.example.pidevge.Entities.feedback;

import java.util.List;

public interface IfeedbackService {
    public List<feedback> retrieveAllfeedbacks();

    public feedback addfeedback (feedback feedback);

    public feedback updatefeedback (feedback feedback);

    public feedback retrievefeedback(Integer  idFeedBack);

    public void removefeedback(Integer idFeedBack);
}
