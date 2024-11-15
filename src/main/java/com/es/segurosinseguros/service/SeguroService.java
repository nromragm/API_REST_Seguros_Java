package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BaseDeDatosException;
import com.es.segurosinseguros.model.AsistenciaMedica;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.repository.AsistenciaMedicaRepository;
import com.es.segurosinseguros.repository.SeguroRepository;
import com.es.segurosinseguros.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    @Autowired
    private AsistenciaMedicaRepository asistenciaMedicaRepository;

    public SeguroDTO getById(String id) {

        Long idL = 0L;
        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El formato del id es incorrecto");
        }

        Seguro seguro = null;
        try {
            seguro = seguroRepository.findById(idL).orElse(null);
            return Mapper.mapToDTO(seguro);

        } catch (Exception e) {
            throw new BaseDeDatosException("Error en la base de datos");
        }
    }

    public List<SeguroDTO> getAll() {
        List<Seguro> seguros = seguroRepository.findAll();

        List<SeguroDTO> seguroDTOS = new ArrayList<>();

        seguros.forEach(seguro -> seguroDTOS.add(Mapper.mapToDTO(seguro)));

        return seguroDTOS;
    }

    public SeguroDTO insert(SeguroDTO seguroDTO) {
        return Mapper.createSeguro(seguroDTO, seguroRepository);
    }

    public SeguroDTO updateById(SeguroDTO seguroDTO, String id) {
        Long idL = 0L;
        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El formato del id es incorrecto");
        }

        Seguro s = seguroRepository.findById(idL).orElse(null);

        if (s == null) return null;

        s.setApe1(seguroDTO.getApe1());
        s.setApe2(seguroDTO.getApe2());
        s.setSexo(seguroDTO.getSexo());
        s.setEdad(seguroDTO.getEdad());
        s.setNif(seguroDTO.getNif());
        s.setNumHijos(seguroDTO.getNumHijos());
        s.setCasado(seguroDTO.isCasado());
        s.setEmbarazada(seguroDTO.isEmbarazada());

        seguroRepository.save(s);

        return Mapper.mapToDTO(s);
    }

    public SeguroDTO deleteById(String id) {
        Long idL = 0L;
        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El formato del id es incorrecto");
        }

        Seguro s = seguroRepository.findById(idL).orElse(null);

        if (s == null) return null;

        List<AsistenciaMedica> asistenciaMedicas = asistenciaMedicaRepository.findBySeguro(s);
        asistenciaMedicaRepository.deleteAll(asistenciaMedicas);

        seguroRepository.delete(s);

        return Mapper.mapToDTO(s);
    }
}
