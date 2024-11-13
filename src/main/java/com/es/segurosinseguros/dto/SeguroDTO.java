package com.es.segurosinseguros.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeguroDTO {

    private String nif;
    private String nombre;
    private String ape1;
    private String ape2;
    private int edad;
    private int numHijos;
    private String sexo;
    private boolean casado;
    private boolean embarazada;

    public SeguroDTO() {}
}