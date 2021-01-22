package com.innova.controller;

import com.innova.domain.Cancelado;
import com.innova.repository.CanceladoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cancelados")
public class CanceladoController {

    private CanceladoRepo canceladoRepo;

    public CanceladoController(CanceladoRepo canceladoRepo){
        this.canceladoRepo=canceladoRepo;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cancelado> findAll(){
        List<Cancelado> canceladoList=canceladoRepo.findAll();
        return canceladoList;
    }
}
