package com.examen.examendemo.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario extends BaseModel{

    @JsonManagedReference
    @NotNull
    private String nombre;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String confirmarpass;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private  List<Idea> ideas;

    }
