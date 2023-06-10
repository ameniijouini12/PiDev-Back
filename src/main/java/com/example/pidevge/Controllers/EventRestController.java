package com.example.pidevge.Controllers;

import com.example.pidevge.Entities.Event;
import com.example.pidevge.Entities.Event;
import com.example.pidevge.interfaces.IEventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Event")
@Slf4j
public class EventRestController {
    IEventService EventService;
    @GetMapping("/retrieve-all-Events")
    public List<Event> getEvent() {
        return EventService.retrieveAllEvents();
    }

    @GetMapping("/retrieve-Events/{id}")
    public Event retrieveEvent(@PathVariable("id") Integer idEvent) {
        return EventService.retrieveEvent(idEvent);
    }

    @PostMapping("/add-Event")
    public Event addEvent(@RequestBody Event Event) {
        return EventService.addEvent(Event);
    }

    @DeleteMapping("/remove-Event/{Event-id}")
    public void removeEvent(Integer idEvent) {
        EventService.removeEvent(idEvent);
    }

    @PutMapping("/update-Event")
    public Event updateEvent(@RequestBody Event event) {
        return EventService.updateEvent(event);
    }
}
