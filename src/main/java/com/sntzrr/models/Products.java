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
@Entity(name = "Products")
@Table(name = "\"Products\"")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Products implements Serializable {
    @Id
    @Column(name = "id_product", nullable = false)
    Integer id_product;
    @Column(name = "description")
    String description;
    @Column(name = "price", nullable = false)
    Double price;
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id_sale"
    )
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Sales> sales;
    @ManyToOne
    @JoinColumn(
            name = "category_id",
            referencedColumnName = "id_category",
            foreignKey = @ForeignKey(
                    name = "fk_product_category",
                    foreignKeyDefinition = " FOREIGN KEY (category_id)\r\n" +
                            " REFERENCES public.\"Categories\" (id_category) MATCH SIMPLE\r\n" +
                            " ON UPDATE CASCADE\r\n" +
                            " ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    Categories category;
    @ManyToOne
    @JoinColumn(
            name = "supplier_id",
            referencedColumnName = "id_supplier",
            foreignKey = @ForeignKey(
                    name = "fk_product_supplier",
                    foreignKeyDefinition = " FOREIGN KEY (supplier_id)\r\n" +
                            " REFERENCES public.\"Suppliers\" (id_supplier) MATCH SIMPLE\r\n" +
                            " ON UPDATE CASCADE\r\n" +
                            " ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    Suppliers supplier;
}
