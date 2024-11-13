package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.repository.SeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeguroService {

    @Autowired
    private SeguroRepository seguroRepository;

    public SeguroDTO getById(String id) {

        Long idL = 0L;
        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("El formato del id es incorrecto");
        }


    }
}
