package org.cplcursos.ejercicioclaseviispringweb.servicios;


import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOSinCiudad;
import org.cplcursos.ejercicioclaseviispringweb.mapeadores.EmpleadoRecordMapper;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Empleado;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.EmpleadoRepo;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.OficinaRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepo empleadoRepo;

    public EmpleadoService(EmpleadoRepo empleadoRepo) {
        this.empleadoRepo = empleadoRepo;
    }

    public List<EmpleadoRecordMapper> listarEmpleados() {
        return empleadoRepo.findAllDtos();
    }

    public List<EmpleadoDTOSinCiudad> listarEmpleadoSinCiudad() {
        return empleadoRepo.listaEmpleadosSinCiudad();
    }


    public Empleado cargarEmpleado(int id) {
        return empleadoRepo.findById(id);
    }

    public void guardarEmpleado(Empleado empleado) throws SQLException {
        empleadoRepo.save(empleado);
    }


}
