package com.camp.havenfort_dev.services;


import com.camp.havenfort_dev.entities.Activity;

import java.io.Serializable;
import java.util.List;

public interface IActivityService extends Serializable {

    Activity addActivity(Activity activity);

    Activity updateActivity(Activity activity);

    void deleteActivity(Long id);
    List<Activity> getActivityByEvent(Long idEvent);
    Activity assignActivityToEvent(Activity activity,String nomE,String typeE);
    List<Activity> suggestAct(Long idCenter);
    Activity AddWishListandAddActivityToIt(Long idAct , Long idUser);

}
