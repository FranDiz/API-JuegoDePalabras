package com.example.apijuegodepalabras.Excepciones;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PartidaNotFoundException extends RuntimeException{

    public PartidaNotFoundException(){
        super("No se pudo encontrar ninguna partida");
    }
    public PartidaNotFoundException(Long id){
        super("No se puede encontrar la partida con la ID: " + id);
    }
}