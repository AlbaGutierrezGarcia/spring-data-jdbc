package org.cplcursos.ejercicioclaseviispringweb.controladores;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOSinCiudad;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Empleado;
import org.cplcursos.ejercicioclaseviispringweb.servicios.EmpleadoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/empleados")
public class EmpleadoCtrl {

    private final EmpleadoService empleadoService;

    public EmpleadoCtrl(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping({"", "/"})
    public String mostrarEmpleadosPorOficina(Model modelo) {
        List<EmpleadoDTOLista> listaEmpleados = empleadoService.listarEmpleados();
        // Procesamos la lista de empleados para rellenar el Map
        // Convertimos cada EmpleadoDTO... de la lista a un Map<> Siendo la clave el nombre de la propiedad
        // (tipo String) y su valor el valor de dicha propiedad para el EmpleadoDTO... tratado; como no sabemos la clase
        // de esa propiedad, utilizamos un objeto genérico de la clase Object
        List<Map<String, Object>> filas = listaEmpleados.stream()
                .map(e -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("codigo_empleado", e.getCodigoEmpleado());
                    map.put("nombre", e.getNombre());
                    map.put("apellido1", e.getApellido1());
                    map.put("apellido2", e.getApellido2());
                    map.put("email", e.getEmail());
                    map.put("ciudadOficina", e.getCiudadOficina());
                    map.put("puesto", e.getPuesto());
                    return map;
                }).toList();

        List<String> cabeceras = List.of("Código", "Nombre", "Apellidos", "Correo", "Ciudad", "Puesto");

        modelo.addAttribute("cabeceras", cabeceras);
        modelo.addAttribute("filas", filas);

        return "vistaLista";
    }

    @GetMapping("/nociudad")
    public String listarEmpleadosSinCiudad(Model modelo){
        List<EmpleadoDTOSinCiudad> listaEmpleados = empleadoService.listarEmpleadoSinCiudad();
        List<Map<String, Object>> filas = listaEmpleados.stream()
                .map(e -> {
                    Map<String, Object> map = new LinkedHashMap<>();
                    map.put("codigo_empleado", e.codigoEmpleado());
                    map.put("nombre", e.nombre());
                    map.put("apellidos", e.apellidos());
                    map.put("email", e.email());
                    map.put("puesto", e.puesto());
                    return map;
                }).toList();

        List<String> cabeceras = List.of("Código", "Nombre", "Apellidos", "Correo", "Puesto");
        modelo.addAttribute("cabeceras", cabeceras);
        modelo.addAttribute("filas", filas);
        return "vistaLista";
    }

    @GetMapping("/form")
    public String mostrarFormulario(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "form"; // Ej. "formularioEmpleado"
    }

    //Esto nos muestra un empleado completando el formulario
    @GetMapping("/form/nuevo")
    public String cargarEmpleado(Model model) {
        Empleado empleado = empleadoService.cargarEmpleado(7);
        model.addAttribute("empleado", empleado);
        return "form";
    }

    //Lo que tenemos entre corchete será un valor que recogeremos a traves de la barra url
    @GetMapping("/editar/{id}")
    public String editarEmpleado(Model model, @PathVariable int id) {
        model.addAttribute("empleado", empleadoService.cargarEmpleado(id));
        return "form";
    }


    //Spring guarda automáticamente los campos que le llegan y asigna a la entidad que le pasemos que en este caso seria Empleados
    @PostMapping("/guardar")
    public String guardarEmpleado(@ModelAttribute Empleado empleado) throws SQLException {
        // Aquí llamas a tu servicio para guardar el empleado
        empleadoService.guardarEmpleado(empleado);

        return "redirect:/empleados"; // o donde quieras redirigir
    }


    private void imprimirEmpleado(EmpleadoDTOLista empleado) {
        System.out.printf("  - %s %s %s (%s) - %s%n",
                empleado.getNombre(),
                empleado.getApellido1(),
                empleado.getApellido2() != null ? empleado.getApellido2() : "",
                empleado.getPuesto(),
                empleado.getEmail());
    }

}
