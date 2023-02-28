package com.camp.havenfort_dev.services;


import com.camp.havenfort_dev.entities.Activity;
import com.camp.havenfort_dev.entities.TypeCenAct;






import java.io.Serializable;
import java.util.List;

public interface IActivityService extends Serializable {

    Activity addActivity(Activity activity);
    List<Activity> findAllActivity();
    Activity updateActivity(Activity activity);
    Activity findById(Long id);
    void deleteActivity(Long id);
    List<Activity> getActivityByEvent(Long idEvent);
    Activity assignActivityToEvent(Activity activity,String nomE,String typeE);
    List<Activity> suggestAct(Long idCenter);
}
