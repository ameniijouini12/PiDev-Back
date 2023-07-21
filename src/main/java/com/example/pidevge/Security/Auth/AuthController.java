package com.example.pidevge.Security.Auth;



import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/AUTH/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    //http://localhost:8081/PIDev/AUTH/auth/authenticate
    //endpoint pour inscription
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }


    //endPoint pour s'authentifier
   // http://localhost:8081/PIDev/AUTH/auth/authenticate

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request)
    {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
