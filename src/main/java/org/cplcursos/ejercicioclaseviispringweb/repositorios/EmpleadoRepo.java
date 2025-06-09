package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTORecord;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOSinCiudad;
import org.cplcursos.ejercicioclaseviispringweb.mapeadores.EmpleadoMapper;
import org.cplcursos.ejercicioclaseviispringweb.mapeadores.EmpleadoRecordMapper;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Empleado;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepo extends CrudRepository<Empleado, Integer>{

    @Query("""
            SELECT e.codigo_empleado, e.nombre, e.apellido1, e.apellido2,
                   e.email, e.puesto, o.ciudad as ciudad_oficina
            FROM empleado e
            INNER JOIN oficina o ON e.codigo_oficina = o.codigo_oficina
            ORDER BY o.ciudad, e.apellido1, e.nombre
            """)
    List<EmpleadoRecordMapper> findAllDtos();  // <-- ejecuta un "SELECT * FROM empleado"

    @Query("""
            SELECT e.codigo_empleado, e.nombre, CONCAT(e.apellido1, ' ', e.apellido2) AS apellidos,
                   e.email, e.puesto
            FROM empleado e
            ORDER BY e.apellido1, e.nombre
            """)
    List<EmpleadoDTOSinCiudad> listaEmpleadosSinCiudad();


    List<Empleado> findAll();


    Empleado findById(int id);

}
