package com.sntzrr.services;

import com.sntzrr.models.Categories;
import com.sntzrr.repositories.ICategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl {
    @Autowired
    private final ICategoriesRepository iCategoriesRepository;

    public List<Categories> findCategories(){
        return this.iCategoriesRepository.findAll();
    }

    public Categories saveCategory(Categories category){
        return this.iCategoriesRepository.save(category);
    }

    public void deleteCategoryById(Integer id_category){
        this.iCategoriesRepository.deleteById(id_category);
    }
}
