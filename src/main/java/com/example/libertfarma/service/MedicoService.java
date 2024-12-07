package com.example.libertfarma.service;
import com.example.libertfarma.model.Medico;
import com.example.libertfarma.model.Farmacia;
import com.example.libertfarma.repository.MedicoRepository;
import com.example.libertfarma.repository.FarmaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private FarmaciaRepository farmaciaRepository;
    // Obtener todos los médicos
    public List<Medico> getMedicos() {
        return medicoRepository.findAll();
    }

    // Obtener un médico por id
    public Medico getMedicoId(int id) {
        return medicoRepository.findById(id).orElse(null);
    }

    // Crear un nuevo médico
    public Medico createMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    // Actualizar un médico existente
    public Medico actualizarMedico(int id, Medico medico) {
        Medico medicoActual = medicoRepository.findById(id).orElse(null);
        //Saber la farmacia a la que pertenece el medico
        Farmacia farmacia = farmaciaRepository.findById(medico.getFarmacia().getId()).orElse(null);
        if (medicoActual != null) {
            medicoActual.setNombre(medico.getNombre());
            medicoActual.setApellido(medico.getApellido());
            medicoActual.setTelefono(medico.getTelefono());
            medicoActual.setEspecialidad(medico.getEspecialidad());
            medicoActual.setEmail(medico.getEmail());
            medicoActual.setFarmacia(farmacia);
            return medicoRepository.save(medicoActual);
        }else {
        return null;
    }
    }
    // Eliminar un médico
    public void eliminarMedico(int id) {
        medicoRepository.deleteById(id);
    }
}
