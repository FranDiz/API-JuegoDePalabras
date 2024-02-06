package com.example.apijuegodepalabras.Controladores;
import com.example.apijuegodepalabras.Excepciones.PalabraNotFoundException;
import com.example.apijuegodepalabras.Servicios.PalabraServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(produces = "application/json")
@RestController
@RequiredArgsConstructor
public class PalabraControlador {
    @Autowired
    private PalabraServicio palabraServicio;
    @GetMapping("/palabra")
    public String obtenerPalabra() {
        String palabra = palabraServicio.obtenerPalabra();
        if(palabra == null){
            throw new PalabraNotFoundException();
        }
        return palabra;


    }
    @GetMapping("/palabras")
    public List<String> obtenerTodasPalabras() {
        List<String> palabras = palabraServicio.obtenerTodasPalabras();
        if(palabras == null || palabras.isEmpty()){
            throw new PalabraNotFoundException();
        }
        return palabras;


    }
    @GetMapping("/palabras/{numero}")
    public List<String> obtenerPalabras(@PathVariable Long numero) {
        List<String> palabras =  palabraServicio.obtenerPalabras(numero);
        if(palabras == null || palabras.isEmpty()){
            throw new PalabraNotFoundException();
        }
        return palabras;

    }
    @GetMapping("/palabra/filtro={filtro}")
    public String obtenerPalabraFiltrada(@PathVariable String filtro) {
        String palabra=  palabraServicio.obtenerPalabraFiltrada(filtro);
        if(palabra==null){
            throw new PalabraNotFoundException();
        }
        return palabra;


    }
    @GetMapping("/palabras/filtro={filtro}")
    public List<String> obtenerTodasPalabraFiltrada(@PathVariable String filtro) {
        List<String> palabras = palabraServicio.obtenerTodasPalabraFiltrada(filtro);
        if(palabras==null || palabras.isEmpty()){
            throw new PalabraNotFoundException();
        }
        return palabras;


    }
}
