package com.examen.examendemo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examen.examendemo.models.Idea;

import com.examen.examendemo.repositories.IdeaRepository;


import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class IdeaServices {
    private final IdeaRepository ideaRepository ;

    public List<Idea> buscarTodos(){
        return ideaRepository.findAll();
    }

    public Idea buscarPorId(Long id){
        return ideaRepository.findById(id).orElse(null);
    }
    
    public Idea crearIdea(Idea idea){
        return ideaRepository.save(idea);
    }

    public Idea actualizarIdea(Idea idea){
        return ideaRepository.save(idea);
    }

    public void eliminarIdea(Long id){
        ideaRepository.deleteById(id);
    }

    }



