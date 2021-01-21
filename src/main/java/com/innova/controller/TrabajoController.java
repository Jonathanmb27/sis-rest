package com.innova.controller;

import com.innova.domain.Trabajo;
import com.innova.problem.IllegalOperation;
import com.innova.problem.NotFoundException;
import com.innova.problem.TrabajoException;
import com.innova.repository.TrabajoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//@Controller
@RestController
@RequestMapping("/trabajos")
public class TrabajoController {
    /*
    * page 375 codes http
    * @JsonProperty 377
     * */

 /*
 * 383
 * */
    private TrabajoRepo trabajoRepo;
    public TrabajoController(TrabajoRepo trabajoRepo){
        this.trabajoRepo=trabajoRepo;
    }

    /*
    * list all
    * */
    //@ResponseBody
    @ResponseStatus(HttpStatus.OK)
    //@RequestMapping(path = "/list", method = RequestMethod.GET)
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<Trabajo> list(){
          return   trabajoRepo.findAll();
    }

    /*
    * find id
    * */
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Trabajo findbyId(@PathVariable long id){
        Optional<Trabajo> trabajo=trabajoRepo.findById(id);
        if(trabajo.isPresent()) return trabajo.get();
        /*
        * remplazdo este codido por TrabajoException
        * */
       // else throw new NotFoundException(Trabajo.class,id);
        else throw new TrabajoException(HttpStatus.NOT_FOUND,"Unable to find entry whit id: "+id);
    }


    /*
    * create
    * */
    /*
    * aqui no debe de producir nadad
    * solo debe mandar un link con la ubiaccion del recurso
    * */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes =MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Trabajo create(@Validated(Trabajo.BasicValidation.class) @RequestBody  Trabajo trabajo, BindingResult result) {
        if (!result.hasErrors()) {
            trabajoRepo.save(trabajo);
            return trabajo;
        } else {
            /*
             * remplazdo este codido por TrabajoException
             * */
            //throw new IllegalOperation("Can not save entry because: "+result);}
            throw new TrabajoException(HttpStatus.BAD_REQUEST, "Cannot save entry "+result);
        }

    }
    /*
    * update
    * */
    @PutMapping(path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id){
        /*
        * return link
        * */
    }
    /*
    * find by phone
    * */
    @GetMapping(path = "/phone/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Trabajo findPhoneAsMap(@PathVariable String phone){
        Optional<Trabajo> trabajo=trabajoRepo.findByPhone(phone);
        if(trabajo.isPresent())
            return trabajo.get();
        //else throw new NotFoundException(Trabajo.class, Long.parseLong(phone));
        else throw new TrabajoException(HttpStatus.NOT_FOUND,"Unable to find entry whit phone: "+phone);
    }
    /**************************************************************************/
    /*
    * version mejorada en RestExceptionHandler.class
    * */
    /*@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> handleNotFound(Exception e){
        //just return empty 404
        return new ResponseEntity<>("Unexpected Exception: "+e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalOperation.class})
    public void handleIllegalOperation(){
        //just return empty 400
    }*/

}
