package com.manuel.contactos.dao.repository;

import com.manuel.contactos.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ContactoRespository extends JpaRepository<Contacto,Integer> {
    Contacto findByEmail(String correo);
    @Transactional
    @Modifying
    @Query("Delete from Contacto c Where c.email=?1")
    void eliminarPorEmail(String correo);
}
