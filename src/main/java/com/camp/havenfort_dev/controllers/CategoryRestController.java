package com.camp.havenfort_dev.controllers;


import com.camp.havenfort_dev.entities.Category;
import com.camp.havenfort_dev.entities.Promotion;
import com.camp.havenfort_dev.entities.Shop;
import com.camp.havenfort_dev.entities.Tools;
import com.camp.havenfort_dev.exceptions.PromotionNotFoundException;
import com.camp.havenfort_dev.repositories.IPromotionRepository;
import com.camp.havenfort_dev.services.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRestController {
    @Autowired
    ICategoryServices categoryServices;
    @Autowired
    private IPromotionRepository iPromotionRepository;

    @PostMapping("/addCategory")
    @ResponseBody
    public Category addCategory(@RequestBody Category category){return categoryServices.addCategory(category);}

    @PutMapping("/updateCategory")
    @ResponseBody
    public Category updateCategory(@RequestBody Category category){return categoryServices.updateCategory(category);}

    @PostMapping("/addPromotion")
    @ResponseBody
    public Promotion addPromotion(@RequestBody Promotion promotion){return categoryServices.addPromotion(promotion);}

    @PostMapping("/addShop")
    @ResponseBody
    public Shop addShop(@RequestBody Shop shop){return categoryServices.addShop(shop);}

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
    public ResponseEntity<Void> activatePromotion(@PathVariable Long pid){
        Promotion promotion = iPromotionRepository.findById(pid).orElseThrow(()-> new PromotionNotFoundException(pid));
        categoryServices.activatePromotion(promotion);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/{idshop}/sorted")
    public List<Tools> getToolsSortedByReviews(@PathVariable Long idshop) {
        return categoryServices.getToolsSortedByReviews(idshop);
    }

    @GetMapping("/highest-price/{idshop}")
    public List<Tools> getToolsSortedByHighestPrice(@PathVariable Long idshop) {
        return categoryServices.getToolsSortedByHighestPrice(idshop);
    }




/* .orElseThrow(() -> new PromotionNotFoundException(pid)); */

   /* @PostMapping("/addTools")
    @ResponseBody
    public Tools addTools(@RequestBody Tools tools){return categoryServices.addTools(tools);}*/






}
