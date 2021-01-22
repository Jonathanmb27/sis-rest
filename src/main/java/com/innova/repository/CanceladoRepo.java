package com.innova.repository;

import com.innova.domain.Cancelado;

import java.util.List;

public interface CanceladoRepo extends AbstractRepo<Cancelado>{


    List<Cancelado> findAll();
}
