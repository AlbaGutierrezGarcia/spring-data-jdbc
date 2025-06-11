package org.cplcursos.ejercicioclaseviispringweb.servicios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.ClienteDTO;
import org.cplcursos.ejercicioclaseviispringweb.mapeadores.ClienteMapper;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Cliente;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.ClienteRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteService {

    ClienteRepo clienteRepo;
    ClienteMapper clienteMapper;

    public ClienteService(ClienteRepo clienteRepo, ClienteMapper clienteMapper) {
        this.clienteRepo = clienteRepo;
        clienteMapper = clienteMapper;
    }

    //CRUD

    public ClienteDTO findClienteById(Integer codigo_cliente) {
        Optional<Cliente> cliente = clienteRepo.findById(codigo_cliente);

        if (cliente.isPresent()) {
            return clienteMapper.toDTO(cliente.get());
        }
        else
        {
            return clienteMapper.emptyDTO();
        }
    }

    public List<ClienteDTO> findAllClientes() {
        List <Cliente> clientes = clienteRepo.findAll();
        List<ClienteDTO> clienteDTOs = new ArrayList<>();
        for (Cliente cliente : clientes) {
            //Cogemos los datos del dto
            ClienteDTO clienteDTO = clienteMapper.toDTO(cliente);
            clienteDTOs.add(clienteDTO);
        }

        return clienteDTOs;
    }

    public void save(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    public void delete(Integer codigo_cliente) {
        clienteRepo.deleteById(codigo_cliente);
    }

}
