package services;

import entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.ActivityRepo;

import java.util.List;

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
        return null;
    }

    @Override
    public void deleteActivity(Long id) {
        activityRepo.deleteById(id);
    }
}
