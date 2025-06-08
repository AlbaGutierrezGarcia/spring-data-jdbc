package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.OficinaDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Oficina;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Esta interfaz publica los métodos que se usarán
 */
public interface OficinaRepo extends CrudRepository<Oficina, Integer> {
    List<OficinaDTOLista> listaOficinas();
    String ciudadOficina(String codigoOficina);

}
