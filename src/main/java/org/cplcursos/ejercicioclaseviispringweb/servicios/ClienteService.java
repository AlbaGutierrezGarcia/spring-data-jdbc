package org.cplcursos.ejercicioclaseviispringweb.servicios;

import org.cplcursos.ejercicioclaseviispringweb.modelos.Cliente;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.ClienteRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteService {

    ClienteRepo clienteRepo;

    public ClienteService(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    //CRUD

    public Cliente findClienteById(Integer codigo_cliente) {
        Optional<Cliente> cliente = clienteRepo.findById(codigo_cliente);
        return cliente.get();
    }

    public List<Cliente> findAllClientes() {
        return clienteRepo.findAll();
    }

    public void save(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    public void delete(Integer codigo_cliente) {
        clienteRepo.deleteById(codigo_cliente);
    }

}
