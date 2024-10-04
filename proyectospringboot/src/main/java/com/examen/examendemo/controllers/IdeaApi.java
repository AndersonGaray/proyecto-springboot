package com.examen.examendemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.examen.examendemo.models.Idea;
import com.examen.examendemo.models.Usuario;
import com.examen.examendemo.services.IdeaServices;
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
@RequestMapping("/api/ideas")
@AllArgsConstructor
public class IdeaApi {

    private final IdeaServices ideaServices;
    private final UsuarioServices usuarioServices;

    // LISTAR IDEAS
    @GetMapping("")
    public List<Idea> listarIdeas() {
        return (List<Idea>) ideaServices.buscarTodos();
    }

    // BUSCAR IDEA POR ID
    @GetMapping("/{id}")
    public Idea buscarIdea(@PathVariable("id") Long id) {
        return ideaServices.buscarPorId(id);
    }

    // CREAR IDEA
    @PostMapping("")
    public Idea crearIdea(
        @RequestParam("contenido") String contenido,
        @RequestParam("usuarioId") Long usuarioId) {

        Usuario buscarUsuario = usuarioServices.buscarporId(usuarioId);
        if (buscarUsuario == null) {
            return null;
        }
        Idea idea = new Idea(contenido, buscarUsuario);
        return ideaServices.crearIdea(idea);
    }

    // ACTUALIZAR IDEA
    @PutMapping("/{id}")
    public Idea actualizarIdea(
        @PathVariable("id") Long id,
        @RequestParam("contenido") String contenido,
        @RequestParam("usuarioId") Long usuarioId) {

        Usuario buscarUsuario = usuarioServices.buscarporId(usuarioId);
        if (buscarUsuario == null) {
            return null;
        }
        Idea idea = ideaServices.buscarPorId(id);
        if (idea == null) {
            return null;
        }
        idea.setContenido(contenido);
        idea.setUsuario(buscarUsuario);
        return ideaServices.actualizarIdea(idea);
    }

    // ELIMINAR IDEA
    @DeleteMapping("/{id}")
    public void eliminarIdea(@PathVariable("id") Long id) {
        ideaServices.eliminarIdea(id);
    }
}
