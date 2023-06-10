package com.example.pidevge.Controllers;

import com.example.pidevge.Entities.Sujet;
import com.example.pidevge.interfaces.ISujetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sujet")
@Slf4j

public class SujetRestController {
    ISujetService sujetService;

    @GetMapping
    public List<Sujet> gitgetAllSujets() {
        return sujetService.getAllSujets();
    }

    @GetMapping("/{id}")
    public Sujet getSujetById(@PathVariable Long id) {
        return sujetService.getSujetById(id);
    }

    @PostMapping
    public Sujet createSujet(@RequestBody Sujet sujet) {
        return sujetService.createSujet(sujet);
    }

    @PutMapping("/{id}")
    public Sujet updateSujet(@PathVariable Long id, @RequestBody Sujet sujet) {
        sujet.setId(id);
        return sujetService.updateSujet(sujet);
    }

    @DeleteMapping("/{id}")
    public void deleteSujet(@PathVariable Long id) {
        sujetService.deleteSujetById(id);
    }


}
