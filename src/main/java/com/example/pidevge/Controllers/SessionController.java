package com.example.pidevge.Controllers;

import com.example.pidevge.Entities.Formation;
import com.example.pidevge.Entities.Reclamation;
import com.example.pidevge.Entities.session;
import com.example.pidevge.interfaces.IReclamationService;
import com.example.pidevge.interfaces.ISessionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Session")
@Slf4j
public class SessionController {
    ISessionService sessionService;
    @GetMapping("/retrieve-all-sessions")
    public List<session> getSessions() {
        return sessionService.retrieveAllSessions();
    }
    @PostMapping("/add-Session")
    public session addSession(@RequestBody session session) {

        return sessionService.addSession(session);
    }

}
