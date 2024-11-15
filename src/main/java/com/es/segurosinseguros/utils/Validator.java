package com.es.segurosinseguros.utils;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.Seguro;

public class Validator {
    public static boolean validarSeguro(SeguroDTO seguroDTO) {
        if (
                seguroDTO.getApe1().isBlank()
                || seguroDTO.getApe2().isBlank()
                || seguroDTO.getEdad() < 18
                || seguroDTO.getNif()
        )
    }

    public boolean validarNif(String nif) {

    }
}
