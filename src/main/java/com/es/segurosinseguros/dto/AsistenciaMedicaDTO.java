package com.es.segurosinseguros.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AsistenciaMedicaDTO {
    private String breveDescripcion;
    private String lugar;
    private String explicacion;
    private String tipoAsistencia;
    private LocalDate fecha;
    private LocalTime hora;
    private double importe;

    public AsistenciaMedicaDTO() {}
}
