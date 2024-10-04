package com.examen.examendemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.examen.examendemo.models.Usuario;
import com.examen.examendemo.services.UsuarioServices;
import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor

public class UsuarioApi {

        private final UsuarioServices usuarioServices;

    @GetMapping("")
    public List<Usuario> listarUsuarios() {
    return usuarioServices.buscarTodos();
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuario(
        @PathVariable("id") Long id) {
        return usuarioServices.buscarporId(id);
    }

    @PostMapping("")
    public Usuario crearUsuario(
        @RequestParam("nombre") String nombre,
        @RequestParam("email") String email,
        @RequestParam("password") String password,
        @RequestParam("confirmarpass") String confirmarpass){
        if (!password.equals(confirmarpass)) {
                throw new IllegalArgumentException("Las contraseñas no coinciden");}

        Usuario usuario = new Usuario(nombre,email,password,confirmarpass, null);
        return usuarioServices.crearUsuario(usuario);
    
}
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(
        @PathVariable("id") Long id,
        @RequestParam("nombre") String nombre,
        @RequestParam("email") String email,
        @RequestParam("password") String password,
        @RequestParam("passwordconfirm") String confirmarpass) {

            if (!password.equals(confirmarpass)) {
                throw new IllegalArgumentException("Las contraseñas no coinciden");}
                
        Usuario usuario = usuarioServices.buscarporId(id);
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setConfirmarpass(confirmarpass);
        return usuarioServices.actualizarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable("id") Long id) { 
        usuarioServices.eliminarUsuario(id);
    }
    
}
