package com.sntzrr.controllers;

import com.sntzrr.models.Products;
import com.sntzrr.services.ProductsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {
    @Autowired
    private final ProductsServiceImpl productsService;

    @GetMapping
    public List<Products> getProducts(){
        return this.productsService.findProducts();
    }

    @PostMapping
    public Products createProduct (@Validated @RequestBody Products product){
        return this.productsService.saveProduct(product);
    }

    @PutMapping("/{id_product}")
    public Products updateProduct (@PathVariable Integer id_product, @Validated @RequestBody Products product){
        return this.productsService.saveProduct(product);
    }

    @DeleteMapping("/{id_product}")
    public void deleteProductById (@PathVariable Integer id_product){
        this.productsService.deleteProductById(id_product);
    }
}
