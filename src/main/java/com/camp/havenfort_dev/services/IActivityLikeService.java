package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.ActivityLike;

import java.io.Serializable;
import java.util.List;

public interface IActivityLikeService extends Serializable {


    public ActivityLike addAndAssignActivityLikeToActivityAndUser(ActivityLike activityLike, Long idActivity,Long idUser);

}

