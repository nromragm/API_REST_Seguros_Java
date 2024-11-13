package com.es.segurosinseguros.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@Entity
@Table(name = "seguros")
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguro")
    private Long idSeguro;
    private String nif;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String ape1;
    private String ape2;
    private int edad;
    @Column(name = "num_hijos")
    private int numHijos;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(nullable = false)
    private String sexo;
    private boolean casado;
    private boolean embarazada;
}
