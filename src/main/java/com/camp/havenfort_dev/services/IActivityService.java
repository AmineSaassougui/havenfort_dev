package com.camp.havenfort_dev.services;


import com.camp.havenfort_dev.entities.Activity;






import java.io.Serializable;
import java.util.List;

public interface IActivityService extends Serializable {

    Activity addActivity(Activity activity);
    List<Activity> findAllActivity();
    Activity updateActivity(Activity activity);
    Activity findById(Long id);
    void deleteActivity(Long id);
    List<Activity> getActivityByEvent(Long idEvent);
}
