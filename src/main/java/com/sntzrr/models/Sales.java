package com.sntzrr.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@Entity(name = "Sales")
@Table(name = "\"Sales\"")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Sales implements Serializable {
    @Id
    @Column(name = "id_sale", nullable = false)
    Integer id_sale;
    @Column(name = "amount", nullable = false)
    Integer amount;
    @ManyToOne
    @JoinColumn(
            name = "bill_id",
            referencedColumnName = "id_bill",
            foreignKey = @ForeignKey(
                    name = "fk_sale_bill",
                    foreignKeyDefinition = " FOREIGN KEY (bill_id)\r\n" +
                            " REFERENCES public.\"Bills\" (id_bill) MATCH SIMPLE\r\n" +
                            " ON UPDATE CASCADE\r\n" +
                            " ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    Bills bill;
    @ManyToOne
    @JoinColumn(
            name = "product_id",
            referencedColumnName = "id_product",
            foreignKey = @ForeignKey(
                    name = "fk_sale_product",
                    foreignKeyDefinition = " FOREIGN KEY (product_id)\r\n" +
                            " REFERENCES public.\"Products\" (id_product) MATCH SIMPLE\r\n" +
                            " ON UPDATE CASCADE\r\n" +
                            " ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    Products product;
}
