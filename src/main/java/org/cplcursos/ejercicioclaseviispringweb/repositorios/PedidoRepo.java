package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.PedidosDTO;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Pedido;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepo extends CrudRepository <Pedido, Integer>{

    Optional<Pedido> findById(Integer codigo_pedido);
    List<Pedido> findAll();

    @Query("""
SELECT p.codigo_pedido, p.fecha_pedido, p.fecha_entrega, p.estado, p.codigo_cliente,
           SUM(dp.cantidad * pr.precio_venta) AS base_imponible,
           SUM(dp.cantidad * pr.precio_venta) * 0.21 AS iva,
           SUM(dp.cantidad * pr.precio_venta) * 1.21 AS total
FROM pedido p
            JOIN
    detalle_pedido dp ON p.codigo_pedido = dp.codigo_pedido
            JOIN
    producto pr ON dp.codigo_producto = pr.codigo_producto
            GROUP BY
    p.codigo_pedido;
""")
    List<PedidosDTO> findAllPedidosDTOS();

}
