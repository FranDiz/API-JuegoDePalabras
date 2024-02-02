package com.example.apijuegodepalabras.Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @Entity
public class Palabra {
    @Id
    @GeneratedValue
    private Long id_palabra;

    @ManyToOne
    @JoinColumn(name="idJuego")
    private Juego id_juego;

    private String palabra;
    private Dificultad dificultad;
}