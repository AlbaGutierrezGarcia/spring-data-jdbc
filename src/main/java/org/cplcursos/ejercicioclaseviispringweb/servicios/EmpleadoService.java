package org.cplcursos.ejercicioclaseviispringweb.servicios;


import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOSinCiudad;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoFormDTO;
import org.cplcursos.ejercicioclaseviispringweb.mapeadores.EmpleadoMapper;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Empleado;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.EmpleadoRepo;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.OficinaRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepo empleadoRepo;
    EmpleadoMapper empleadoMapper;

    public EmpleadoService(EmpleadoRepo empleadoRepo, EmpleadoMapper empleadoMapper) {
        this.empleadoRepo = empleadoRepo;
        this.empleadoMapper = empleadoMapper;
    }

    public List<EmpleadoDTOLista> listarEmpleados() {
        return empleadoRepo.findAllDtos();
    }

    public List<EmpleadoDTOSinCiudad> listarEmpleadoSinCiudad() {
        return empleadoRepo.listaEmpleadosSinCiudad();
    }


    public EmpleadoFormDTO cargarEmpleado(int id) {
        Optional<Empleado> empleado = empleadoRepo.findById(id);

        if (empleado.isPresent()) {
            return empleadoMapper.toFormDTO(empleado.get());
        }

        return empleadoMapper.toDtoEmpty();
    }

    public void guardarEmpleado(Empleado empleado) throws SQLException {
        empleadoRepo.save(empleado);
    }

    public void borrarEmpleado(int id) {
        Optional<Empleado> empleado = empleadoRepo.findById(id);
        empleado.ifPresent(empleadoRepo::delete);
    }


}
