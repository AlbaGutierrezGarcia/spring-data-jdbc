package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.modelos.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepo extends CrudRepository<Cliente, Integer> {
}
