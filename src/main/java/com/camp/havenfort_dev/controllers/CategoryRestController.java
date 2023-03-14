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

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRestController {
    @Autowired
    ICategoryServices categoryServices;
    @Autowired
    private IPromotionRepository iPromotionRepository;
    @Autowired
    private Userrepository userrepository;
//////////////////////////////////  Categorie code ///////////////
            @PostMapping("/addCategory")
            @ResponseBody
            public Category addCategory(@RequestBody Category category){return categoryServices.addCategory(category);}

            @PutMapping("/updateCategory")
            @ResponseBody
            public Category updateCategory(@RequestBody Category category){return categoryServices.updateCategory(category);}

            @DeleteMapping("/DeleteCategory/{idc}")
            public ResponseEntity<?> DeleteCategory (@PathVariable ("idc") Long idc){
                categoryServices.DeleteCategory(idc) ;
                return new ResponseEntity<>(HttpStatus.OK);}

            @GetMapping("/GetCategories")
            public List<Category> Getcategories(){
                return categoryServices.GetCategories() ;
            }


            @GetMapping("/findcategoriebyid/{idc}")
            public ResponseEntity<Category> FindCategorieById(@PathVariable("idc") Long idc){
                Category category = categoryServices.FindCategorieById(idc);
                return new ResponseEntity<>(category,HttpStatus.OK);
            }


    ////////////////////// tools code /////////////////
            @PostMapping("/addtools/{idc}")
            @ResponseBody
            public Tools addToolsToCategory(@RequestBody Tools tools, @PathVariable("idc") Long idc){
                return categoryServices.addtoolsAndAssignTocategory(tools, idc);}


           @PutMapping("/Assigntoolstoshop/{idt}/{idshop}")
           public ResponseEntity<Tools> assignToolToShop(@PathVariable Long idt, @PathVariable Long idshop) {
               Tools updatedTool = categoryServices.AssignToolsToshop(idt, idshop);
               return ResponseEntity.ok(updatedTool);
           }



            @PutMapping("/setAvailability/{idt}")
            public void changeAvailability(@PathVariable("idt") Long idt){
                categoryServices.SetAvailability(idt);
            }

            @DeleteMapping("/deletetool/{idt}")
            public ResponseEntity<?> deletetool(@PathVariable("idt") Long idt){
                categoryServices.DeleteTool(idt);
                return new ResponseEntity<>(HttpStatus.OK);}

            @GetMapping("/getallTools")
            public List<Tools> GetTools(){
                return categoryServices.GetTools() ;}

            @GetMapping("findtoolbyid/{idt}")
            public ResponseEntity<Tools> FindtoolsById(@PathVariable("idt") Long idt){
                Tools tools = categoryServices.FindtoolsById(idt);
                return new ResponseEntity<>(tools,HttpStatus.OK);
            }









            @GetMapping("/search")
            public List<Tools> searchTools(@RequestParam("keyword") String keyword) {
                List<Tools> tools = categoryServices.searchTools(keyword);
                if (tools.isEmpty()) {
                    // add recommendation
                    System.out.println("No tools found for the keyword '" + keyword + "'. Try searching for related terms.");
                }
                return tools;
            }








    /////////////////////// shop code //////////////
            @PostMapping("/addShop")
            @ResponseBody
            public Shop addShop(@RequestBody Shop shop){return categoryServices.addShop(shop);}


            @GetMapping("/getallShops")
            public List<Shop> GetShops (){ return categoryServices.GetShops();}

            @DeleteMapping("/DeleteShop/{idshop}")
            public  ResponseEntity<?> DeleteShop(@PathVariable("idshop") Long idshop){
                categoryServices.DeleteShop(idshop);
                return new ResponseEntity<>(HttpStatus.OK);}

            @DeleteMapping("/RemoveToolFromShop/{idshop}/{idt}")
            public void RemoveToolFromShop(@PathVariable("idshop") Long idshop, @PathVariable("idt") Long idt){
                categoryServices.RemovetoolFrominventory(idshop, idt);}

            @GetMapping("/findshops")
            public List<Shop> Searchshops(@RequestParam("keyword") String keyword){
                List<Shop> shops = categoryServices.Searchshops(keyword);
                if (shops.isEmpty()){
                    System.out.println("No shops found for by the name of  '" + keyword + "'. Try searching for related terms.");
                }
                return shops ;}

                @GetMapping("findshopbyid/{idshop}")
                public ResponseEntity<Shop> FindShopById(@PathVariable("idshop") Long idshop){
                    Shop shop = categoryServices.FindShopById(idshop);
                    return new ResponseEntity<>(shop,HttpStatus.OK);
                }

    ///////////////////////////////////   Promotion   /////////////////////////////////


            @PostMapping("/AddPromotionWithGenretedCode")
            public Promotion addPromotionwithcode(@RequestBody Promotion promotion) {
                return categoryServices.addPromotionWithGeneratedCode(promotion);}


            @PutMapping("/promotionsto/{pid}/{idshop}/{idt}")
            public ResponseEntity<?> assignPromotionToShopAndTool(@PathVariable Long pid, @PathVariable Long idshop, @PathVariable Long idt) {
                Shop shop = categoryServices.assignPromotionToShopandtools(pid, idshop, idt);
                if (shop == null) {
                    return ResponseEntity.notFound().build();
                }
                return ResponseEntity.ok(shop);

            }


            @GetMapping("/generate-promo-code")
            public String generatePromoCode() {
                String promoCode = categoryServices.generatePromoCode();
                return promoCode;}




            @DeleteMapping("/DeletePromotion/{pid}")
            public ResponseEntity<?> DeletePromotion(@PathVariable("pid") Long pid){
                categoryServices.DeletePromotion(pid);
                return new ResponseEntity<>(HttpStatus.OK);}

            @PostMapping("/{pid}/activate")
            public ResponseEntity<Void> ActivatePromotion(@PathVariable("pid") Long pid){
                Promotion promotion = iPromotionRepository.findById(pid).orElseThrow(()-> new PromotionNotFoundException(pid));
                categoryServices.activatePromotion(promotion);
                return ResponseEntity.ok().build();}

            @PostMapping("/{pid}/stop")
            public ResponseEntity<Void> StopPromotion(@PathVariable("pid") Long pid){
                Promotion promotion = iPromotionRepository.findById(pid).orElseThrow(()-> new PromotionNotFoundException(pid));
                categoryServices.StopPromotion(promotion);
                return ResponseEntity.ok().build();}


            @GetMapping("/getAllPromotions")
            public List<Promotion> getAllPromotions() {
                return categoryServices.getAllPromotions();}

            @Scheduled(cron = "0 0 0 * * *") // run at midnight every day
            public void disableExpiredPromotions() {
                categoryServices.disableExpiredPromotions();}


            @PutMapping("/applyPromotionToToolInShop/{idshop}/{idt}/{pid}")
            public Tools applyPromotionToToolInShop(@PathVariable Long idshop, @PathVariable Long idt, @PathVariable Long pid){
                return categoryServices.applyPromotionToToolInShop(idshop, idt, pid);
            }

            @GetMapping("findpromotion/{pid}")
            public ResponseEntity<Promotion> FindPromotionById(@PathVariable("pid") Long pid){
                Promotion promotion = categoryServices.FindPromotionById(pid);
                return new ResponseEntity<>(promotion,HttpStatus.OK);
            }




  /* @PostMapping("/addPromotion")
            @ResponseBody
            public Promotion addPromotion(@RequestBody Promotion promotion){return categoryServices.addPromotion(promotion);}*/



}
