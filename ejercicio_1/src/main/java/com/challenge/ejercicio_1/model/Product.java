package com.challenge.ejercicio_1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTO")
@SequenceGenerator(
        name="product_seq",
        sequenceName = "product_seq",
        allocationSize = 1
)
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @Column(name="productoId", nullable = false)
    private Long productoId;

    @Column(name="productoNombre")
    private String productoNombre;

    @Column(name="productoDescripcion")
    private String productoDescripcion;

    @Column(name="productoCantidad")
    private Integer productoCantidad;

    @Column(name="ubicacion")
    private Integer productoUbicacion;

}
