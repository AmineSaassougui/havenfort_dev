package com.camp.havenfort_dev.exceptions;

public class PromotionNotFoundException extends RuntimeException {

    public PromotionNotFoundException(Long pid) {
        super("Could not find promotion with id: " + pid);
    }

}
