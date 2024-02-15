package com.sntzrr.controllers;

import com.sntzrr.models.Bills;
import com.sntzrr.services.BillsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
@RequiredArgsConstructor
public class BillsController {
    @Autowired
    private final BillsServiceImpl billsService;

    @GetMapping
    public List<Bills> getBills (){
        return this.billsService.findBills();
    }

    @PostMapping
    public Bills saveBill (@Validated @RequestBody Bills bill){
        return this.billsService.saveBill(bill);
    }

    @PutMapping("/{id_bill}")
    public Bills updateBill (@PathVariable Integer id_bill ,@Validated @RequestBody Bills bill){
        return this.billsService.saveBill(bill);
    }

    @DeleteMapping("/{id_bill}")
    public void deleteBill (@PathVariable Integer id_bill){
        this.billsService.deleteBillById(id_bill);
    }
}
