package org.cplcursos.ejercicioclaseviispringweb.modelos;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("gama_producto")
public class Gama {
    @Id
    @Column("gama")
    private String patata;

    private String descripcion_texto;
    private String descripcion_html;
    private String imagen;
}
