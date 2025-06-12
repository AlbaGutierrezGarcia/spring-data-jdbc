package org.cplcursos.ejercicioclaseviispringweb.DTOs;

import java.util.Date;

public record PedidosDTO(
        Integer codigo_pedido,
        Date fecha_pedido,
        Date fecha_entrega,
        String estado,
        Integer codigo_cliente,
        double base_imponible,
        double iva,
        double total
) {
}
