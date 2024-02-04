package com.example.apijuegodepalabras.Servicios;
import com.example.apijuegodepalabras.Modelos.Equipo;
import com.example.apijuegodepalabras.Modelos.Jugador;

import java.util.List;
import java.util.Optional;

public interface JugadorServicio {
    List<Jugador> findAll();
    Optional<Jugador> findById(Long id);
    Jugador save(Jugador jugador);
    void deleteById(Long id);
    boolean existsById(Long id);

    List<Jugador> findByEquipo(Equipo equipo);
    List<Jugador> obtenerJugadoresPorEquipo(Long id_equipo);

    List<Jugador> findByEquipoId(Long id);
}
