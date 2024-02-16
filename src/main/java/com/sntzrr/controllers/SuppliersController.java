package com.sntzrr.controllers;

import com.sntzrr.models.Suppliers;
import com.sntzrr.services.SuppliersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SuppliersController {
    @Autowired
    private final SuppliersServiceImpl suppliersService;

    @GetMapping
    public List<Suppliers> getSuppliers (){
        return this.suppliersService.findSuppliers();
    }

    @PostMapping
    public Suppliers createSupplier (@Validated @RequestBody Suppliers supplier){
        return this.suppliersService.saveSupplier(supplier);
    }

    @PutMapping("/{id_supplier}")
    public Suppliers updateSupplier (@PathVariable Integer id_supplier, @Validated @RequestBody Suppliers supplier){
        return this.suppliersService.saveSupplier(supplier);
    }

    @DeleteMapping("/{id_supplier}")
    public void deleteSupplierById (@PathVariable Integer id_supplier){
        this.suppliersService.deleteSupplierById(id_supplier);
    }
}
