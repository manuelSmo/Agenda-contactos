package com.manuel.contactos.controllers;

import com.manuel.contactos.model.Contacto;
import com.manuel.contactos.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class ContactosController {

    @Autowired
    ContactoService contactoService;

    @GetMapping(value = "contactos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contacto>> listarContactos(){
        var listaContactos = contactoService.listarContactos();
        HttpHeaders headers = new HttpHeaders();
        headers.add("total", String.valueOf(listaContactos.size()));
        return new ResponseEntity<List<Contacto>>(listaContactos,headers, HttpStatus.OK);
    }

    @GetMapping(value = "contactos/{correo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contacto> buscarContacto(@PathVariable("correo") String correo){
        return new ResponseEntity<Contacto>(contactoService.buscarContacto(correo),HttpStatus.OK);
    }

    @PostMapping(value = "contactos/agregar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> agregarContacto(@RequestBody Contacto contacto) throws Exception {
        contactoService.agregarContacto(contacto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "contactos/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> actualizarContacto(@RequestBody Contacto contacto){
        if (contactoService.actualizarContacto(contacto)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "contactos/eliminar/{id}")
    public ResponseEntity<Void> eliminarContacto(@PathVariable("id") int idContacto){
        if (contactoService.eliminarContacto(idContacto)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
