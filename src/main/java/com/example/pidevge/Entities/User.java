package com.example.pidevge.Entities;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import java.util.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String firstName  ;
    private String lastName  ;
    private String email ;
    private String numero  ;
    private String password  ;
    private Boolean isBlocked;
    private Boolean isActive;
    @Enumerated(EnumType.STRING)
    private UserType  userType  ;

   

  //  retourne la liste des autorisations (ou rôles) de l'utilisateur.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // Ajouter les rôles de l'utilisateur à la liste d'autorités
        authorities.add(new SimpleGrantedAuthority(userType.name()));
        return authorities ;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return email;
    }
    //si le compte de l'utilisateur est expiré ou non.
    @Override
    public boolean isAccountNonExpired() {
        return true ;
    }
   // si le compte de l'utilisateur est verrouillé ou non.
    @Override
    public boolean isAccountNonLocked() {
        return true ;
    }
    //si les informations d'authentification de l'utilisateur sont expirées ou non.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public boolean isActive() {
        return false;
    }
}