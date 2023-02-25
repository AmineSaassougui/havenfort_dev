package com.camp.havenfort_dev.services;


public class ActivityService {

import com.camp.havenfort_dev.entities.Activity;
import com.camp.havenfort_dev.exception.UserNotFoundException;
import com.camp.havenfort_dev.repositories.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActivityService implements IActivityService{
    @Autowired
    ActivityRepo activityRepo;
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

}
