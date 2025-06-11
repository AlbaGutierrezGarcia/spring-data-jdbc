package org.cplcursos.ejercicioclaseviispringweb.DTOs;

public record ClienteDTO(
        Integer codigo_cliente,
        String nombre_cliente,
        String nombre_contacto,
        String telefono,
        String linea_direccion1,
        String ciudad,
        Integer codigo_empleado_rep_ventas,
        double limite_credito
) {

}
