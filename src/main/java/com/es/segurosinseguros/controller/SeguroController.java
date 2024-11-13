package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seguros")
public class SeguroController {

    @Autowired
    private SeguroService seguroService;

    @GetMapping("/{id}")
    public ResponseEntity<SeguroDTO> getById(
            @PathVariable String id
    ) {
        //Compruebo que el id no es null (Bad R)
        /*
        mensaje: id no valido
        uri path
        BadRequestException
         */
        if (id == null || id.isBlank()  ) {
            throw new BadRequestException("id no valido");
        }

        return null;
    }
}
