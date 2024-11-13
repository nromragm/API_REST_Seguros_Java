package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.repository.SeguroRepository;

import java.time.LocalDate;
import java.util.Date;

public class Mapper {
    public static SeguroDTO mapToDTO(Seguro seguro) {
        SeguroDTO seguroDTO = new SeguroDTO();
        seguroDTO.setApe1(seguro.getApe1());
        seguroDTO.setApe2(seguro.getApe2());
        seguroDTO.setCasado(seguro.isCasado());
        seguroDTO.setNif(seguro.getNif());
        seguroDTO.setEdad(seguro.getEdad());
        seguroDTO.setEmbarazada(seguro.isEmbarazada());
        seguroDTO.setNombre(seguro.getNombre());
        seguroDTO.setSexo(seguro.getSexo());
        seguroDTO.setNumHijos(seguro.getNumHijos());

        return seguroDTO;
    }

    public static SeguroDTO createSeguro(SeguroDTO seguroDTO, SeguroRepository seguroRepository) {
        Date fecha = new Date();
        Seguro seguro = new Seguro();
        seguro.setEdad(seguroDTO.getEdad());
        seguro.setEmbarazada(seguroDTO.isEmbarazada());
        seguro.setCasado(seguroDTO.isCasado());
        seguro.setApe1(seguroDTO.getApe1());
        seguro.setApe2(seguroDTO.getApe2());
        seguro.setNif(seguroDTO.getNif());
        seguro.setSexo(seguroDTO.getSexo());
        seguro.setNombre(seguroDTO.getNombre());
        seguro.setNumHijos(seguroDTO.getNumHijos());
        seguro.setFechaCreacion(fecha);

        seguroRepository.save(seguro);

        return Mapper.mapToDTO(seguro);
    }
}
