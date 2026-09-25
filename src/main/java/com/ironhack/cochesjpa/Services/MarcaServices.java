package com.ironhack.cochesjpa.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ironhack.cochesjpa.Entity.Marca;
import com.ironhack.cochesjpa.Repository.MarcaRepository;

@Service
public class MarcaServices {

    @Autowired
    private MarcaRepository marcaRepositoryService;

    // Mostrar todas las marcas
    public List<Marca> obtenerTodos() {
        return marcaRepositoryService.findAll();
    }

    // Mostrar una marca por su ID
    public Optional<Marca>  obtenerPorId(Long id) {
          return marcaRepositoryService.findById(id);
    }

    // Guardar una marca
    public Marca guardar(Marca marca) {
        return marcaRepositoryService.save(marca);
    }

    // Guardar varios coches
    public List<Marca> guardarVarios(List<Marca> marcas) {
        return marcaRepositoryService.saveAll(marcas);
    }

    // Eliminar un coche por su ID
    public void eliminar(Long id) {
        marcaRepositoryService.deleteById(id);
    }

}
