package com.camp.havenfort_dev.services;


import com.camp.havenfort_dev.Repositories.*;
import com.camp.havenfort_dev.entities.*;
import com.camp.havenfort_dev.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Service
public class ActivityService implements IActivityService{
    @Autowired
    ActivityRepo activityRepo;
    @Autowired
    CenterOfCampRepo centerOfCampRepo;
    @Autowired
    EventRepo eventRepo;
    @Autowired
    Userrepository userrepository;
    @Autowired
    IWishListRepo iWishListRepo;
    @Override
    public Activity addActivity(Activity activity) {
        return activityRepo.save(activity);
    }



    @Override
    public Activity updateActivity(Activity activity) {
        return activityRepo.save(activity);
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

    @Override
    public Activity AddWishListandAddActivityToIt(Long idAct, Long idUser) {
        User u = userrepository.findById(idUser).get();
        Activity a = activityRepo.findById(idAct).get();
        if (u.getWishList() == null) {
            WishList wishList = new WishList();
            wishList.setDate(new Date());
            a.setWishList(wishList);
            u.setWishList(wishList);
            iWishListRepo.save(wishList);
            userrepository.save(u);
            activityRepo.save(a);
        }
        else{
            a.setWishList(u.getWishList());
            activityRepo.save(a);
        }
        return a;

    }

}
