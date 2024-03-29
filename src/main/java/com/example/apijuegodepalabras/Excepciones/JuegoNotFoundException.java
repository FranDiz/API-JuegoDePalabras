package com.example.apijuegodepalabras.Excepciones;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class JuegoNotFoundException extends RuntimeException{

    public JuegoNotFoundException(){
        super("No se pudo encontrar ningun juego");
    }
    public JuegoNotFoundException(Long id){
        super("No se puede encontrar el juego con la ID: " + id);
    }
}