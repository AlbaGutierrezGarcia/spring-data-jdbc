package org.cplcursos.ejercicioclaseviispringweb.modelos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table("cliente")
public class Cliente {
    @Id
    private Integer codigoCliente;
    private String nombreCliente;
    private String telefono;
    private String lineaDireccion1;
    private String ciudad;
    // Otros campos que no se usarán en la lista...
}
