package com.sntzrr.services;

import com.sntzrr.models.Clients;
import com.sntzrr.repositories.IClientsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientsServiceImpl {
    @Autowired
    private final IClientsRepository iClientsRepository;

    public List<Clients> findClients (){
        return this.iClientsRepository.findAll();
    }

    public Clients saveClient (Clients client){
        return this.iClientsRepository.save(client);
    }

    public void deleteClientById (Integer id_client){
        this.iClientsRepository.deleteById(id_client);
    }
}
