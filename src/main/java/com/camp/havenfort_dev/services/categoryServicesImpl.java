package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.*;
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
    public Tools addtoolsAndAssignTocategory(Tools tools, Long idc){
        Category category = categoryRepository.findById(idc).orElse(null);
        category.getTools().add(tools);
        return toolsRepository.save(tools);}


    @Override
    public Tools AssignToolsToshop(Long idt, Long idshop) {
        Tools tools = toolsRepository.findById(idt).orElse(null);
        Shop shop = shopRepository.findById(idshop).orElse(null);
        shop.getTools();
        return toolsRepository.save(tools);
    }

    @Override
    public void SetAvailability(Long idt){
        Tools tl = toolsRepository.findById(idt).orElse(null);
        tl.setAvailability(Availability.OUT_OF_STOCK);
        toolsRepository.save(tl);
    }
    @Override
    public  void DeleteTool(Long idt){
        toolsRepository.deleteById(idt);
    }


    @Override
    public void DeleteShop(Long idshop){
        shopRepository.deleteById(idshop);
    }





     /*@Override
    public Tools addTools(Tools tools){return toolsRepository.save(tools);}*/
}
