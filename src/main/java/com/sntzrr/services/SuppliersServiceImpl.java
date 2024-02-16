package com.sntzrr.services;

import com.sntzrr.models.Suppliers;
import com.sntzrr.repositories.ISuppliersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuppliersServiceImpl {
    @Autowired
    private final ISuppliersRepository iSuppliersRepository;

    public List<Suppliers> findSuppliers (){
        return this.iSuppliersRepository.findAll();
    }

    public Suppliers saveSupplier (Suppliers supplier){
        return this.iSuppliersRepository.save(supplier);
    }

    public void deleteSupplierById (Integer id_supplier){
        this.iSuppliersRepository.deleteById(id_supplier);
    }
}
