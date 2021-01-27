package com.innova.service;

import com.innova.domain.Trabajo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TrabajoService extends AbstractService<Trabajo> {


     Optional<Trabajo> findByPhone(String phone);
     List<Trabajo> findAll();
     Map<String, Object> findPhoneAsMap(String phone);
}
