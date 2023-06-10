package com.example.pidevge.Controllers;

import com.example.pidevge.Entities.feedback;

import com.example.pidevge.interfaces.IfeedbackService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/feedback")
@Slf4j
public class feedbackRestController {
    IfeedbackService feedBackService;
    @GetMapping("/retrieve-all-feedbacks")
    public List<feedback> getfeedback() {
        return feedBackService.retrieveAllfeedbacks();
    }

    @GetMapping("/retrieve-feedbacks/{id}")
    public feedback retrievefeedback(@PathVariable("id") Integer idfeedback) {
        return feedBackService.retrievefeedback(idfeedback);
    }

    @PostMapping("/add-feedback")
    public feedback addfeedback(@RequestBody feedback feedback) {
        return feedBackService.addfeedback(feedback);
    }

    @DeleteMapping("/remove-feedback/{feedback-id}")
    public void removefeedback(Integer idfeedback) {
        feedBackService.removefeedback(idfeedback);
    }

    @PutMapping("/update-feedback")
    public feedback updatefeedback(@RequestBody feedback feedback) {
        return feedBackService.updatefeedback(feedback);
    }
}
