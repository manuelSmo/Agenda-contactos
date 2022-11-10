package com.manuel.contactos.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contactos")
public class Contacto {

    @Id
    private int idContacto;
    private String nombre;
    private String correo;
    private int edad;

}

