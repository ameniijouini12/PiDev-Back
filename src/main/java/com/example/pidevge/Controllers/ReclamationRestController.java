package com.example.pidevge.Controllers;

import com.example.pidevge.Entities.Reclamation;
import com.example.pidevge.interfaces.IReclamationService;
import com.example.pidevge.interfaces.IReclamationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Reclamation")
@Slf4j
public class ReclamationRestController {
    IReclamationService reclamationService;
    @GetMapping("/retrieve-all-Reclamations")
    public List<Reclamation> getReclamation() {
        return reclamationService.retrieveAllReclamations();
    }

    @GetMapping("/retrieve-Reclamations/{id}")
    public Reclamation retrieveReclamation(@PathVariable("id") Integer idReclamation) {
        return reclamationService.retrieveReclamation(idReclamation);
    }

    @PostMapping("/add-Reclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.addReclamation(reclamation);
    }

    @DeleteMapping("/remove-Reclamation/{Reclamation-id}")
    public void removeReclamation(Integer idReclamation) {
        reclamationService.removeReclamation(idReclamation);
    }

    @PutMapping("/update-Reclamation")
    public Reclamation updateReclamation(@RequestBody Reclamation Reclamation) {
        return reclamationService.updateReclamation(Reclamation);
    }
}
