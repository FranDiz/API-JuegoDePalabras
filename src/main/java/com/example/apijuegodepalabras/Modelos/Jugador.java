package com.example.apijuegodepalabras.Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Entity
public class Jugador {
    @Id @GeneratedValue
    private Long jugador_id;
    private String usuario;
    private Integer puntuacion;
    private String avatar;

    @ManyToOne
    @JoinColumn(name="equipo_id")
    private Equipo equipo_id;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL)
    private List<Partida> partidas;
    public Long getId() {
        return jugador_id;
    }

    public void setId(Long jugador_id) {
        this.jugador_id = jugador_id;
    }
    public String getUser() {
        return usuario;
    }
    public void setUser(String usuario) {
        this.usuario = usuario;
    }

    public int getScore() {
        return puntuacion;
    }
    public void setScore(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    public Equipo getEquipo() {
        return equipo_id;
    }
    public void setEquipo(Equipo equipo_id) {
        this.equipo_id = equipo_id;
    }
}