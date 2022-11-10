package com.manuel.contactos.dao.impl;

import com.manuel.contactos.dao.ContactoDao;
import com.manuel.contactos.model.Contacto;
import com.manuel.contactos.dao.repository.ContactoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactoDaoImpl implements ContactoDao {

    @Autowired
    ContactoRespository contactoRespository;

    @Override
    public void agregarContacto(Contacto contacto) {
        contactoRespository.save(contacto);
    }
    @Override
    public void eliminarContacto(int idContacto) {
        contactoRespository.deleteById(idContacto);
    }
    @Override
    public void eliminarContacto(String correo) {
        contactoRespository.eliminarPorEmail(correo);
    }
    @Override
    public void actualizarContacto(Contacto contacto) {
        contactoRespository.save(contacto);
    }

    @Override
    public Contacto buscarContacto(int idContacto) {
        return contactoRespository.findById(idContacto).orElse(null);
    }

    @Override
    public Contacto buscarContacto(String correo) {
        return contactoRespository.findByEmail(correo);
    }

    @Override
    public List<Contacto> listarContactos() {
        return contactoRespository.findAll();
    }
}
