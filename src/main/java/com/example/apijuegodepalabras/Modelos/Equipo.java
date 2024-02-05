package com.example.apijuegodepalabras.Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipo {
    @Id
    @GeneratedValue
    private Long equipo_id;
    private String nombre;
    private String emblema;
    private Integer puntuacion;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)

    private List<Jugador> jugadores;
    public Long getId() {
        return equipo_id;
    }
    public void setId(Long equipo_id) {
        this.equipo_id = equipo_id;
    }
    public String getName() {
        return nombre;
    }
    public void setName(String nombre) {
        this.nombre = nombre;
    }
}