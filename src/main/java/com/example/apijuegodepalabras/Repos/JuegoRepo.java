package com.example.apijuegodepalabras.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apijuegodepalabras.Modelos.Juego;

public interface JuegoRepo extends JpaRepository<Juego, Long>{
}
