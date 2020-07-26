package com.challenge.ejercicio_2.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ProductDTO implements Serializable {

    private Long productoId;
    private String productoNombre;
    private String productoDescripcion;
    private Integer productoCantidad;
    private Integer productoUbicacion;

}
