package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.RepVenDTO;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Cliente;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepo extends CrudRepository<Cliente, Integer> {
    Optional<Cliente> findById(Integer id);
    List<Cliente> findAll();


    @Query("""
        SELECT e.codigo_empleado, e.nombre, CONCAT(e.apellido1,' ', e.apellido2) AS apellidos
             FROM empleado e
        """)
    List<RepVenDTO> findAllDtosRepVentas();

}
