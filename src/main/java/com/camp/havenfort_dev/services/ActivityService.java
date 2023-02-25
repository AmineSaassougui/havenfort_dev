package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Activity;
import com.camp.havenfort_dev.entities.Event;
import com.camp.havenfort_dev.exception.UserNotFoundException;
import com.camp.havenfort_dev.repositories.ActivityRepo;
import com.camp.havenfort_dev.repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityService implements IActivityService{
    @Autowired
    ActivityRepo activityRepo;
    @Autowired
    EventRepo eventRepo;
    @Override
    public Activity addActivity(Activity activity) {
        return activityRepo.save(activity);
    }

    @Override
    public List<Activity> findAllActivity() {
        return activityRepo.findAll();
    }

    @Override
    public Activity updateActivity(Activity activity) {
        return activityRepo.save(activity);
    }

    @Override
    public Activity findById(Long id) {
        return activityRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    @Override
    public void deleteActivity(Long id) {
        activityRepo.deleteById(id);
    }

    @Override
    public List<Activity> getActivityByEvent(Long idEvent) {
        return activityRepo.getActivityByEvent(idEvent);
    }

    @Override
    public Activity assignActivityToEvent(Activity activity, String nomE, String typeE) {
        Event event = eventRepo.getEventByNomAndType(nomE,typeE);
        if (activityRepo.countByArchiveIsFalseAndEvent(event)<5){
            activity.setEvent(event);
            activityRepo.save(activity);
        }
        return activity;
    }
}
