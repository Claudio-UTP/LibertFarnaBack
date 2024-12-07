package com.example.libertfarma.controller;
import com.example.libertfarma.model.Medico;
import com.example.libertfarma.repository.MedicoRepository;
import com.example.libertfarma.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    // Obtener todos los médicos
    @GetMapping
    public List<Medico> getAllMedicos() {
        return medicoService.getMedicos();
    }

    // Obtener un médico por id
    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable int id) {
        Medico medico = medicoService.getMedicoId(id);
        if (medico != null) {
            return ResponseEntity.ok(medico);
        }
        return ResponseEntity.notFound().build();
    }

    // Crear un nuevo médico
    @PostMapping
    public Medico createMedico(@RequestBody Medico medico) {
        return medicoService.createMedico(medico);
    }

    // Actualizar un médico existente
    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@PathVariable int id, @RequestBody Medico medico) {
        Medico medico1 = medicoService.actualizarMedico(id, medico);
        if (medico1 != null) {
            return ResponseEntity.ok(medico1);
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un médico
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable int id) {
        Medico medico = medicoService.getMedicoId(id);
        if (medico != null) {
            medicoService.eliminarMedico(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
