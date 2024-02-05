package com.example.apijuegodepalabras.Servicios;
import com.example.apijuegodepalabras.Excepciones.JugadorNotFoundException;
import com.example.apijuegodepalabras.Modelos.Partida;
import com.example.apijuegodepalabras.Repos.PartidaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartidaServicioImpl implements PartidaServicio{
    private final PartidaRepo partidaRepo;

    @Override
    public List<Partida> findAll() {
        return partidaRepo.findAll();
    }

    @Override
    public Optional<Partida> findById(Long partida_id) {
        return partidaRepo.findById(partida_id);
    }

    @Override
    public Partida save(Partida partida) {
        return partidaRepo.save(partida);
    }

    @Override
    public void deleteById(Long partida_id) {
        partidaRepo.deleteById(partida_id);
    }

    @Override
    public boolean existsById(Long partida_id) {
        return partidaRepo.existsById(partida_id);
    }
    @Override
    public List<Partida> findByJugadorId(Long jugador_id) {
        return partidaRepo.findByJugadorId(jugador_id);
    }
    @Override
    public int getTotalPuntosByJugadorId(Long jugador_id) {
        List<Partida> partidas = findByJugadorId(jugador_id);
        if(partidas == null || partidas.isEmpty()){
            throw new JugadorNotFoundException(jugador_id);
        }
        int totalPuntos = 0;
        for (Partida partida : partidas) {
            totalPuntos += partida.getPuntuacion();
        }
        return totalPuntos;
    }

}
