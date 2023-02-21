package services;

import entities.Event;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.EventRepo;

import java.util.List;

public class EventService implements IEventService{
    @Autowired
    EventRepo eventRepo;
    @Override
    public Event addEvent(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public List<Event> findAllEvent() {
        return eventRepo.findAll();
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepo.save(event);
    }

    @Override
    public Event findById(Long id) {
        return null;
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepo.deleteById(id);

    }
}
