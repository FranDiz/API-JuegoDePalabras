package com.example.apijuegodepalabras.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PalabraNotFoundException extends RuntimeException{

    public PalabraNotFoundException(){
        super("No se pudo encontrar ninguna palabra");
    }
}