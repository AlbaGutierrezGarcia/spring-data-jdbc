package org.cplcursos.ejercicioclaseviispringweb.servicios;

import org.cplcursos.ejercicioclaseviispringweb.modelos.Pedido;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.PedidoRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepo pedidoRepo;
    //PedidoMapper pedidoMapper;

    public PedidoService(PedidoRepo pedidoRepo) {
        this.pedidoRepo = pedidoRepo;
    }

    public Pedido findPedidobyId(Integer codigo_pedido) {
        Optional<Pedido> pedido = pedidoRepo.findById(codigo_pedido);
        return pedido.get();
    }

    public List<Pedido> findAllPedidos() {
        return pedidoRepo.findAll();
    }

    public void save(Pedido pedido) {
        pedidoRepo.save(pedido);
    }

    public void delete(Integer codigo_pedido) {
        pedidoRepo.deleteById(codigo_pedido);
    }

}
