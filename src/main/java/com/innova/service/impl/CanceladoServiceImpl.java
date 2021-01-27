package com.innova.service.impl;

import com.innova.domain.Cancelado;

import com.innova.repository.CanceladoRepo;
import com.innova.service.CanceladoService;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class CanceladoServiceImpl extends AbstractServiceImpl<Cancelado> implements CanceladoService {

    private CanceladoRepo canceladoRepo;
    public CanceladoServiceImpl(CanceladoRepo canceladoRepo){
        this.canceladoRepo=canceladoRepo;
    }

    @Transactional
    public List<Cancelado> findAll() {
        return canceladoRepo.findAll();
    }
}
