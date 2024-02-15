package com.sntzrr.services;

import com.sntzrr.models.Bills;
import com.sntzrr.repositories.IBillsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillsServiceImpl {
    @Autowired
    private final IBillsRepository iBillsRepository;

    public List<Bills> findBills (){
        return this.iBillsRepository.findAll();
    }

    public Bills saveBill (Bills bill){
        return this.iBillsRepository.save(bill);
    }

    public void deleteBillById (Integer id_bill){
        this.iBillsRepository.deleteById(id_bill);
    }
}
