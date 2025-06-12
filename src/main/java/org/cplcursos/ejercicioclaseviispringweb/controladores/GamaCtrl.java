package org.cplcursos.ejercicioclaseviispringweb.controladores;


import org.cplcursos.ejercicioclaseviispringweb.modelos.Gama;
import org.cplcursos.ejercicioclaseviispringweb.servicios.GamaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/gamas")
public class GamaCtrl {
    private final GamaService gamaService;

    public GamaCtrl(GamaService gamaService) {
        this.gamaService = gamaService;
    }

    @GetMapping({"","/"})
    public String mostrarListaGamas(Model model){
        List<Gama> listaGamas = gamaService.findAllGamas();
        List<String> cabeceras = List.of("Gama","Descripción texto","Descripción html","Imagen");

        model.addAttribute("cab",cabeceras);
        model.addAttribute("listaGamas", listaGamas);

        return "vistaGamas";

    }
    @GetMapping("form/nuevo")
    public String mostrarGamaFormulario(Model model){
        Gama gama = new Gama();
        model.addAttribute("gama",gama);
        return "formGama";
    }

    @GetMapping("form/editar/{id}")
    public String editarGama(Model model, @PathVariable String id){
        Gama gama = gamaService.findBy(id);

        String msj;
        if (gama.getPatata().isEmpty())
        {
            msj = "NO EXISTE";
        }
        else
        {
            msj = "";
        }
        model.addAttribute("gama",gama);
        model.addAttribute("msj", msj);

       return "formGama";
    }

    @PostMapping("/guardar")

    public String guardarGama(@ModelAttribute Gama gama, RedirectAttributes redirectAttributes){
        gamaService.save(gama);
        redirectAttributes.addFlashAttribute("msj", "Gama guardado exitosamente");
        return "redirect:/gamas";
    }

    @GetMapping("borrar/{id}")
    public String borrarGama(Model model, @PathVariable String id, RedirectAttributes redirectAttributes){
        Gama gama = gamaService.findBy(id);
        gamaService.delete(gama.getPatata());

        redirectAttributes.addFlashAttribute("msj", "Gama borrado exitosamente");

        return "redirect:/gamas";
    }

}




