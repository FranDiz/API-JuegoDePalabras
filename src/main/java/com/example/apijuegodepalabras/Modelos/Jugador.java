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
}