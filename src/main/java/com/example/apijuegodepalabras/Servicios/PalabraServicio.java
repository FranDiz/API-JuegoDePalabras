package com.example.apijuegodepalabras.Servicios;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PalabraServicio {
    private final Random random = new Random();

    private List<String> readWordsFromFile() {
        try (var reader = new BufferedReader(new InputStreamReader(new ClassPathResource("palabras.txt").getInputStream()))) {
            return reader.lines().map(String::trim).collect(Collectors.toList());
        } catch (IOException ioe) {
            return List.of();
        }
    }

    public String obtenerPalabra() {
        var palabras = readWordsFromFile();
        return palabras.get(random.nextInt(palabras.size()));
    }

    public List<String> obtenerTodasPalabras() {
        return readWordsFromFile();
    }

    public String obtenerPalabraFiltrada(String cadena) {
        var palabrasFiltradas = readWordsFromFile().stream()
                .filter(p -> p.contains(cadena))
                .collect(Collectors.toList());
        return palabrasFiltradas.isEmpty() ? null : palabrasFiltradas.get(random.nextInt(palabrasFiltradas.size()));
    }

    public List<String> obtenerTodasPalabraFiltrada(String cadena) {
        return readWordsFromFile().stream()
                .filter(p -> p.contains(cadena))
                .collect(Collectors.toList());
    }

    public List<String> obtenerPalabras(Long numero) {
        var palabras = readWordsFromFile();
        return random.ints(numero.intValue(), 0, palabras.size())
                .mapToObj(palabras::get)
                .collect(Collectors.toList());
    }
}