package org.cplcursos.ejercicioclaseviispringweb.controladores;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.PedidosDTO;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Pedido;
import org.cplcursos.ejercicioclaseviispringweb.servicios.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class PedidoCtrl {

    private PedidoService pedidoService;

    public PedidoCtrl(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping({"","/"})
    public String mostrarListaPedidos(Model model)
    {
        List<PedidosDTO> listaPedidos = pedidoService.findAllPedidosDTO();
        List<String> cabeceras = List.of("Código pedido","Fecha pedido","Fecha entrega","Estado","Código cliente","Base Imponible", "IVA", "Total");

        model.addAttribute("cabeceras", cabeceras);
        model.addAttribute("pedidos", listaPedidos);

        return "vistaPedidos";
    }

}
