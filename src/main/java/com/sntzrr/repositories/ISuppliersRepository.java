package com.sntzrr.repositories;

import com.sntzrr.models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISuppliersRepository extends JpaRepository<Suppliers, Integer> {
}
