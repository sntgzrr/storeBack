package com.sntzrr.services;

import com.sntzrr.models.Products;
import com.sntzrr.repositories.IProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl {
    @Autowired
    private final IProductsRepository iProductsRepository;

    public List<Products> findProducts(){
        return this.iProductsRepository.findAll();
    }

    public Products saveProduct (Products product){
        return this.iProductsRepository.save(product);
    }

    public void deleteProductById (Integer id_product){
        this.iProductsRepository.deleteById(id_product);
    }
}
