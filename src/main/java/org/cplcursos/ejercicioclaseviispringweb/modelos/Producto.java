package org.cplcursos.ejercicioclaseviispringweb.modelos;


import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {

    @Id
    private Integer codigo_producto;

    private String nombre;
    private String gama;
    private String dimensiones;
    private String proveedor;
    private String descripcion;
    private Integer cantidad_en_stock;
    private double precio_venta;
    private double precio_proveedor;
}
