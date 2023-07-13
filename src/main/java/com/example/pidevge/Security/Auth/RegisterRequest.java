package com.example.pidevge.Security.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.pidevge.Entities.UserType;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
   private String firstName  ;
    private String lastName  ;
    private String email ;
    private String numero ;
    private String password  ;
   @Enumerated(EnumType.STRING)
   private UserType userType;
    

}
