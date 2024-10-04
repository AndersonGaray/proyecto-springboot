package com.examen.examendemo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.examen.examendemo.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    


    @SuppressWarnings("null")
    List<Usuario> findAll();

    @SuppressWarnings("null")
    Optional<Usuario> findById(Long id);
    
}