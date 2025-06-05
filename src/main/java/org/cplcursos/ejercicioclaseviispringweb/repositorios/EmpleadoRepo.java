package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOSinCiudad;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Empleado;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepo extends CrudRepository<Empleado, Integer>{
    List<Empleado> findAll();

    @Query("""
            SELECT e.codigo_empleado, e.nombre, CONCAT(e.apellido1, ' ', e.apellido2) AS apellidos,
                   e.email, e.puesto
            FROM empleado e
            ORDER BY e.apellido1, e.nombre
            """)
    List<EmpleadoDTOSinCiudad> listaEmpleados();

}
