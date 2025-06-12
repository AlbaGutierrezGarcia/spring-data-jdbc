package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.modelos.Gama;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GamaRepo extends CrudRepository<Gama, String> {

    List<Gama> findAll();
    Optional<Gama> findById(String id);

}
