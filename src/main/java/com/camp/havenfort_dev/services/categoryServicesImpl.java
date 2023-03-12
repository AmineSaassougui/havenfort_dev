package com.camp.havenfort_dev.services;

import com.camp.havenfort_dev.entities.*;
import com.camp.havenfort_dev.repositories.ICategoryRepository;
import com.camp.havenfort_dev.repositories.IPromotionRepository;
import com.camp.havenfort_dev.repositories.IShopRepository;
import com.camp.havenfort_dev.repositories.IToolsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;


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

    @Override
    public void DeletePromotion(Long pid){
        promotionRepository.deleteById(pid);

    }

    @Override
    public void activatePromotion(Promotion promotion) {
        promotion.setActive(true);
        promotionRepository.save(promotion);
    }
    @Override
    public void StopPromotion(Promotion promotion){
        promotion.setActive(false);
        promotionRepository.save(promotion) ;
    }

    @Override
    public List<Tools> GetTools() {
        return toolsRepository.findAll();
    }

    @Override
    // Generate a random promo code
    public String generatePromoCode() {
        // Generate a random alphanumeric string of length 6
        int length = 6;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rng = new Random();
        char[] code = new char[length];
        for (int i = 0; i < length; i++) {
            code[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(code);
    }

    @Override
    // Add a new promotion with a generated promo code
    public Promotion addPromotionWithGeneratedCode(Promotion promotion) {
        String promoCode = generatePromoCode();
        promotion.setPromoCode(promoCode);
        return promotionRepository.save(promotion);
    }

    @Override
    public Shop Assignpromotoshop(Long pid, Long idshop) {
        Shop shop = shopRepository.findById(idshop).orElse(null);
        Promotion Promos = promotionRepository.findById(pid).orElse(null);
        shop.getPromos().add(Promos);
        return shopRepository.save(shop);
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public void disableExpiredPromotions() {
        List<Promotion> promotions = promotionRepository.findAll();
        Date currentDate = new Date();
        for (Promotion promotion : promotions) {
            if (promotion.getEnddate().before(currentDate)) {
                promotion.setActive(false);
                promotionRepository.save(promotion);
                for (Shop shop : promotion.getShops()) { // i can delete this if i dont want to remove promotions from db
                    shop.getPromos().remove(promotion); // i can delete this if i dont want to remove promotions from db
                    shopRepository.save(shop); // i can delete this if i dont want to remove promotions from db
                }// i can delete this if i dont want to remove promotions from db
            }
        }
    }













    /*@Override
    public List<Tools> getToolsSortedByReviews(Long idshop){
        Optional<Shop> optionalShop = shopRepository.findById(idshop);

        if (optionalShop.isPresent()) {
            Shop shop = optionalShop.get();
            List<Tools> tools = (List<Tools>) shop.getTools();
            Collections.sort(tools, new Comparator<Tools>() {
                @Override
                public int compare(Tools t1, Tools t2) {
                    List<String> reviews1 = Collections.singletonList(t1.getReviews());
                    List<String> reviews2 = Collections.singletonList(t2.getReviews());

                    if (reviews1.size() == 0 && reviews2.size() == 0) {
                        return 0;
                    } else if (reviews1.size() == 0) {
                        return 1;
                    } else if (reviews2.size() == 0) {
                        return -1;
                    } else {
                        double avg1 = calculateAverageReview(reviews1);
                        double avg2 = calculateAverageReview(reviews2);
                        return Double.compare(avg2, avg1);
                    }
                }

                private double calculateAverageReview(List<String> reviews) {
                    double totalScore = 0;
                    for (String review : reviews) {
                        totalScore += Double.parseDouble(review);
                    }
                    return totalScore / reviews.size();
                }
            });
            return tools;
        } else {
            throw new EntityNotFoundException("Shop not found");
        }
    }

    @Override
    public List<Tools> getToolsSortedByHighestPrice(Long idshop) {
        List<Tools> tools = toolsRepository.findToolsByShopId(idshop);
        tools.sort(Comparator.comparing(Tools::getPrice).reversed());
        return tools;
    }*/


  /*  @Override
    public Tools requestAddTool(Long idshop, Tools tool){
        // Set the tool status to PENDING
        tool.setStatus(ToolStatus.PENDING);
        tool.setShops(new Shop(idshop));
        return toolsRepository.save(tool);
    }

    public List<Tools> getPendingTools(Long shopId) {
        return toolsRepository.findToolsByShopIdAndStatus(shopId, ToolStatus.PENDING);
    }*/










     /*@Override
    public Tools addTools(Tools tools){return toolsRepository.save(tools);}*/
}
