package com.es.segurosinseguros.repository;

import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.model.Seguro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsistenciaMedicaRepository extends JpaRepository<AsistenciaMedica, Long> {
    List<AsistenciaMedica> findBySeguro(Seguro seguro);
}