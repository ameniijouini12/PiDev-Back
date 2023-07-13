package com.example.pidevge.Security.Auth;



import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AUTH/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    //http://localhost:8092/Campi/AUTH/auth/register
    //endpoint pour inscription
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }


    //endPoint pour s'authentifier
   // http://localhost:8092/Campi/AUTH/auth/authenticate

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthRequest request)
    {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
