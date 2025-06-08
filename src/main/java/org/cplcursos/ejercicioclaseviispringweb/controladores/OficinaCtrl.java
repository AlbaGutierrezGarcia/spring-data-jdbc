package org.cplcursos.ejercicioclaseviispringweb.controladores;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.OficinaDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Oficina;
import org.cplcursos.ejercicioclaseviispringweb.servicios.EmpleadoService;
import org.cplcursos.ejercicioclaseviispringweb.servicios.OficinaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@Controller
@RequestMapping("/oficinas")
public class OficinaCtrl {


    private final OficinaService oficinaService;

    public OficinaCtrl(OficinaService oficinaService) {
        this.oficinaService = oficinaService;
    }

    @GetMapping({"", "/"})
    public String mostrarListaOficinas(Model modelo) {
        List<Oficina> listaOficinas = oficinaService.findAllOficinas();
        List<String> cabeceras = List.of("Código", "Ciudad", "Dirección 1", "Dirección 2", "Teléfono");
        // Procesamos la lista de empleados para rellenar el Map
        // Convertimos cada EmpleadoDTO... de la lista a un Map<> Siendo la clave el nombre de la propiedad
        // (tipo String) y su valor el valor de dicha propiedad para el EmpleadoDTO... tratado; como no sabemos la clase
        // de esa propiedad, utilizamos un objeto genérico de la clase Object
        List<Map<String, Object>> filas = listaOficinas.stream()
                        .map(e -> {
                            Map<String, Object> fila = new LinkedHashMap<>();
                            fila.put("codigo_oficina", e.getCodigoOficina());
                            fila.put("ciudad", e.getCiudad());
                            fila.put("lineaDireccion1", e.getLineaDireccion1());
                            fila.put("lineaDireccion2", e.getLineaDireccion2());
                            fila.put("telefono", e.getTelefono());
                            return fila;
                        }).toList();

        modelo.addAttribute("cabeceras", cabeceras);
        modelo.addAttribute("filas", filas);

        return "vistaLista";
    }

    //Esto busca una oficina a traves de la {id} que vamos a pasar a traves de la url
    //esto lo usaremos para poder editar oficinas con el put mas adelante
    @GetMapping("/editar/{id}")
    public String editarOficina(Model model, @PathVariable String id) {
        model.addAttribute("oficina", oficinaService.findOficinaById(id));
        return "formOfi";
    }

    @GetMapping("/ver/{id}")
    public String verCiudadOficina(Model model, @PathVariable String id) {
        model.addAttribute("oficinaCiudad", oficinaService.findOficinaByCiudad(id));
        System.out.println("Ciudad encontrada: " + oficinaService.findOficinaByCiudad(id).getCodigoOficina());
        return "ciudadOficina";
    }

    @GetMapping("/form")
    public String mostrarFormularioOficina(Model model) {
        model.addAttribute("oficina", new Oficina());
        return "formOfi"; // o como se llame tu vista .html
    }

    @PostMapping("/guardar")
    public String guardarOficina(@ModelAttribute Oficina oficina) throws SQLException {
        oficinaService.saveOficina(oficina);
        return "vistaLista"; // Redirige a la lista o donde prefieras
    }

}
