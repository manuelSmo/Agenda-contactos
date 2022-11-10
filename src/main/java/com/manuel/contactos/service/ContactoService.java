package com.manuel.contactos.service;

import com.manuel.contactos.model.Contacto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContactoService {

    boolean agregarContacto(Contacto contacto);
    List<Contacto> listarContactos();
    boolean eliminarContacto(int idContacto);
    boolean actualizarContacto(Contacto contacto);
    Contacto buscarContacto(String correo);
}
