package com.example.apijuegodepalabras.Controladores;

import com.example.apijuegodepalabras.Modelos.Equipo;
import com.example.apijuegodepalabras.Modelos.Jugador;
import com.example.apijuegodepalabras.Servicios.EquipoServicio;
import com.example.apijuegodepalabras.Servicios.JugadorService;
import com.example.apijuegodepalabras.Servicios.PartidaService;
import com.example.apijuegodepalabras.Exceptions.EquipoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EquipoControlador {
    private final EquipoServicio equipoService;
    private final JugadorService jugadorService;
    private final PartidaService partidaService;

    @GetMapping("/equipo")
    public List<Equipo> obtenerTodos() {
        List<Equipo> result =  equipoService.findAll();
        if(result.isEmpty()){
            throw new EquipoNotFoundException();
        }
        return result;
    }

    @GetMapping("/equipo/{id}/puntos")
    public int obtenerPuntosTotales(@PathVariable Long id) {
        List<Jugador> jugadores = equipoService.findById(id).orElseThrow(() -> new EquipoNotFoundException(id)).getJugadores();
        int totalPuntos = 0;

        for (Jugador jugador : jugadores) {
            totalPuntos += partidaService.getTotalPuntosByJugadorId(jugador.getId());
        }
        return totalPuntos;
    }

    @GetMapping("/equipo/{id}")
    public Equipo obtenerUno(@PathVariable Long id) {
        return equipoService.findById(id).orElseThrow(() -> new EquipoNotFoundException(id));
    }

    @PostMapping("/equipo")
    public Equipo newEquipo(@RequestBody Equipo newEquipo){
        return equipoService.save(newEquipo);
    }

    @PutMapping("/equipo/{id}")
    public Equipo updateEquipo(@RequestBody Equipo updateEquipo, @PathVariable Long id){
        if (equipoService.existsById(id)) {
            updateEquipo.setId(id);
            Equipo equipo = equipoService.findById(id).get();
            equipo.setName(updateEquipo.getName());
            equipo.setEmblema(updateEquipo.getEmblema());
            equipo.setPuntuacion(updateEquipo.getPuntuacion());
            return equipoService.save(updateEquipo);
        } else {
            throw new EquipoNotFoundException(id);
        }
    }

    @DeleteMapping("/equipo/{id}")
    public Equipo deleteEquipo(@PathVariable Long id) {
        if(equipoService.existsById(id)){
            Equipo result = equipoService.findById(id).get();
            equipoService.deleteById(id);
            return result;
        }else{
            throw new EquipoNotFoundException(id);
        }
    }
}