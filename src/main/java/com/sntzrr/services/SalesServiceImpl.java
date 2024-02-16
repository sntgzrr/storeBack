package com.sntzrr.services;

import com.sntzrr.models.Sales;
import com.sntzrr.repositories.ISalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl {
    @Autowired
    private final ISalesRepository iSalesRepository;

    public List<Sales> findSales(){
        return this.iSalesRepository.findAll();
    }

    public Sales saveSale (Sales sale){
        return this.iSalesRepository.save(sale);
    }

    public void deleteSaleById (Integer id_sale){
        this.iSalesRepository.deleteById(id_sale);
    }
}
