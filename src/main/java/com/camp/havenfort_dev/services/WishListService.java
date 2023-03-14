package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.Repositories.ActivityRepo;
import com.camp.havenfort_dev.Repositories.IWishListRepo;
import com.camp.havenfort_dev.Repositories.Userrepository;
import com.camp.havenfort_dev.entities.Activity;
import com.camp.havenfort_dev.entities.TypeCenAct;
import com.camp.havenfort_dev.entities.User;
import com.camp.havenfort_dev.entities.WishList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class WishListService implements IWishListService {
    @Autowired
    Userrepository userrepository;
    @Autowired
    ActivityRepo activityRepo;
    @Autowired
    IWishListRepo wishListRepo;


    @Override
    @Scheduled(cron = "*/50 * * * * *")
    public void SuggestActivitiesByWishList() {
        List<User> userList = (List<User>) userrepository.findAll();
        for (User u : userList) {
            WishList w = u.getWishList();
            if (w == null) {
                log.info("------[Empty WishList]--------");
                log.info("The user : " + u.getFirstName() + " have an empty WishList");
            }
            if (w != null) {
                for (Activity act : w.getActivities()) {
                    TypeCenAct typeCenAct = act.getTypeActivity();
                    List<Activity> PByAct = activityRepo.findAllByTypeActivity(typeCenAct);
                    PByAct.remove(act);
                    PByAct = PByAct.stream().limit(5).collect(Collectors.toList());
                    log.info("The User : " + u.getFirstName() + " Puted the Activity placed in " + act.getName() + " in WishList");
                    log.info("We Suggest for you this 5 commune activities");
                    for (Activity a1 : PByAct) {
                        log.info("Try This Activity in : " + a1.getName() + " The time is : " + a1.getPrice() + "DT");
                    }

                }

            }

        }
    }
}
