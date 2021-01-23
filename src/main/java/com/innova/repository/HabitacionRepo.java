package com.innova.repository;

import com.innova.domain.Habitacion;

import java.util.List;
import java.util.Optional;

public interface HabitacionRepo extends AbstractRepo<Habitacion>{


    List<Habitacion> findAll();
    Optional<Habitacion> update(Habitacion entity);
}
