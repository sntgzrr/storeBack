package com.sntzrr.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "Suppliers")
@Table(name = "\"Suppliers\"")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Suppliers implements Serializable {
    @Id
    @Column(name = "id_supplier")
    Integer id_supplier;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "phone")
    String phone;
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id_product"
    )
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Products> products;
}
