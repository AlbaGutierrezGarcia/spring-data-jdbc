package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.ClienteDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Cliente;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepo extends CrudRepository<Cliente, Integer> {
    // Necesitamos una consulta que devuelva los campos de ClienteDTOLista
    @Query("""
        SELECT codigo_cliente, nombre_cliente, telefono, linea_direccion1, ciudad
        FROM cliente
        ORDER BY nombre_cliente
    """
    )
    List<ClienteDTOLista> finAllDTOs();
}
