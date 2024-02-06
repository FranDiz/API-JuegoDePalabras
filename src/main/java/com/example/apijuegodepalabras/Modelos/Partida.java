package com.example.apijuegodepalabras.Modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Entity
public class Partida {
    @Id @GeneratedValue
    private Long partida_id;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Integer intentos;
    private String palabra_ronda;
    private Integer puntuacion;

    @ManyToOne
    @JoinColumn(name="jugador_id")
    private Jugador jugador_id;

    @ManyToOne
    @JoinColumn(name="juego_id")
    private Juego juego_id;
    public LocalDateTime getStartTime() {
        return inicio;
    }

    public void setStartTime(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getEndTime() {
        return fin;
    }

    public void setEndTime(LocalDateTime fin) {
        this.fin = fin;
    }

    public String getPalabraRonda() {
        return palabra_ronda;
    }

    public void setPalabraRonda(String palabra_ronda) {
        this.palabra_ronda = palabra_ronda;
    }
}