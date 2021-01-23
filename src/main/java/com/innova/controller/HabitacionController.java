package com.innova.controller;


import com.innova.domain.Habitacion;
import com.innova.problem.TrabajoException;
import com.innova.problem.json.Data;
import com.innova.repository.HabitacionRepo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;




import javax.servlet.http.HttpServletRequest;

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
    public ResponseEntity<Data> create(@Validated @RequestBody Habitacion habitacion,
                                       BindingResult result, HttpServletRequest request){

            if(!result.hasErrors()) {
                try{
                    habitacionRepo.save(habitacion);
                    String url=request.getRequestURL().toString().concat("/"+habitacion.getId());
                    return new ResponseEntity<>(new Data(url,"Created Successful"),HttpStatus.OK);
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        Optional<Habitacion> habitacionFind=habitacionRepo.findById(id);
        if(habitacionFind.isPresent()){
            habitacionRepo.deleteById(id);
        }else{
            throw new TrabajoException(HttpStatus.BAD_REQUEST,"Don not exist habitacion with id: "+id);
        }
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Habitacion findById(@PathVariable  Long id){
            Optional<Habitacion> habitacionFind=habitacionRepo.findById(id);
            if(habitacionFind.isPresent()){
                return habitacionFind.get();
            }else{
                throw new TrabajoException(HttpStatus.BAD_REQUEST,"Don not exist habitacion with id: "+id);
            }
    }

    @PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Data> update(@RequestBody Habitacion habitacion, @PathVariable long id, HttpServletRequest request){
        Optional<Habitacion> habitacionFind=habitacionRepo.findById(id);
        if(habitacionFind.isPresent()){
            habitacionFind.get().setFechaIngreso(habitacion.getFechaIngreso());
            habitacionFind.get().setNombreHabitacion(habitacion.getNombreHabitacion());
            habitacionFind.get().setPrecioHabitacion(habitacion.getPrecioHabitacion());
            Optional<Habitacion> habitacionUpdate=habitacionRepo.update(habitacionFind.get());
            if(habitacionUpdate.isPresent()){
                /*String [] data={"a","tt","s","5","8","r"};
                List<String> data2= Arrays.asList(data);
                Collections.sort(data2);
                System.out.println(data2);
                System.out.println(Arrays.toString(data));*/
                //new JsonError(errorUrl,e.getMessage()),trabajoException.getHttpStatus()
                String urlUpdate;
                urlUpdate=request.getRequestURL().toString();
                return new ResponseEntity<>(new Data(urlUpdate,"Update Successful"),HttpStatus.OK);
            }else{
                throw new TrabajoException(HttpStatus.INTERNAL_SERVER_ERROR,"Unexpected error "+id);
            }
        }else{
            throw new TrabajoException(HttpStatus.BAD_REQUEST,"don not exist habitavion with id: "+id);
        }
    }
}
