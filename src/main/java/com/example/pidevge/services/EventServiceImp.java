package com.example.pidevge.services;

import com.example.pidevge.Entities.Event;
import com.example.pidevge.Repositories.EventRepository;
import com.example.pidevge.interfaces.IEventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class EventServiceImp implements IEventService {
    @Autowired
    EventRepository eventRepository;
    @Override
    public List<Event> retrieveAllEvents() {
        return  eventRepository.findAll();
    }

    @Override
    public Event addEvent(Event Event) {
        return eventRepository.save(Event);
    }

    @Override
    public Event updateEvent(Event Event) {
        return eventRepository.save(Event);
    }

    @Override
    public Event retrieveEvent(Integer idEvent) {
        return eventRepository.findById(idEvent).get();
    }

    @Override
    public void removeEvent(Integer idEvent) {
        Event Event=retrieveEvent(idEvent);
        eventRepository.delete(Event);
    }
}
