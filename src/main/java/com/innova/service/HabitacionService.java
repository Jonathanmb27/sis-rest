package com.innova.service;

import com.innova.domain.Habitacion;

import java.util.List;
import java.util.Optional;

public interface HabitacionService extends AbstractService<Habitacion>{

     List<Habitacion> findAll() ;
     Optional<Habitacion> update(Habitacion entity);
}
