package com.challenge.ejercicio_2.util;

public enum ProductServiceInfo {

    CREATED("Producto creado: {}"),
    UPDATED("Producto con id {} editado: {}");

    public final String message;

    ProductServiceInfo(String message) {
        this.message = message;
    }

}
