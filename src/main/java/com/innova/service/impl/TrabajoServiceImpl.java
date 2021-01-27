package com.innova.service.impl;

import com.innova.domain.Trabajo;
import com.innova.repository.TrabajoRepo;
import com.innova.service.TrabajoService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TrabajoServiceImpl extends AbstractServiceImpl<Trabajo> implements TrabajoService {

    private TrabajoRepo trabajoRepo;

    public TrabajoServiceImpl(TrabajoRepo trabajoRepo){
        this.trabajoRepo=trabajoRepo;
    }
    @Transactional
    @Override
    public Optional<Trabajo> findByPhone(String phone) {
        return trabajoRepo.findByPhone(phone);
    }
    @Transactional
    @Override
    public List<Trabajo> findAll() {
       return trabajoRepo.findAll();
    }


    @Transactional
    public Optional<Trabajo> findById(Long entityId) {
        return trabajoRepo.findById(entityId);
    }
    @Transactional
    @Override
    public Map<String, Object> findPhoneAsMap(String phone) {
        return trabajoRepo.findPhoneAsMap(phone);
    }
}
