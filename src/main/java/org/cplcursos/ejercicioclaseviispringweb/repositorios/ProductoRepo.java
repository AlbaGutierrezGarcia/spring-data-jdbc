package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.modelos.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepo extends CrudRepository<Producto, Integer> {

    List<Producto> findAll();
    Optional<Producto> findById(int id);

}
