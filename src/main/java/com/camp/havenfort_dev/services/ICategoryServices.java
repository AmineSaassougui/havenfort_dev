package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Category;
import com.camp.havenfort_dev.entities.Promotion;
import com.camp.havenfort_dev.entities.Shop;
import com.camp.havenfort_dev.entities.Tools;

public interface ICategoryServices {
    Category addCategory(Category category);

    Category updateCategory(Category category);

    Promotion addPromotion(Promotion promotion);

    Shop addShop(Shop shop);



    Tools addtoolsAndAssignTocategory(Tools tools, Long idc);

    Tools AssignToolsToshop(Long idt, Long idshop);

    void SetAvailability(Long idt);
}
