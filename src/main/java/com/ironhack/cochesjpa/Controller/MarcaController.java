package com.ironhack.cochesjpa.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ironhack.cochesjpa.Entity.Marca;
import com.ironhack.cochesjpa.Services.MarcaServices;

@RestController
@RequestMapping("/marca/")
public class MarcaController {

    private final MarcaServices marcaService;

    public MarcaController(MarcaServices marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public List<Marca> obtenerTodos() {
        return marcaService.obtenerTodos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Marca> obtenerPorId(@PathVariable Long id) {

        return marcaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Marca crear(@RequestBody Marca marca) {
        return marcaService.guardar(marca);
    }

    @PostMapping("varios")
    public List<Marca> crearVarios(@RequestBody List<Marca> marcas) {
        return marcaService.guardarVarios(marcas);
    }

    @PutMapping("{id}")
    public ResponseEntity<Marca> actualizar(
            @PathVariable Long id,
            @RequestBody Marca marca) {

        return marcaService.obtenerPorId(id)
                .map(marcaExistente -> {

                    marcaExistente.setNombre(marca.getNombre());

                    return ResponseEntity.ok(
                            marcaService.guardar(marcaExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        marcaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
