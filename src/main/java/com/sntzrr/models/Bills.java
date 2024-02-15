package com.sntzrr.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name = "Bills")
@Table(name = "\"Bills\"", schema = "public")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bills implements Serializable {
    @Id
    @Column(name = "id_bill", nullable = false)
    Integer id_bill;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", nullable = false)
    Date date;
    @ManyToOne
    @JoinColumn(
            name = "client_id", //Nombre de la columna de clave foránea en la tabla.
            referencedColumnName = "id_client", //Nombre de la columna de clave primaria a la que hace referencia la columna de clave foránea.
            foreignKey = @ForeignKey(
                    name = "fk_bill_client",
                    foreignKeyDefinition = " FOREIGN KEY (client_id)\r\n" +
                            " REFERENCES public.\"Clients\" (id_client) MATCH SIMPLE\r\n" +
                            " ON UPDATE CASCADE\r\n" +
                            " ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    Clients client;
}
