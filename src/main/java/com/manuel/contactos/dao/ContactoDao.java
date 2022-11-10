package com.manuel.contactos.dao;

import com.manuel.contactos.model.Contacto;

import java.util.List;

public interface ContactoDao {

    void agregarContacto(Contacto contacto);
    void eliminarContacto(int idContacto);
    void eliminarContacto(String correo);
    void actualizarContacto(Contacto contacto);

    Contacto buscarContacto(int idContacto);
    Contacto buscarContacto(String correo);
    List<Contacto> listarContactos();
}
