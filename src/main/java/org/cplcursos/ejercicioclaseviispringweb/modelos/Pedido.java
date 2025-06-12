package org.cplcursos.ejercicioclaseviispringweb.modelos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table("pedido")
public class Pedido {
    @Id
    private Integer codigoPedido;
    private LocalDate fechaPedido;
    private String estado;
    private Integer codigoCliente;
    // Otros campos...
}
