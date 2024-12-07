package com.example.libertfarma.service;
import com.example.libertfarma.model.Farmacia;
import com.example.libertfarma.repository.FarmaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FarmaciaService {
    @Autowired
    private FarmaciaRepository farmaciaRepository;

    // Obtener todas las farmacias
    public List<Farmacia> getFarmacias() {
        return farmaciaRepository.findAll();
    }

    // Obtener una farmacia por id
    public Farmacia getFarmaciaId(int id) {
        return farmaciaRepository.findById(id).orElse(null);
    }

    // Crear una farmacia
    public Farmacia createFarmacia(Farmacia farmacia) {
        return farmaciaRepository.save(farmacia);
    }

    // Actualizar una farmacia
    public Farmacia actualizarFarmacia(int id, Farmacia farmacia) {
        Farmacia farmaciaActual = farmaciaRepository.findById(id).orElse(null);
        if (farmaciaActual != null) {
            farmaciaActual.setNombre(farmacia.getNombre());
            farmaciaActual.setDireccion(farmacia.getDireccion());
            farmaciaActual.setTelefono(farmacia.getTelefono());
            farmaciaActual.setEmail(farmacia.getEmail());
            farmaciaActual.setHorario(farmacia.getHorario());
            return farmaciaRepository.save(farmaciaActual);
        }else {
        return null;
    }
    }

    // Eliminar una farmacia
    public void eliminarFarmacia(int id) {
        farmaciaRepository.deleteById(id);
    }
}
