package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.modelos.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepo extends CrudRepository<Producto, Integer> {
}
