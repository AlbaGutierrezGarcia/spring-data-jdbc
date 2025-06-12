package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.PedidoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Pedido;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PedidoRepo extends CrudRepository<Pedido, Integer> {
    @Query("""
        SELECT p.codigo_pedido, p.fecha_pedido, p.estado, c.nombre_cliente
        FROM pedido p
        JOIN cliente c ON p.codigo_cliente = c.codigo_cliente
    """)
    List<PedidoDTOLista> findAllDTOs();
}
