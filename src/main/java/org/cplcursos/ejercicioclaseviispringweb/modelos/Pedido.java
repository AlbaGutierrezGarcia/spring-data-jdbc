package org.cplcursos.ejercicioclaseviispringweb.modelos;


import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pedido {
    @Id
    private Integer codigo_pedido;

    private Date fecha_pedido;
    private Date fecha_esperada;
    private Date fecha_entregada;
    private String estado;
    private String comentarios;
    private Integer codigo_cliente;


}
