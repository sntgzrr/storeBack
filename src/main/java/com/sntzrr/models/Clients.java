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
@Entity(name = "Clients")
@Table(name = "\"Clients\"", schema = "public")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Clients implements Serializable {
    @Id
    @Column(name = "id_client", nullable = false)
    Integer id_client;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "address")
    String address;
    @Column(name = "phone")
    String phone;
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id_bill"
    )// Se utiliza para manejar relaciones bidireccionales entre entidades (Clients - Bills). Se asegura de la serialización/deserialización de objetos Bills referenciados desde un objeto Client se haga correctamente.
    @JsonIdentityReference(alwaysAsId = true) //Hace que me muestre únciamente el elemento "id_bill" dentro del JSON.
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY /*Cómo se cargarán los objetos Bills*/,
               cascade = CascadeType.ALL,
               orphanRemoval = true /*Si un objeto Bills se elimina de la lista bills de un objeto Client, también se eliminará de la base de datos*/)
    List<Bills> bills;
}
