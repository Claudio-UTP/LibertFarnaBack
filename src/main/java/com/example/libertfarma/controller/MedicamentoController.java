package com.example.libertfarma.controller;
import com.example.libertfarma.model.Medicamento;
import com.example.libertfarma.repository.MedicamentoRepository;
import com.example.libertfarma.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {
    @Autowired
    private MedicamentoService medicamentoService;

    // Obtener la lista de todos los medicamentos registrados
    @GetMapping
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoService.getMedicamentos();
    }

    // Obtener un medicamento por su id
    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable int id) {
        Medicamento medicamento = medicamentoService.getMedicamentoId(id);
        if (medicamento != null) {
            return ResponseEntity.ok(medicamento);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear un nuevo medicamento
    @PostMapping
    public Medicamento createMedicamento(@RequestBody Medicamento medicamento) {
        return medicamentoService.createMedicamento(medicamento);
    }

    // Actualizar un medicamento existente
    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable int id, @RequestBody Medicamento medicamento){
        Medicamento medicamento1 = medicamentoService.actualizarMedicamento(id, medicamento);
        if (medicamento1 != null) {
            return ResponseEntity.ok(medicamento1);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un medicamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable int id){
        Medicamento medicamento = medicamentoService.getMedicamentoId(id);
        if (medicamento != null) {
            medicamentoService.eliminarMedicamento(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
