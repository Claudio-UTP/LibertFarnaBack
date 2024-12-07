package com.example.libertfarma.service;
import com.example.libertfarma.model.Medicamento;
import com.example.libertfarma.model.Farmacia;
import com.example.libertfarma.repository.MedicamentoRepository;
import com.example.libertfarma.repository.FarmaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MedicamentoService {
    @Autowired
    private MedicamentoRepository medicamentoRepository;
    @Autowired
    private FarmaciaRepository farmaciaRepository;
    // Método para obtener todos los medicamentos en una lista
    public List<Medicamento> getMedicamentos() {
        return medicamentoRepository.findAll();
    }

    // Método para obtener un medicamento por su id
    public Medicamento getMedicamentoId(int id) {
        return medicamentoRepository.findById(id).orElse(null);
    }

    // Método para crear/registrar un medicamento
    public Medicamento createMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    // Método para editar un medicamento
    public Medicamento actualizarMedicamento(int id, Medicamento medicamento) {
        Medicamento medicamentoActual = medicamentoRepository.findById(id).orElse(null);
        //Saber la farmacia a la que pertenece el medicamento
        Farmacia farmacia = farmaciaRepository.findById(medicamento.getFarmacia().getId()).orElse(null);
        if (medicamentoActual != null) {
            medicamentoActual.setNombre(medicamento.getNombre());
            medicamentoActual.setDescripcion(medicamento.getDescripcion());
            medicamentoActual.setReceta(medicamento.getReceta());
            medicamentoActual.setTipo(medicamento.getTipo());
            medicamentoActual.setCantidad(medicamento.getCantidad());
            medicamentoActual.setPrecio(medicamento.getPrecio());
            medicamentoActual.setFarmacia(farmacia);
            return medicamentoRepository.save(medicamentoActual);
        } else {
            return null;
        }
    }

    // Método para eliminar un medicamento sabiendo su id
    public void eliminarMedicamento(int id) {
        medicamentoRepository.deleteById(id);
    }
}