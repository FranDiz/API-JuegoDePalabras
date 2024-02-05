package com.example.apijuegodepalabras.Controladores;

import com.example.apijuegodepalabras.Excepciones.JuegoNotFoundException;
import com.example.apijuegodepalabras.Modelos.Juego;

import com.example.apijuegodepalabras.Servicios.JuegoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JuegoControlador {
    private final JuegoServicio juegoServicio;
    @GetMapping("/juego")
    public List<Juego> obtenerTodos() {
        List<Juego> result =  juegoServicio.findAll();
        if(result.isEmpty()){
            throw new JuegoNotFoundException();
        }
        return result;
    }

    @GetMapping("/juego/{id}")
    public Juego obtenerUno(@PathVariable Long id) {
        return juegoServicio.findById(id).orElseThrow(() -> new JuegoNotFoundException(id));
    }

    @PostMapping("/juego")
    public Juego newJuego(@RequestBody Juego newJuego){
        return juegoServicio.save(newJuego);
    }

    @PutMapping("/juego/{id}")
    public Juego updateJuego(@RequestBody Juego updateJuego, @PathVariable Long id){
        if (juegoServicio.existsById(id)) {
            Juego juego = juegoServicio.findById(id).get();
            juego.setDificultadjuego(updateJuego.getDificultadjuego());
            juego.setDescripcion(updateJuego.getDescripcion());
            juego.setIntentosDificultad(updateJuego.getIntentosDificultad());
            return juegoServicio.save(updateJuego);
        } else {
            throw new JuegoNotFoundException(id);
        }
    }

    @DeleteMapping("/juego/{id}")
    public Juego deleteJuego(@PathVariable Long id) {
        if(juegoServicio.existsById(id)){
            Juego result = juegoServicio.findById(id).get();
            juegoServicio.deleteById(id);
            return result;
        }else{
            throw new JuegoNotFoundException(id);
        }
    }
}