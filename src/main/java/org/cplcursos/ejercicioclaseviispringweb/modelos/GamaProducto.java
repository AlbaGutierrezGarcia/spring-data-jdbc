package org.cplcursos.ejercicioclaseviispringweb.modelos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table("gama_producto")
public class GamaProducto {
    @Id
    private String gama;
    private String descripcionTexto;
    // Otros campos...
}

