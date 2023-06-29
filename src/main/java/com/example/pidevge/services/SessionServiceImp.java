package com.example.pidevge.services;


import com.example.pidevge.Entities.session;
import com.example.pidevge.Repositories.SessionRepository;
import com.example.pidevge.interfaces.ISessionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@AllArgsConstructor
@Service
public class SessionServiceImp implements ISessionService {
    @Autowired
    SessionRepository SessionRepository ;
    @Override
    public List<session> retrieveAllSessions() {
        return  SessionRepository.findAll();
    }

    @Override
    public session addSession(session Session) {
        return SessionRepository.save(Session);
    }
}
