package com.example.apijuegodepalabras.Repos;

import com.example.apijuegodepalabras.Modelos.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartidaRepo extends JpaRepository<Partida, Long> {
    List<Partida> findByJugadorId(Long jugador_id);
}