package com.example.pidevge.Security.Auth;

import lombok.RequiredArgsConstructor;

import lombok.var;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pidevge.Entities.User;
import com.example.pidevge.Repositories.Iuser;
import com.example.pidevge.Security.Configuration.JwtService;
import com.example.pidevge.Security.Token.Token;
import com.example.pidevge.Security.Token.TokenRepo;
import com.example.pidevge.Security.Token.TokenType;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final Iuser iuser ;
    private final TokenRepo tokenRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getFirstName())
                .email(request.getEmail())
                .numero(request.getNumero())
                .password(passwordEncoder.encode(request.getPassword()))
                .userType(request.getUserType())
                .isActive(true)
               // .userType(UserType.OWNER)
                //.userType(UserType.DELIVERYPERSON)
                .build();
        var savedUser = iuser.save(user);
      var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }




    private void saveUserToken(User savedUser, String jwtToken) {
        var token = Token.builder()
                .user(savedUser)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepo.save(token);

    }

    private void revokeAllUserTokens(Optional<User> user) {
       var validUserTokens = tokenRepo.findAllValidTokenByUser(user.get().getIdUser());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepo.saveAll(validUserTokens);
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = iuser.findByEmail(request.getEmail()).orElse(null);
        if (!user.getIsActive()) {
            return AuthResponse.builder().token(null).build();
        } else {
            var jwtToken = jwtService.generateToken(user);
            revokeAllUserTokens(Optional.ofNullable(user));
            saveUserToken(user, jwtToken);
            return AuthResponse.builder()
                    .token(jwtToken)
                    .build();
        }
        
    }
    }

