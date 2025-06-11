package org.cplcursos.ejercicioclaseviispringweb.mapeadores;

import org.cplcursos.ejercicioclaseviispringweb.DTOs.ClienteDTO;
import org.cplcursos.ejercicioclaseviispringweb.modelos.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteDTO toDTO(Cliente cliente){
        return new ClienteDTO(
                cliente.getCodigo_cliente(),
                cliente.getNombre_cliente(),
                cliente.getNombre_contacto(),
                cliente.getTelefono(),
                cliente.getLinea_direccion1(),
                cliente.getCiudad(),
                cliente.getCodigo_empleado_rep_ventas(),
                cliente.getLimite_credito()
        );

    }

    public Cliente clienteToDTO(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();

        cliente.setCodigo_cliente(clienteDTO.codigo_cliente());
        cliente.setNombre_cliente(clienteDTO.nombre_cliente());
        cliente.setNombre_contacto(clienteDTO.nombre_contacto());
        cliente.setTelefono(clienteDTO.telefono());
        cliente.setLinea_direccion1(clienteDTO.linea_direccion1());
        cliente.setCiudad(clienteDTO.ciudad());
        cliente.setCodigo_empleado_rep_ventas(clienteDTO.codigo_empleado_rep_ventas());
        cliente.setLimite_credito(clienteDTO.limite_credito());

        return cliente;
    }


    public ClienteDTO emptyDTO() {
        return new ClienteDTO(0,"","","","","",0,0.0);
    }
}
