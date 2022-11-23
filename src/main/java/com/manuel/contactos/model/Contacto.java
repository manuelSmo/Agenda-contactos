package com.manuel.contactos.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contactos2")
public class Contacto {

    @Id
    @Column(name = "id_contacto")
    private int idContacto;
    private String nombre;
    private String email;
    private int edad;

}

