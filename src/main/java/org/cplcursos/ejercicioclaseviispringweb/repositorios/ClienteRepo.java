package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.modelos.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepo extends CrudRepository<Cliente, Integer> {

    Optional<Cliente> findById(Integer id);
    List<Cliente> findAll();


}
