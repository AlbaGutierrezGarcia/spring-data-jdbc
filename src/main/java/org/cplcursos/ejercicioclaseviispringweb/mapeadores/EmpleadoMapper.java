package org.cplcursos.ejercicioclaseviispringweb.mapeadores;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoFormDTO;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Empleado;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class EmpleadoMapper {

    public EmpleadoDTOLista toDTO(ResultSet rs, int rowNum) throws SQLException {
        EmpleadoDTOLista empleDTO = new EmpleadoDTOLista();
        empleDTO.setCodigoEmpleado(rs.getInt("codigo_empleado"));
        empleDTO.setNombre(rs.getString("nombre"));
        empleDTO.setApellido1(rs.getString("apellido1"));
        empleDTO.setApellido2(rs.getString("apellido2"));
        empleDTO.setEmail(rs.getString("email"));
        empleDTO.setPuesto(rs.getString("puesto"));
        // necesitamos obtener la ciudad de su oficina
        empleDTO.setCiudadOficina(rs.getString("ciudad_oficina"));
        return empleDTO;
    }


    public EmpleadoFormDTO toFormDTO(Empleado empleado) {
        return new EmpleadoFormDTO(
                empleado.getCodigoEmpleado(),
                empleado.getNombre(),
                empleado.getApellido1(),
                empleado.getApellido2(),
                empleado.getExtension(),
                empleado.getEmail(),
                empleado.getCodigoOficina(),
                empleado.getCodigoJefe(),
                empleado.getPuesto()
        );
    }

    public Empleado toEmpleado(EmpleadoFormDTO empleadoFormDTO) throws SQLException {
        Empleado empleado = new Empleado();
        empleado.setCodigoEmpleado(empleadoFormDTO.codigoEmpleado());
        empleado.setNombre(empleadoFormDTO.nombre());
        empleado.setApellido1(empleadoFormDTO.apellido1());
        empleado.setApellido2(empleadoFormDTO.apellido2());
        empleado.setExtension(empleadoFormDTO.extension());
        empleado.setEmail(empleadoFormDTO.email());
        empleado.setCodigoOficina(empleadoFormDTO.codigoOficina());
        empleado.setCodigoJefe(empleadoFormDTO.codigoJefe());
        empleado.setPuesto(empleadoFormDTO.puesto());
        return empleado;
    }

    public EmpleadoFormDTO toDtoEmpty()
    {
        return new EmpleadoFormDTO(0,"","","","","","",0,"");
    }

}
