package org.cplcursos.ejercicioclaseviispringweb.servicios;

import org.cplcursos.ejercicioclaseviispringweb.modelos.Oficina;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.OficinaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OficinaService {

    private final OficinaRepo oficinaRepo;

    public OficinaService(OficinaRepo oficinaRepo) {
        this.oficinaRepo = oficinaRepo;
    }


    public List<Oficina> findAllOficinas() {
        return oficinaRepo.findAll();
    }

    public Oficina findOficinaById(String id) {
        return oficinaRepo.findByCodigoOficina(id);
    }

    //??
    public void saveOficina(Oficina oficina) {
        oficinaRepo.save(oficina);
    }


    public Oficina findOficinaByCiudad(String ciudad) {
        return oficinaRepo.findByCiudad(ciudad);
    }

}
