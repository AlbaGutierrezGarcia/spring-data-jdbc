package org.cplcursos.ejercicioclaseviispringweb.servicios;

import org.cplcursos.ejercicioclaseviispringweb.modelos.Producto;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    ProductoRepo productoRepo;
    //Mappers de dtos...

    public ProductoService(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    //CRUD
    public List<Producto> findAll() {
        return productoRepo.findAll();
    }

    public Producto findBy(Integer id)
    {
        return productoRepo.findById(id).get();
    }

    public void save(Producto p)
    {
        productoRepo.save(p);
    }

    public void delete(Integer id)
    {
        productoRepo.deleteById(id);
    }

}
