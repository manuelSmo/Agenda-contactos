package com.manuel.contactos.controllers;

import com.manuel.contactos.model.Contacto;
import com.manuel.contactos.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactosController {

    @Autowired
    ContactoService contactoService;

    @GetMapping(value = "contactos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Contacto> listarContactos(){
        return contactoService.listarContactos();
    }

    @GetMapping(value = "contactos/{correo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Contacto buscarContacto(@PathVariable("correo") String correo){
        return contactoService.buscarContacto(correo);
    }

    @PostMapping(value = "contactos/agregar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean agregarContacto(@RequestBody Contacto contacto){
        return contactoService.agregarContacto(contacto);
    }

    @PutMapping(value = "contactos/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean actualizarContacto(@RequestBody Contacto contacto){
        return contactoService.actualizarContacto(contacto);
    }

    @DeleteMapping(value = "contactos/eliminar/{id}")
    public boolean eliminarContacto(@PathVariable("id") int idContacto){
        return contactoService.eliminarContacto(idContacto);
    }
}
