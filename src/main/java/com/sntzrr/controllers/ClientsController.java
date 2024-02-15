package com.sntzrr.controllers;

import com.sntzrr.models.Clients;
import com.sntzrr.services.ClientsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientsController {
    @Autowired
    private final ClientsServiceImpl clientsService;

    @GetMapping
    public List<Clients> getClients (){
        return this.clientsService.findClients();
    }

    @PostMapping
    public Clients createClient (@Validated @RequestBody Clients client){
        return this.clientsService.saveClient(client);
    }

    @PutMapping("/{id_client}")
    public Clients updateClient (@PathVariable Integer id_client ,@Validated @RequestBody Clients client){
        return this.clientsService.saveClient(client);
    }

    @DeleteMapping("/{id_client}")
    public void deleteClient (@PathVariable Integer id_client){
        this.clientsService.deleteClientById(id_client);
    }
}
