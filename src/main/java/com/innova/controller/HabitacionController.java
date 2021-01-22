package com.innova.controller;


import com.innova.domain.Habitacion;
import com.innova.problem.TrabajoException;
import com.innova.repository.HabitacionRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {

    private HabitacionRepo habitacionRepo;
    public HabitacionController (HabitacionRepo habitacionRepo){
        this.habitacionRepo=habitacionRepo;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Validated @RequestBody Habitacion habitacion, BindingResult result){

            if(!result.hasErrors()) {
                try{
                    habitacionRepo.save(habitacion);
                }catch ( Exception e){
                    throw new TrabajoException(HttpStatus.INTERNAL_SERVER_ERROR,"Unexpected Error create");
                }
            }
            else
                throw new TrabajoException(HttpStatus.BAD_REQUEST,"Field Validation error to create");
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Habitacion>findAll(){
        try{
            return habitacionRepo.findAll();
        }catch (Exception e){
            throw new TrabajoException(HttpStatus.INTERNAL_SERVER_ERROR,"Unexpected Error list all");
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        Optional<Habitacion> habitacionFind=habitacionRepo.findById(id);
        if(habitacionFind.isPresent()){
            habitacionRepo.deleteById(id);
        }else{
            throw new TrabajoException(HttpStatus.BAD_REQUEST,"Don not exist habitacion with id: "+id);
        }


    }
}
