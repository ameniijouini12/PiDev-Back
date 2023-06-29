package com.example.pidevge.interfaces;


import com.example.pidevge.Entities.session;

import java.util.List;

public interface ISessionService {
    public List<session> retrieveAllSessions();

    public session addSession (session Session);
}
