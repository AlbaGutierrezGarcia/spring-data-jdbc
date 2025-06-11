package org.cplcursos.ejercicioclaseviispringweb.repositorios;

import org.cplcursos.ejercicioclaseviispringweb.modelos.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepo extends CrudRepository <Pedido, Integer>{

    Optional<Pedido> findById(Integer codigo_pedido);
    List<Pedido> findAll();

}
