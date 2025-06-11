package org.cplcursos.ejercicioclaseviispringweb.modelos;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {
    @Id
    private Integer codigo_cliente;

    private String nombre_cliente;
    private String nombre_contacto;
    private String apellido_contacto;
    private String telefono;
    private String fax;
    private String linea_direccion1;
    private String linea_direccion2;
    private String ciudad;
    private String region;
    private String pais;
    private String codigo_postal;
    private Integer codigo_empleado_rep_ventas;
    private double limite_credito;

}
