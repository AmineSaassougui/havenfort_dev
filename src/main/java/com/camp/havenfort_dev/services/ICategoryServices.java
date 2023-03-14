package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Category;
import com.camp.havenfort_dev.entities.Promotion;
import com.camp.havenfort_dev.entities.Shop;
import com.camp.havenfort_dev.entities.Tools;

import java.util.List;

public interface ICategoryServices {
    Category addCategory(Category category);

    Category updateCategory(Category category);

    Promotion addPromotion(Promotion promotion);

    Shop addShop(Shop shop);

    Tools addtoolsAndAssignTocategory(Tools tools, Long idc);

    Tools AssignToolsToshop(Long idt, Long idshop);

    void SetAvailability(Long idt);

    void DeleteTool(Long idt);

    void DeleteShop(Long idshop);

    void DeletePromotion(Long pid);

    void activatePromotion(Promotion promotion);

    void StopPromotion(Promotion promotion);

    List<Tools> GetTools();

    // Generate a random promo code

    String generatePromoCode();

    // Add a new promotion with a generated promo code
    Promotion addPromotionWithGeneratedCode(Promotion promotion);



    Shop assignPromotionToShopandtools(Long pid, Long idshop, Long idt);

    List<Promotion> getAllPromotions();

    void disableExpiredPromotions();

    void DeleteCategory(Long idc);

    List<Category> GetCategories();

    List<Shop> GetShops();

    void RemovetoolFrominventory(Long idshop, Long idt);



    Tools applyPromotionToToolInShop(Long idshop, Long idt, Long pid);

    List<Tools> searchTools(String keyword);


    List<Shop> Searchshops(String keyword);

    Tools FindtoolsById(Long idt);

    Category FindCategorieById(Long idc);

    Shop FindShopById(Long idshop);

    Promotion FindPromotionById(Long pid);
}
