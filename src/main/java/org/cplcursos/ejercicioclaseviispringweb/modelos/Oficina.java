package org.cplcursos.ejercicioclaseviispringweb.modelos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Oficina {
    @Id
    private String codigoOficina;

    private String ciudad;
    private String pais;
    private String region;
    private String codigoPostal;
    private String telefono;
    private String lineaDireccion1;
    private String lineaDireccion2;

    public String toString(){
        return "Oficina [" + codigoOficina + ", " + ciudad + ", " + pais + ", " + region + ", " +
                codigoPostal + ", " + telefono + ", " + lineaDireccion1 + ", " + lineaDireccion2 + "]";
    }
}
