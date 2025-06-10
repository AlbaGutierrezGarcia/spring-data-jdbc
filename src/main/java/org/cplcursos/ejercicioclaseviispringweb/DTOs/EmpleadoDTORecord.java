package org.cplcursos.ejercicioclaseviispringweb.DTOs;

public record EmpleadoDTORecord(
        int codigoEmpleado,
        String nombre,
        String apellido1,
        String apellido2,
        String email,
        String ciudadOficina,
        String puesto
)
{

}


