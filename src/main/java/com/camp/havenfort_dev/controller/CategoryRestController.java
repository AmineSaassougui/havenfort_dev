package com.camp.havenfort_dev.controller;


import com.camp.havenfort_dev.entities.Category;
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



}
