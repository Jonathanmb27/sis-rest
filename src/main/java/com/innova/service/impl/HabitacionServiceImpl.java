package com.innova.service.impl;

import com.innova.domain.Habitacion;
import com.innova.repository.HabitacionRepo;
import com.innova.service.HabitacionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HabitacionServiceImpl extends AbstractServiceImpl<Habitacion> implements HabitacionService {


    private HabitacionRepo habitacionRepo;
    public HabitacionServiceImpl (HabitacionRepo habitacionRepo){
        this.habitacionRepo=habitacionRepo;
    }

    @Transactional
    @Override
    public void save(Habitacion entity) {
       habitacionRepo.save(entity);
    }
    @Transactional
    @Override
    public List<Habitacion> findAll() {
        return habitacionRepo.findAll();
    }
    @Transactional
    @Override
    public Optional<Habitacion> update(Habitacion entity) {
       return habitacionRepo.update(entity);
    }
    @Transactional
    @Override
    public int deleteById(Long entityId) {
       return habitacionRepo.deleteById(entityId);

    }
    @Transactional
    @Override
    public Optional<Habitacion> findById(Long entityId) {
       return habitacionRepo.findById(entityId);
    }
}
