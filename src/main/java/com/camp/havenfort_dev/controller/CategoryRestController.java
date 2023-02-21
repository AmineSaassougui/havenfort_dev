package com.camp.havenfort_dev.controller;


import com.camp.havenfort_dev.entities.Category;
import com.camp.havenfort_dev.entities.Promotion;
import com.camp.havenfort_dev.entities.Shop;
import com.camp.havenfort_dev.entities.Tools;
import com.camp.havenfort_dev.services.ICategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/havenfort")
public class CategoryRestController {
    @Autowired
    ICategoryServices categoryServices;

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

    @PostMapping("/addTools")
    @ResponseBody
    public Tools addTools(@RequestBody Tools tools){return categoryServices.addTools(tools);}






}
