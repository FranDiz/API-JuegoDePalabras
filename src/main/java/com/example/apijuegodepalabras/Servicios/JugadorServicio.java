package com.example.apijuegodepalabras.Servicios;
import com.example.apijuegodepalabras.Modelos.Equipo;
import com.example.apijuegodepalabras.Modelos.Jugador;

import java.util.List;
import java.util.Optional;

public interface JugadorServicio {
    List<Jugador> findAll();
    Optional<Jugador> findById(Long jugador_id);
    Jugador save(Jugador jugador);
    void deleteById(Long jugador_id);

    void getId(Long jugador_id);
    boolean existsById(Long juador_id);

    List<Jugador> findByEquipo(Equipo equipo);
    List<Jugador> obtenerJugadoresPorEquipo(Long equipo_id);

    List<Jugador> findByEquipoId(Long equipo_id);
}
