package com.camp.havenfort_dev.services;


public class ActivityService {

import com.camp.havenfort_dev.entities.Activity;
import com.camp.havenfort_dev.entities.CenterOfCamp;
import com.camp.havenfort_dev.entities.Event;
import com.camp.havenfort_dev.entities.TypeCenAct;
import com.camp.havenfort_dev.exception.UserNotFoundException;
import com.camp.havenfort_dev.repositories.ActivityRepo;
import com.camp.havenfort_dev.repositories.CenterOfCampRepo;
import com.camp.havenfort_dev.repositories.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ActivityService implements IActivityService{
    @Autowired
    ActivityRepo activityRepo;
    @Autowired
    EventRepo eventRepo;
    @Autowired
    CenterOfCampRepo centerOfCampRepo;
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


    @Override
    public List<Activity> suggestAct(Long idCenter) {
        List<Activity> sugggetact = new ArrayList<>();
        CenterOfCamp centerOfCamp = centerOfCampRepo.findById(idCenter).get();
        List<Event> events = eventRepo.findByCenterOfCamp(centerOfCamp);
        for (Event e : events){
            Set<Activity> activityList = e.getActivities();
            for (Activity act : activityList){
                TypeCenAct typeCenAct = act.getTypeActivity();
                if ((act.getTypeActivity() == TypeCenAct.desert) && (centerOfCamp.getTypeCenter() == TypeCenAct.desert)){
                    sugggetact.add(act);
                } else if ((act.getTypeActivity() == TypeCenAct.sea) && (centerOfCamp.getTypeCenter() == TypeCenAct.sea)) {
                    sugggetact.add(act);

                } else if ((act.getTypeActivity() == TypeCenAct.forest) && (centerOfCamp.getTypeCenter() == TypeCenAct.forest)) {
                    sugggetact.add(act);
                }
            }
        }
        return sugggetact;
    }

}
