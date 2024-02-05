package com.example.apijuegodepalabras.Servicios;


import com.example.apijuegodepalabras.Modelos.Partida;

import java.util.List;
import java.util.Optional;

public interface PartidaServicio {
    List<Partida> findAll();
    Optional<Partida> findById(Long partida_id);
    Partida save(Partida jugador);
    void deleteById(Long partida_id);
    boolean existsById(Long partida_id);
    List<Partida> findByJugadorId(Long jugador_id);

    int getTotalPuntosByJugadorId(Long jugador_id);

}
