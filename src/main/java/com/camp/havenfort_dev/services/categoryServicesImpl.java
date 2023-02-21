package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.Category;
import com.camp.havenfort_dev.entities.Promotion;
import com.camp.havenfort_dev.entities.Shop;
import com.camp.havenfort_dev.entities.Tools;
import com.camp.havenfort_dev.repositories.ICategoryRepository;
import com.camp.havenfort_dev.repositories.IPromotionRepository;
import com.camp.havenfort_dev.repositories.IShopRepository;
import com.camp.havenfort_dev.repositories.IToolsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class categoryServicesImpl implements ICategoryServices {
    @Autowired
    ICategoryRepository categoryRepository;
    @Autowired
    IPromotionRepository promotionRepository;
    @Autowired
    IToolsRepository toolsRepository;
    @Autowired
    IShopRepository shopRepository ;
    @Override
    public Category addCategory(Category category){return categoryRepository.save(category);}
    @Override
    public Category updateCategory(Category category){return categoryRepository.save(category);}


    @Override
    public Promotion addPromotion(Promotion promotion){return promotionRepository.save(promotion);}

    @Override
    public Shop addShop(Shop shop){ return shopRepository.save(shop);}

    @Override
    public Tools addTools(Tools tools){return toolsRepository.save(tools);}




}
