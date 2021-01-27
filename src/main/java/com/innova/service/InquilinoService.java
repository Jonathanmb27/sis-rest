package com.innova.service;

import com.innova.domain.Inquilino;

import java.util.Optional;

public interface InquilinoService extends AbstractService<Inquilino>{

    Optional<Inquilino> findByName(String name);
}
