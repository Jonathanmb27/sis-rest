package com.innova.service.impl;

import com.innova.domain.Inquilino;
import com.innova.repository.InquilinoRepo;
import com.innova.service.InquilinoService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class InquilinoServiceImpl extends AbstractServiceImpl<Inquilino> implements InquilinoService {

    private InquilinoRepo inquilinoRepo;
    public InquilinoServiceImpl (InquilinoRepo inquilinoRepo){
        this.inquilinoRepo=inquilinoRepo;
    }
    @Transactional
    @Override
    public Optional<Inquilino> findByName(String name) {
        return inquilinoRepo.findByName(name);
    }
}
