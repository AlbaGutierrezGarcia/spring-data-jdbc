package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.GamaProductoDTOLista;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GamaProductoRepo extends CrudRepository<GamaProductoRepo, String> {
    @Query("""
        SELECT gama, descripcion_texto
        FROM gama_producto
        ORDER BY gama
        """)
    List<GamaProductoDTOLista> findAllDTOs();
}
