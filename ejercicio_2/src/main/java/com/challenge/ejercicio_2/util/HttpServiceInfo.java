package com.challenge.ejercicio_2.util;

public enum HttpServiceInfo {

    ERROR_GET_REQUEST("Error al obtener objecto de tipo {} con body {} y URI {} : {}"),
    ERROR_POST_REQUEST("Error al crear objecto de tipo {} con body {} y URI {} : {}"),
    ERROR_PUT_REQUEST("Error al actualizar objecto de tipo {} con body {} y URI {} : {}"),
    ERROR_DELETE_REQUEST("Error al eliminar elemento con id {} : {}");

    public final String message;

    HttpServiceInfo(String message) {
        this.message = message;
    }

}
