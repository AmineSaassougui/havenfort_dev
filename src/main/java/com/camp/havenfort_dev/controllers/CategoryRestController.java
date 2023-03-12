package com.camp.havenfort_dev.controllers;

import com.camp.havenfort_dev.Repositories.Userrepository;
import com.camp.havenfort_dev.entities.*;
import com.camp.havenfort_dev.exceptions.PromotionNotFoundException;
import com.camp.havenfort_dev.repositories.IPromotionRepository;
import com.camp.havenfort_dev.services.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryRestController {
    @Autowired
    ICategoryServices categoryServices;
    @Autowired
    private IPromotionRepository iPromotionRepository;
    @Autowired
    private Userrepository userrepository;

    @PostMapping("/addCategory")
    @ResponseBody
    public Category addCategory(@RequestBody Category category){return categoryServices.addCategory(category);}

    @PutMapping("/updateCategory")
    @ResponseBody
    public Category updateCategory(@RequestBody Category category){return categoryServices.updateCategory(category);}

   /* @PostMapping("/addPromotion")
    @ResponseBody
    public Promotion addPromotion(@RequestBody Promotion promotion){return categoryServices.addPromotion(promotion);}*/

    @PostMapping("/addPromotionwithgenretedcode")
    public Promotion addPromotionwithcode(@RequestBody Promotion promotion) {
        return categoryServices.addPromotionWithGeneratedCode(promotion);
    }

    @GetMapping("/generate-promo-code")
    public String generatePromoCode() {
        String promoCode = categoryServices.generatePromoCode();
        return promoCode;
    }



    @PostMapping("/addShop")
    @ResponseBody
    public Shop addShop(@RequestBody Shop shop, Principal principal){
        Long userId = Long.parseLong(principal.getName());
        Optional<User> currentUserOptional = userrepository.findById(userId);
        if (!currentUserOptional.isPresent() || currentUserOptional.get().getRole() != Role.superUser)  {
            // If the user is a superuser, add the shop to the database
            return categoryServices.addShop(shop);
        }

        // If the user is not a superuser, return null
        return null;
    }






    @PostMapping("/addtools/{idc}")
    @ResponseBody
    public Tools addToolsToCategory(@RequestBody Tools tools, @PathVariable("idc") Long idc){
        return categoryServices.addtoolsAndAssignTocategory(tools, idc);
    }

    @PutMapping("/setAvailability/{idt}")
    public void changeAvailability(@PathVariable("idt") Long idt){
        categoryServices.SetAvailability(idt);
    }

    @PutMapping("/Assigntoolstoshop/{idt}/{idshop}")
    @ResponseBody
    public Tools assign( @PathVariable("idt") Long idt, @PathVariable("idshop") Long idshop){
        return  categoryServices.AssignToolsToshop(idt, idshop);
    }

    @DeleteMapping("/deletetool/{idt}")
    public ResponseEntity<?> deletetool(@PathVariable("idt") Long idt){
        categoryServices.DeleteTool(idt);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/DeleteShop/{idshop}")
    public  ResponseEntity<?> DeleteShop(@PathVariable("idshop") Long idshop){
        categoryServices.DeleteShop(idshop);
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @DeleteMapping("/DeletePromotion/{pid}")
    public ResponseEntity<?> DeletePromotion(@PathVariable("pid") Long pid){
        categoryServices.DeletePromotion(pid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{pid}/activate")
    public ResponseEntity<Void> ActivatePromotion(@PathVariable("pid") Long pid){
        Promotion promotion = iPromotionRepository.findById(pid).orElseThrow(()-> new PromotionNotFoundException(pid));
        categoryServices.activatePromotion(promotion);
        return ResponseEntity.ok().build();

    }
    @PostMapping("/{pid}/stop")
    public ResponseEntity<Void> StopPromotion(@PathVariable("pid") Long pid){
        Promotion promotion = iPromotionRepository.findById(pid).orElseThrow(()-> new PromotionNotFoundException(pid));
        categoryServices.StopPromotion(promotion);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/GetTools")
    public List<Tools> GetTools(){
        return categoryServices.GetTools() ;
    }

    @PutMapping("/AddPromoToShop/{pid}/{idshop}")
    @ResponseBody
    public Shop Assignpromotoshop(@PathVariable("pid") Long pid, @PathVariable("idshop") Long idshop){
        return categoryServices.Assignpromotoshop(pid,idshop);
    }

    @GetMapping("/getAllPromotions")
    public List<Promotion> getAllPromotions() {
        return categoryServices.getAllPromotions();
    }

    @Scheduled(cron = "0 0 0 * * *") // run at midnight every day
    public void disableExpiredPromotions() {
        categoryServices.disableExpiredPromotions();
    }







   /* @GetMapping("/{idshop}/sorted")
    public List<Tools> getToolsSortedByReviews(@PathVariable("idshop") Long idshop) {
        return categoryServices.getToolsSortedByReviews(idshop);
    }

    @GetMapping("/highest-price/{idshop}")
    public List<Tools> getToolsSortedByHighestPrice(@PathVariable("idshop") Long idshop) {
        return categoryServices.getToolsSortedByHighestPrice(idshop);
    }*/






   /* @PostMapping("/addTools")
    @ResponseBody
    public Tools addTools(@RequestBody Tools tools){return categoryServices.addTools(tools);}*/






}
