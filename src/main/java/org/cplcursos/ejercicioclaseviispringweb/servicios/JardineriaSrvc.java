package org.cplcursos.ejercicioclaseviispringweb.servicios;


import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.EmpleadoDTOSinCiudad;
import org.cplcursos.ejercicioclaseviispringweb.DTOs.OficinaDTOLista;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Empleado;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.EmpleadoRepo;
import org.cplcursos.ejercicioclaseviispringweb.repositorios.OficinaRepo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JardineriaSrvc {

    private final OficinaRepo oficinaRepo;
    private final EmpleadoRepo empleadoRepo;

    public JardineriaSrvc(OficinaRepo oficinaRepo, EmpleadoRepo empleadoRepo) {
        this.oficinaRepo = oficinaRepo;
        this.empleadoRepo = empleadoRepo;
    }

    public List<EmpleadoDTOLista> listarEmpleados() {
        return empleadoRepo.findAllDtos();
    }

    public List<EmpleadoDTOSinCiudad> listarEmpleadoSinCiudad() {
        return empleadoRepo.listaEmpleadosSinCiudad();
    }

    public List<OficinaDTOLista> listarOficinas() {
        return oficinaRepo.listaOficinas();
    }

    /*public List<VentasEmpleadoDTO> listarVentasEmpleados() {
        return empleadoRepo.findAllVentas();
    }*/

    public List<EmpleadoDTOLista> listarTodos() {
        /*
                    OJO Este código está a modo de ejemplo. NO UTILIZAR

            Esta forma de generar la lista de DTOs es muy ineficiente. es lo que conocemos como "efecto N+1"
            (N+1 issue) cuando accedemos a la BD.

            Hay varias formas de solucionarlo, pero la más eficiente es usar proyecciones, tal como hacemos en el
            método "findAllDTOs" del repositorio de Empleado.

            Otra forma sería crear una vista en la BD y ejecutar esa vista
         */
        List<Empleado> empleadosLista = empleadoRepo.findAll();
        // para transformar cada empleado en su DTO, debo hacer una consulta para obtener la ciudad de su oficina
        List<EmpleadoDTOLista> empleadosDTOLista = new ArrayList<>();

        for (Empleado empleado : empleadosLista) {
            // realizo la consulta para obtener la ciudad de la oficina
            String ciudad = oficinaRepo.ciudadOficina(empleado.getCodigoOficina());
            // mapeo los datos al DTO

        }

        return null;
    }

    public Empleado cargarEmpleado(int id) {
        return empleadoRepo.findById(id);
    }

    public void guardarEmpleado(Empleado empleado) throws SQLException {
        empleadoRepo.save(empleado);
    }
}
