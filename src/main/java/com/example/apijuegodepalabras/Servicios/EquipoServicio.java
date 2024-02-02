package com.example.apijuegodepalabras.Servicios;

import com.example.apijuegodepalabras.Modelos.Equipo;
import com.example.apijuegodepalabras.Repos.EquipoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipoServicio{
    @Autowired
    private EquipoRepo equipoRepo;

    public List<Equipo> findAll() {
        return equipoRepo.findAll();
    }

    public Optional<Equipo> findById(Long equipo_id) {
        return equipoRepo.findById(equipo_id);
    }

    public Equipo save(Equipo equipo) {
        return equipoRepo.save(equipo);
    }

    public void deleteById(Long equipo_id) {
        equipoRepo.deleteById(equipo_id);
    }

    public boolean existsById(Long equipo_id) {
        return equipoRepo.existsById(equipo_id);
    }

}