package com.sntzrr.controllers;

import com.sntzrr.models.Sales;
import com.sntzrr.services.SalesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SalesController {
    @Autowired
    private final SalesServiceImpl salesService;

    @GetMapping
    public List<Sales> getSales(){
        return this.salesService.findSales();
    }

    @PostMapping
    public Sales createSale (@Validated @RequestBody Sales sale){
        return this.salesService.saveSale(sale);
    }

    @PutMapping("/{id_sale}")
    public Sales updateSale (@PathVariable Integer id_sale, @RequestBody Sales sale){
        return this.salesService.saveSale(sale);
    }

    @DeleteMapping("/{id_sale}")
    public void deleteSaleById (@PathVariable Integer id_sale){
        this.salesService.deleteSaleById(id_sale);
    }
}
