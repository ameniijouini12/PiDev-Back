package com.example.pidevge.Controllers;

import com.example.pidevge.Entities.Formation;

import com.example.pidevge.interfaces.IFormationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Formation")
@Slf4j
public class FormationRestController {
    IFormationService formationService;
    @GetMapping("/retrieve-all-formations")
    public List<Formation> getFormation() {
        return formationService.retrieveAllFormations();
    }

    @GetMapping("/retrieve-formations/{idFormation}")
    public Formation retrieveFormation(@PathVariable("idFormation") Integer idFormation) {
        return formationService.retrieveFormation(idFormation);
    }

    @PostMapping("/add-Formation")
    public Formation addFormation(@RequestBody Formation Formation) {

        return formationService.addFormation(Formation);
    }

    @DeleteMapping("/remove-Formation/{idFormation}")
    public void removeFormation(@PathVariable Integer idFormation) {
        formationService.removeFormation(idFormation);
    }

    @PutMapping("/update-Formation")
    public Formation updateFormation(@RequestBody Formation Formation) {
        return formationService.updateFormation(Formation);
    }
}