package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Category;

public interface ICategoryServices {
    Category addCategory(Category category);

    Category updateCategory(Category category);

    Promotion addPromotion(Promotion promotion);

    Shop addShop(Shop shop);

    Tools addTools(Tools tools);
}
