package com.example.apijuegodepalabras.Servicios;
import com.example.apijuegodepalabras.Modelos.Equipo;
import com.example.apijuegodepalabras.Modelos.Jugador;
import com.example.apijuegodepalabras.Repos.JugadorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JugadorServicioImpl implements JugadorServicio {
    private final JugadorRepo jugadorRepo;

    @Override
    public List<Jugador> findAll() {
        return jugadorRepo.findAll();
    }
    @Override
    public void getId(Long id) {
        jugadorRepo.getById(id);
    }
    @Override
    public Optional<Jugador> findById(Long id) {
        return jugadorRepo.findById(id);
    }

    @Override
    public Jugador save(Jugador jugador) {
        return jugadorRepo.save(jugador);
    }

    @Override
    public void deleteById(Long id) {
        jugadorRepo.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jugadorRepo.existsById(id);
    }

    @Override
    public List<Jugador> findByEquipo(Equipo equipo) {
        return jugadorRepo.findByEquipoId(equipo.getEquipo_id());
    }

    @Override
    public List<Jugador> obtenerJugadoresPorEquipo(Long id_equipo) {
        return jugadorRepo.findByEquipoId(id_equipo);
    }
    @Override
    public List<Jugador> findByEquipoId(Long id) {
        return jugadorRepo.findByEquipoId(id);
    }
}