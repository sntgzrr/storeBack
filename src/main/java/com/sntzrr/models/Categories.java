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
@Entity(name = "Categories")
@Table(name = "\"Categories\"")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Categories implements Serializable {
    @Id
    @Column(name = "id_category", nullable = false)
    Integer id_category;
    @Column(name = "description", nullable = false)
    String description;
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id_product"
    )
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Products> products;
}
