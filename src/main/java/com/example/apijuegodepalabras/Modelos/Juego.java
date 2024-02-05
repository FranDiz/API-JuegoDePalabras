package com.example.apijuegodepalabras.Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Entity
public class Juego {
    @Id
    @GeneratedValue
    private Long id_juego;

    @Enumerated(EnumType.STRING)
    private String dificultad;

    private String descripcion;
    private Integer intentos;

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL)
    private List<Palabra> palabras;

    public String getDificultadjuego() {
        return dificultad;
    }
    public void setDificultadjuego(String dificultad){
        this.dificultad = dificultad;
    }
    public int getIntentosDificultad() {
        return intentos;
    }
    public void setIntentosDificultad(int intentos) {
        this.intentos = intentos;
    }
}