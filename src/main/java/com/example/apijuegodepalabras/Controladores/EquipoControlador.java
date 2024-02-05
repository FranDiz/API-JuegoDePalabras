package com.example.apijuegodepalabras.Controladores;

import com.example.apijuegodepalabras.Modelos.Equipo;
import com.example.apijuegodepalabras.Modelos.Jugador;
import com.example.apijuegodepalabras.Servicios.EquipoServicio;
import com.example.apijuegodepalabras.Servicios.JugadorServicio;
import com.example.apijuegodepalabras.Servicios.PartidaServicio;
import com.example.apijuegodepalabras.Excepciones.EquipoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EquipoControlador {
    private final EquipoServicio equipoServicio;
    private final JugadorServicio jugadorServicio;
    private final PartidaServicio partidaServicio;

    @GetMapping("/equipo")
    public List<Equipo> obtenerTodos() {
        List<Equipo> result =  equipoServicio.findAll();
        if(result.isEmpty()){
            throw new EquipoNotFoundException();
        }
        return result;
    }

    @GetMapping("/equipo/{id}/puntos")
    public int obtenerPuntosTotales(@PathVariable Long equipo_id) {
        List<Jugador> jugadores = equipoServicio.findById(equipo_id).orElseThrow(() -> new EquipoNotFoundException(equipo_id)).getJugadores();
        int totalPuntos = 0;

        for (Jugador jugador : jugadores) {
            totalPuntos += partidaServicio.getTotalPuntosByJugadorId(jugador.getId());
        }
        return totalPuntos;
    }

    @GetMapping("/equipo/{id}")
    public Equipo obtenerUno(@PathVariable Long equipo_id) {
        return equipoServicio.findById(equipo_id).orElseThrow(() -> new EquipoNotFoundException(equipo_id));
    }

    @PostMapping("/equipo")
    public Equipo newEquipo(@RequestBody Equipo newEquipo){
        return equipoServicio.save(newEquipo);
    }

    @PutMapping("/equipo/{id}")
    public Equipo updateEquipo(@RequestBody Equipo updateEquipo, @PathVariable Long equipo_id){
        if (equipoServicio.existsById(equipo_id)) {
            updateEquipo.setId(equipo_id);
            Equipo equipo = equipoServicio.findById(equipo_id).get();
            equipo.setName(updateEquipo.getName());
            equipo.setEmblema(updateEquipo.getEmblema());
            equipo.setPuntuacion(updateEquipo.getPuntuacion());
            return equipoServicio.save(updateEquipo);
        } else {
            throw new EquipoNotFoundException(equipo_id);
        }
    }

    @DeleteMapping("/equipo/{id}")
    public Equipo deleteEquipo(@PathVariable Long equipo_id) {
        if(equipoServicio.existsById(equipo_id)){
            Equipo result = equipoServicio.findById(equipo_id).get();
            equipoServicio.deleteById(equipo_id);
            return result;
        }else{
            throw new EquipoNotFoundException(equipo_id);
        }
    }
}