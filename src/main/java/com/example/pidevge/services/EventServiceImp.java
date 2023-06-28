package com.example.pidevge.services;

import com.example.pidevge.Entities.Event;
import com.example.pidevge.Repositories.EventRepository;
import com.example.pidevge.interfaces.IEventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class EventServiceImp implements IEventService {
    private static final String UPLOAD_DIR = "upload-dir";
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

    @Override
    public String saveImage(MultipartFile image) throws IOException {
        String fileName = UUID.randomUUID().toString(); // Generate a unique file name
        String uploadPath = Paths.get(UPLOAD_DIR, fileName).toString();
        String fullPath = Paths.get(System.getProperty("user.dir"), uploadPath).toString();

        File file = new File(fullPath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        image.transferTo(file);

        return uploadPath;
    }
}
