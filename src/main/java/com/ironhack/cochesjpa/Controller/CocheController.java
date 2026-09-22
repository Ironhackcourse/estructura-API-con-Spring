package com.ironhack.cochesjpa.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ironhack.cochesjpa.Entity.Coche;
import com.ironhack.cochesjpa.Services.CocheServices;

@RestController
@RequestMapping("/coche/")

public class CocheController {

    private final CocheServices cocheService;

    public CocheController(CocheServices cocheService) {
        this.cocheService = cocheService;
    }

    @GetMapping
    public List<Coche> obtenerTodos() {
        return cocheService.obtenerTodos();
    }

    @GetMapping("{id}")
    public ResponseEntity<Coche> obtenerPorId(@PathVariable Long id) {

        return cocheService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Coche crear(@RequestBody Coche coche) {
        return cocheService.guardar(coche);
    }

    @PostMapping("varios")
    public List<Coche> crearVarios(@RequestBody List<Coche> coches) {
        return cocheService.guardarVarios(coches);
    }

    @PutMapping("{id}")
    public ResponseEntity<Coche> actualizar(
            @PathVariable Long id,
            @RequestBody Coche coche) {

        return cocheService.obtenerPorId(id)
                .map(cocheExistente -> {

                    cocheExistente.setMarca(coche.getMarca());
                    cocheExistente.setModelo(coche.getModelo());
                    cocheExistente.setMatricula(coche.getMatricula());
                    cocheExistente.setPrecio(coche.getPrecio());

                    return ResponseEntity.ok(
                            cocheService.guardar(cocheExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        if (cocheService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        cocheService.eliminar(id);

        return ResponseEntity.noContent().build();
    }

}
