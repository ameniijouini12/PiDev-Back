package com.example.pidevge.interfaces;

import com.example.pidevge.Entities.Event;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IEventService {
    public List<Event> retrieveAllEvents();

    public Event addEvent (Event event);

    public Event updateEvent (Event event);

    public Event retrieveEvent(Integer  idEvent);

    public void removeEvent(Integer idEvent);
    public String saveImage(MultipartFile image) throws IOException;
}
