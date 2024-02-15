package com.sntzrr.repositories;

import com.sntzrr.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientsRepository extends JpaRepository<Clients, Integer> {
}
