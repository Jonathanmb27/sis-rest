package com.innova.service;

import com.innova.domain.Cancelado;

import java.util.List;

public interface CanceladoService extends AbstractService<Cancelado>{

    List<Cancelado> findAll();
}
