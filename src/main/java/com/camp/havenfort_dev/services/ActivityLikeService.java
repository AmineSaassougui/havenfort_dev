package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.Repositories.ActivityLikeRepo;
import com.camp.havenfort_dev.Repositories.ActivityRepo;
import com.camp.havenfort_dev.Repositories.Userrepository;
import com.camp.havenfort_dev.entities.Activity;
import com.camp.havenfort_dev.entities.ActivityLike;
import com.camp.havenfort_dev.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class ActivityLikeService implements IActivityLikeService{
   @Autowired
    ActivityLikeRepo activityLikeRepo;
   @Autowired
    ActivityRepo activityRepo;
   @Autowired
    Userrepository userrepository;


    @Override
    public ActivityLike addAndAssignActivityLikeToActivityAndUser(ActivityLike activityLike, Long idActivity, Long idUser) {
        LocalDateTime d = LocalDateTime.now();
        if (activityLikeRepo.reactIs(idUser,idActivity)==null){
            Activity activity = activityRepo.findById(idActivity).orElse(null);
            User user = userrepository.findById(idUser).orElse(null);
            activityLike.setActivity(activity);
            activityLike.setUser(user);
            activityLike.setDateLike(d);
            return activityLikeRepo. save(activityLike);
        }else if ((activityLikeRepo.reactIs(idUser,idActivity).toString().equals(activityLike.getReact().toString()))==true){
            System.out.println("sa7it");
            activityLikeRepo.deleteById(activityLikeRepo.deleteActivityLikeBy(idUser,idActivity));
            return null;
        }else if ((activityLikeRepo.reactIs(idUser,idActivity).toString().equals(activityLike.getReact().toString()))==false){
            activityLikeRepo.deleteById(activityLikeRepo.deleteActivityLikeBy(idUser,idActivity));
            Activity activity = activityRepo.findById(idActivity).orElse(null);
            User user = userrepository.findById(idUser).orElse(null);
            activityLike.setActivity(activity);
            activityLike.setUser(user);
            System.out.println("dislike");
            activityLike.setDateLike(d);
            return activityLikeRepo.save(activityLike);
        }
        return null;
    }
}


