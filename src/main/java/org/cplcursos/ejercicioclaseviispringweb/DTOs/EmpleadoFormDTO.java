package org.cplcursos.ejercicioclaseviispringweb.DTOs;

public record EmpleadoFormDTO(
         Integer codigoEmpleado,
         String nombre,
         String apellido1,
         String apellido2,
         String extension,
         String email,
         String codigoOficina,
         Integer codigoJefe,// Puede ser null
        String puesto
) {
}
