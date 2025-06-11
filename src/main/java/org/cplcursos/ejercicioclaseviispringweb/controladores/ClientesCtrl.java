package org.cplcursos.ejercicioclaseviispringweb.controladores;


import org.cplcursos.ejercicioclaseviispringweb.DTOs.ClienteDTO;
import org.cplcursos.ejercicioclaseviispringweb.servicios.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesCtrl {

    private final ClienteService clienteService;

    public ClientesCtrl(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping({"", "/"})
    public String mostrarListaClientes(Model model) {
        List<ClienteDTO> listaClientes = clienteService.findAllClientes();
        List<String> cabeceras = List.of("Codigo","Nombre cliente","Nombre contacto","Telefono","Linea Direccion",
                "Ciudad", "Codigo Representante Ventas", "Limite credito");

        model.addAttribute("cab",cabeceras);
        model.addAttribute("clientes", listaClientes);


        return "vistaClientes";
    }






}
