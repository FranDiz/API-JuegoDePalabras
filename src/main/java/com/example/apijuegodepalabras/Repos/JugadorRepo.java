package com.example.apijuegodepalabras.Repos;

import com.example.apijuegodepalabras.Modelos.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugadorRepo extends JpaRepository<Jugador, Long> {
    List<Jugador> findByEquipoId(Long id_equipo);
}