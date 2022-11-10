package com.manuel.contactos.service.impl;

import com.manuel.contactos.dao.ContactoDao;
import com.manuel.contactos.model.Contacto;
import com.manuel.contactos.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServiceImpl implements ContactoService {

    @Autowired
    ContactoDao contactoDao;

    @Override
    public boolean agregarContacto(Contacto contacto) {
        if (contactoDao.buscarContacto(contacto.getIdContacto()) == null){
            contactoDao.agregarContacto(contacto);
            return true;
        }
        return false;
    }

    @Override
    public List<Contacto> listarContactos() {
        return contactoDao.listarContactos();
    }

    @Override
    public boolean eliminarContacto(int idContacto) {
        if (contactoDao.buscarContacto(idContacto) != null){
            contactoDao.eliminarContacto(idContacto);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarContacto(Contacto contacto) {
        if (contactoDao.buscarContacto(contacto.getIdContacto()) != null){
            contactoDao.actualizarContacto(contacto);
            return true;
        }
        return false;
    }

    @Override
    public Contacto buscarContacto(String correo) {
        return contactoDao.buscarContacto(correo);
    }
}
