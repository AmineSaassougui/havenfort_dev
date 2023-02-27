package services;

import entities.Event;

import java.io.Serializable;
import java.util.List;

public interface IEventService extends Serializable {

    Event addEvent(Event event);

    public List<Event> findAllEvent();
    public Event updateEvent(Event event);
    public Event findById(Long id);
    public void deleteEvent(Long id);
}
