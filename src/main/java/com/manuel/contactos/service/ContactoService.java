package com.manuel.contactos.service;

import com.manuel.contactos.model.Contacto;

import java.util.List;

public interface ContactoService {

    void agregarContacto(Contacto contacto) throws Exception;
    List<Contacto> listarContactos();
    boolean eliminarContacto(int idContacto);
    boolean actualizarContacto(Contacto contacto);
    Contacto buscarContacto(String correo);
}
