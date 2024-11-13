package com.es.segurosinseguros.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "asistencias_medicas")
public class AsistenciaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia_medica")
    private Long idAsistenciaMedica;
    @ManyToOne
    @JoinColumn(name = "id_seguro")
    private Seguro seguro;
    @Column(name = "breve_descripcion")
    private String breveDescripcion;
    private String lugar;
    private String explicacion;
    @Column(name = "tipo_asistencia")
    private String tipoAsistencia;
    private LocalDate fecha;
    private LocalTime hora;
    private double importe;

    public AsistenciaMedica(Long idAsistenciaMedica, Seguro seguro, String breveDescripcion, String lugar, String explicacion, String tipoAsistencia, LocalDate fecha, LocalTime hora, double importe) {
        this.idAsistenciaMedica = idAsistenciaMedica;
        this.seguro = seguro;
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
        this.explicacion = explicacion;
        this.tipoAsistencia = tipoAsistencia;
        this.fecha = fecha;
        this.hora = hora;
        this.importe = importe;
    }

    public AsistenciaMedica() {}


}
