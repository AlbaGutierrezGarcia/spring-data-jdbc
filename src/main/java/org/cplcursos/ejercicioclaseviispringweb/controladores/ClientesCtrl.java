package org.cplcursos.ejercicioclaseviispringweb.controladores;


import org.cplcursos.ejercicioclaseviispringweb.DTOs.ClienteDTO;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.RepVenDTO;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Cliente;
import org.cplcursos.ejercicioclaseviispringweb.servicios.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesCtrl {

    private final ClienteService clienteService;

    public String test;
    public String test2;
    public String test3;

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
        model.addAttribute("urlForm", "clientes/form/editar/");


        return "vistaClientes";
    }

    @GetMapping("/form/nuevo")
    public String mostrarClienteById(Model model) {
        Cliente cliente = new Cliente();

        List<RepVenDTO> listaRepresentantes = clienteService.findClienteRepVenDTO();

        model.addAttribute("cliente", cliente);
        model.addAttribute("listaRepresentantes", listaRepresentantes);
        model.addAttribute("editar", false);
        return "formClientes";
    }

    @GetMapping("/form/editar/{id}")
    public String editarCliente(Model model, @PathVariable Integer id) {
        ClienteDTO clienteDTO1 = clienteService.findClienteById(id);

        String msj;
        if (clienteDTO1.codigo_cliente() == 0)
        {
            msj = "NO EXISTE";
        }
        else
        {
            msj = "";
        }

        List<RepVenDTO> listaRepresentantes = clienteService.findClienteRepVenDTO();

        model.addAttribute("cliente", clienteDTO1);
        model.addAttribute("listaRepresentantes", listaRepresentantes);
        model.addAttribute("editar", true);
        model.addAttribute("msj", msj);

        return "formClientes";
    }

    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttributes) throws SQLException {
        clienteService.save(cliente);
        System.out.println(cliente.getCiudad());
        System.out.println(cliente.getCodigo_empleado_rep_ventas());
        redirectAttributes.addFlashAttribute("msj", "Cliente guardado con éxito :) ");
        return "redirect:/clientes";
    }


    @GetMapping("/borrar/{id}")
    public String borrarCliente(@PathVariable Integer id, RedirectAttributes redirectAttributes) throws SQLException {
        ClienteDTO clienteDTO = clienteService.findClienteById(id);
        clienteService.delete(clienteDTO.codigo_cliente());

        redirectAttributes.addFlashAttribute("msj", "Cliente borrado con éxito :) ");

        return "redirect:/clientes";
    }


}
