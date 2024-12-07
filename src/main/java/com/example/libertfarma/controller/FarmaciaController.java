package com.example.libertfarma.controller;
import com.example.libertfarma.model.Farmacia;
import com.example.libertfarma.repository.FarmaciaRepository;
import com.example.libertfarma.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/farmacias")
public class FarmaciaController {
    @Autowired
    private FarmaciaService farmaciaService;

    // Obtener todas las farmacias
    @GetMapping
    public List<Farmacia> getAllFarmacias() {
        return farmaciaService.getFarmacias();
    }

    // Obtener una farmacia por id
    @GetMapping("/{id}")
    public ResponseEntity<Farmacia> getFarmaciaById(@PathVariable int id) {
        Farmacia farmacia = farmaciaService.getFarmaciaId(id);
        if (farmacia != null) {
            return ResponseEntity.ok(farmacia);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear una farmacia
    @PostMapping
    public Farmacia createFarmacia(@RequestBody Farmacia farmacia) {
        return farmaciaService.createFarmacia(farmacia);
    }

    // Actualizar una farmacia
    @PutMapping("/{id}")
    public ResponseEntity<Farmacia> updateFarmacia(@PathVariable int id, @RequestBody Farmacia farmacia) {
        Farmacia farmacia1 = farmaciaService.actualizarFarmacia(id, farmacia);
        if (farmacia1!= null) {
            return ResponseEntity.ok(farmacia1);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar una farmacia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmacia(@PathVariable int id) {
        Farmacia farmacia = farmaciaService.getFarmaciaId(id);
        if (farmacia != null) {
            farmaciaService.eliminarFarmacia(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
