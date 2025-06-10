package org.cplcursos.ejercicioclaseviispringweb.DTOs;

public record EmpleadoDTORecord(
        int codigo_empleado,
        String nombre,
        String apellido1,
        String apellido2,
        String email,
        String codigo_oficina,
        String puesto
)
{

}


