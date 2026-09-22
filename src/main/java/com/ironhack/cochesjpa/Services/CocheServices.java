package com.ironhack.cochesjpa.Services;

import com.ironhack.cochesjpa.Entity.Coche;
import com.ironhack.cochesjpa.Repository.CocheRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CocheServices {

    @Autowired
    private CocheRepository cocheRepositoryService;

    //Mostrar todos los coches
    public List<Coche> obtenerTodos() {
        return cocheRepositoryService.findAll();
    }

    //Mostrar un coche por su ID
    public Optional<Coche> obtenerPorId(Long id) {
        return cocheRepositoryService.findById(id);
    }

    //Guardar un coche
    public Coche guardar(Coche coche) {
        return cocheRepositoryService.save(coche);
    }

    //Guardar varios coches
    public List<Coche> guardarVarios(List<Coche> coches) {
    return cocheRepositoryService.saveAll(coches);
}
    
    //Eliminar un coche por su ID
    public void eliminar(Long id) {
        cocheRepositoryService.deleteById(id);
    }
}
