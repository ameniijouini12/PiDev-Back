package com.example.pidevge.interfaces;

// Java Program to Illustrate Creation Of
// Service Interface


import com.example.pidevge.Entities.EmailDetails;

// Interface
public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
