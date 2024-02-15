package com.sntzrr.repositories;

import com.sntzrr.models.Bills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillsRepository extends JpaRepository<Bills, Integer> {
}
