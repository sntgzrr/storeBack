package com.sntzrr.controllers;

import com.sntzrr.models.Categories;
import com.sntzrr.services.CategoriesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoriesController {
    @Autowired
    private final CategoriesServiceImpl categoriesService;

    @GetMapping
    public List<Categories> getCategories(){
        return this.categoriesService.findCategories();
    }

    @PostMapping
    public Categories createCategory(@Validated @RequestBody Categories category){
        return this.categoriesService.saveCategory(category);
    }

    @PutMapping("/{id_category}")
    public Categories updateCategory(@PathVariable Integer id_category, @Validated @RequestBody Categories category){
        return this.categoriesService.saveCategory(category);
    }

    @DeleteMapping("/{id_category}")
    public void deleteCategoryById(@PathVariable Integer id_category){
        this.categoriesService.deleteCategoryById(id_category);
    }
}
