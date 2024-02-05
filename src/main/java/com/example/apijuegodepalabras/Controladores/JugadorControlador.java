package com.example.apijuegodepalabras.Controladores;

import com.example.apijuegodepalabras.Excepciones.JugadorNotFoundException;
import com.example.apijuegodepalabras.Modelos.Jugador;
import com.example.apijuegodepalabras.Servicios.JugadorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class JugadorControlador{

    private final JugadorServicio jugadorServicio;

    @GetMapping("/jugador")
    public List<Jugador> findAll() {
        List<Jugador> result =  jugadorServicio.findAll();
        if(result.isEmpty()){
            throw new JugadorNotFoundException();
        }
        return result;
    }

    @GetMapping("/jugador/{id}")
    public Jugador findById(@PathVariable Long id) {
        return jugadorServicio.findById(id).orElseThrow(() -> new JugadorNotFoundException(id));
    }
    @PostMapping("/jugador")
    public Jugador newJugador(@RequestBody Jugador newJugador){
        return jugadorServicio.save(newJugador);
    }

    @PutMapping("/jugador/{id}")
    public Jugador updateJugador(@RequestBody Jugador updateJugador, @PathVariable Long id){
        if(jugadorServicio.existsById(id)){
            Jugador jugador = jugadorServicio.findById(id).get();
            jugador.setUser(updateJugador.getUser());
            jugador.setScore(updateJugador.getScore());
            jugador.setAvatar(updateJugador.getAvatar());
            jugador.setEquipo(updateJugador.getEquipo());
            return jugadorServicio.save(jugador);
        } else {
            throw new JugadorNotFoundException(id);
        }
    }

    @DeleteMapping("/jugador/{id}")
    public Jugador deleteJugador(@PathVariable Long id) {
        if(jugadorServicio.existsById(id)){
            Jugador result = jugadorServicio.findById(id).get();
            jugadorServicio.deleteById(id);
            return result;
        } else {
            throw new JugadorNotFoundException(id);
        }
    }
    @GetMapping("/equipo/{id_equipo}/jugadores")
    public ResponseEntity<List<Jugador>> obtenerJugadoresPorEquipo(@PathVariable Long id_equipo) {
        List<Jugador> jugadores = jugadorServicio.obtenerJugadoresPorEquipo(id_equipo);

        if(jugadores == null || jugadores.isEmpty()){
            throw new JugadorNotFoundException();
        }
        return ResponseEntity.ok(jugadores);
    }
}
