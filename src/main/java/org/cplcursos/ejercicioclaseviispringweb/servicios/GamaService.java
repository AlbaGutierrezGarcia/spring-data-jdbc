package org.cplcursos.ejercicioclaseviispringweb.servicios;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.PedidosDTO;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Gama;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.GamaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamaService {

    GamaRepo gamaRepo;
    //Mappers de dtos...

    public GamaService(GamaRepo gamaRepo) {
        this.gamaRepo = gamaRepo;
    }

    //CRUD
    public List<Gama> findAllGamas() {
        return gamaRepo.findAll();
    }

    public Gama findBy(String id)
    {
        return gamaRepo.findById(id).get();
    }

    public void save(Gama p)
    {
        gamaRepo.save(p);
    }

    public void delete(String id)
    {
        gamaRepo.deleteById(id);
    }

}
