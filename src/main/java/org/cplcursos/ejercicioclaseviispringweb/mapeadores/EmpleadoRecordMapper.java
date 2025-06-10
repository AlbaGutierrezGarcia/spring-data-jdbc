package org.cplcursos.ejercicioclaseviispringweb.mapeadores;


import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTORecord;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Empleado;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmpleadoRecordMapper {


    public EmpleadoDTORecord toDTORecord(ResultSet rs, int rowNumber) throws SQLException {
        EmpleadoDTORecord empleadoDTORecord = new EmpleadoDTORecord(
                rs.getInt("codigoEmpleado"),
                rs.getString("nombre"),
                rs.getString("apellido1"),
                rs.getString("apellido2"),
                rs.getString("email"),
                rs.getString("ciudadOficina"),
                rs.getString("puesto")
        );

        return  empleadoDTORecord;
    }


}
