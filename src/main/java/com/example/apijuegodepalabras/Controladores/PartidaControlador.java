package com.example.apijuegodepalabras.Controladores;
import com.example.apijuegodepalabras.Excepciones.PartidaNotFoundException;
import com.example.apijuegodepalabras.Modelos.Partida;
import com.example.apijuegodepalabras.Servicios.PartidaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping(produces = "application/json")
@RestController
@RequiredArgsConstructor
public class PartidaControlador  {
    @Autowired
    private PartidaServicio partidaServicio;
    @GetMapping("/partida")
    public List<Partida> obtenerTodos() {
        List<Partida> result =  partidaServicio.findAll();
        if(result.isEmpty()){
            throw new PartidaNotFoundException();
        }
        return result;
    }

    @GetMapping("/partida/{id}")
    public Partida getPartida(@PathVariable Long id) {
        return partidaServicio.findById(id).orElseThrow(() -> new PartidaNotFoundException(id));
    }
    @GetMapping("/jugador/{id}/puntos")
    public int getPuntosTotalesJugador(@PathVariable Long id) {
        return  partidaServicio.getTotalPuntosByJugadorId(id);

    }
    @PostMapping("/partida")
    public Partida newPartida(@RequestBody Partida newPartida)
    {
        return partidaServicio.save(newPartida);
    }

    @PutMapping("/partida/{id}")
    public Partida updatePartida(@RequestBody Partida partidaUpdate, @PathVariable Long id) {
        if (partidaServicio.existsById(id)) {
            Partida partida = partidaServicio.findById(id).orElseThrow(() -> new PartidaNotFoundException(id));
            partida.setStartTime(partidaUpdate.getStartTime());
            partida.setEndTime(partidaUpdate.getEndTime());
            partida.setIntentos(partidaUpdate.getIntentos());
            partida.setPalabraRonda(partidaUpdate.getPalabraRonda());
            partida.setPuntuacion(partidaUpdate.getPuntuacion());

            return partidaServicio.save(partida);
        } else {
            throw new PartidaNotFoundException(id);
        }
    }

    @DeleteMapping("partida/{id}")
    public Partida deletePartida(@PathVariable Long id) {
        if(partidaServicio.existsById(id)){
            Partida result = partidaServicio.findById(id).get();
            partidaServicio.deleteById(id);
            return result;
        }else{
            throw new PartidaNotFoundException(id);
        }

    }
}

