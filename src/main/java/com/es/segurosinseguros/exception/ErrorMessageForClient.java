package com.es.segurosinseguros.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessageForClient {

    private String mensaje;
    private String uri;

    public ErrorMessageForClient(String mensaje, String uri) {
        this.mensaje = mensaje;
        this.uri = uri;
    }


}
