package com.innova.controller;


import com.innova.domain.Habitacion;
import com.innova.problem.TrabajoException;
import com.innova.repository.HabitacionRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        try{
            if(!result.hasErrors())
            habitacionRepo.save(habitacion);
            else
                System.out.println("erro validation!!!!");
        }catch (Exception e){
            throw new TrabajoException(HttpStatus.BAD_REQUEST,"Unexpected Error");
            //System.out.println("errorroororo!!");
        }


    }
}
