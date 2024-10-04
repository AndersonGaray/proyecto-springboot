package com.examen.examendemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examen.examendemo.models.Usuario;
import com.examen.examendemo.repositories.UsuarioRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UsuarioServices {
    private final UsuarioRepository usuarioRepository ;

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarporId(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }
    
    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario eliminarUsuario(Long id){
        usuarioRepository.deleteById(id);
        return null;
    }

}


