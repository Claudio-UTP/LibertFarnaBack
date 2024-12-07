package com.example.libertfarma.service;
import com.example.libertfarma.model.Cliente;
import com.example.libertfarma.model.Farmacia;
import com.example.libertfarma.repository.ClienteRepository;
import com.example.libertfarma.repository.FarmaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private FarmaciaRepository farmaciaRepository;

    // Obtener todos los clientes
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por id
    public Cliente getClienteId(int id) {
        return clienteRepository.findById(id).orElse(null);
    }

    // Crear un nuevo cliente
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente
    public Cliente actualizarCliente(int id, Cliente cliente) {
        Cliente clienteActual = clienteRepository.findById(id).orElse(null);
        //Saber la farmacia a la que pertenece el cliente
        Farmacia farmacia = farmaciaRepository.findById(cliente.getFarmacia().getId()).orElse(null);
        if (clienteActual != null && farmacia != null) {
            clienteActual.setNombre(cliente.getNombre());
            clienteActual.setApellido(cliente.getApellido());
            clienteActual.setTelefono(cliente.getTelefono());
            clienteActual.setEmail(cliente.getEmail());
            clienteActual.setDireccion(cliente.getDireccion());
            clienteActual.setFarmacia(farmacia);
            return clienteRepository.save(clienteActual);
        } else {
            return null;
        }
    }

    // Eliminar un cliente
    public void eliminarCliente(int id) {
        clienteRepository.deleteById(id);
    }
}
