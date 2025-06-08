package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.OficinaDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Oficina;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Esta interfaz publica los métodos que se usarán
 */
@Repository
public interface OficinaRepo extends CrudRepository<Oficina, String> {

    Oficina findByCodigoOficina(String id);
    List<Oficina> findAll();


    Oficina findByCiudad(String nombre);

}
