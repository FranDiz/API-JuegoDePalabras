package com.example.apijuegodepalabras.Servicios;

import com.example.apijuegodepalabras.Modelos.Juego;

import java.util.List;
import java.util.Optional;

public interface JuegoServicio {
    List<Juego> findAll();
    Optional<Juego> findById(Long id_juego);
    Juego save(Juego juego);
    void deleteById(Long id_juego);
    boolean existsById(Long id_juego);

}
