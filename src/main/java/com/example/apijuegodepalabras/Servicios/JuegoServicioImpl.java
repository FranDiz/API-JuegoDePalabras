package com.example.apijuegodepalabras.Servicios;

import com.example.apijuegodepalabras.Modelos.Juego;
import com.example.apijuegodepalabras.Repos.JuegoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class JuegoServicioImpl implements JuegoServicio {
    private final JuegoRepo juegoRepo;

    @Override
    public List<Juego> findAll() {
        return juegoRepo.findAll();
    }

    @Override
    public Optional<Juego> findById(Long id_juego) {
        return juegoRepo.findById(id_juego);
    }

    @Override
    public Juego save(Juego juego) {
        return juegoRepo.save(juego);
    }

    @Override
    public void deleteById(Long id_juego) {
        juegoRepo.deleteById(id_juego);
    }

    @Override
    public boolean existsById(Long id_juego) {
        return juegoRepo.existsById(id_juego);
    }

}
