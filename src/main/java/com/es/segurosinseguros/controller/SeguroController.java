package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.exception.BaseDeDatosException;
import com.es.segurosinseguros.exception.ErrorMessageForClient;
import com.es.segurosinseguros.exception.NotFoundException;
import com.es.segurosinseguros.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SeguroController {

    @Autowired
    private SeguroService seguroService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(
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
        } else {
            SeguroDTO seguroDTO = seguroService.getById(id);
            if (seguroDTO == null) {
                throw  new NotFoundException("Seguro no encontrado");
            } else {
                return new ResponseEntity<>(seguroDTO, HttpStatus.FOUND);
            }
        }
    }


    @PostMapping("/")
    public ResponseEntity<?> insert(
            @RequestBody SeguroDTO seguroDTO
    ) {

        if (seguroDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        SeguroDTO nuevoSeguro = seguroService.insert(seguroDTO);

        if (nuevoSeguro == null){
            return new ResponseEntity<>(
                    new ErrorMessageForClient(
                            "Error al insertar el seguro", "localhost:8080/seguros/"
                    ), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(nuevoSeguro, HttpStatus.CREATED);
        }
    }


    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        List<SeguroDTO> seguroDTOS = seguroService.getAll();

        if (seguroDTOS == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(seguroDTOS, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(
            @PathVariable String id
    ) {
        if (id == null || id.isBlank()  ) {
            throw new BadRequestException("id no valido");
        } else {
            SeguroDTO seguroDTO = seguroService.deleteById(id);

            if (seguroDTO == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(seguroDTO, HttpStatus.OK);
        }
    }
}