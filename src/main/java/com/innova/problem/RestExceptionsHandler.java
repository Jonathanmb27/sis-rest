package com.innova.problem;

import com.innova.problem.json.JsonError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/*
* El alcance de un aviso de controlador puede limitarse a
* excepciones lanzadas por métodos de controladores declarados
* en un conjunto específico de paquetes (o subpaquetes)
* estableciendo el atributo basePackages.
* */
@ControllerAdvice(basePackages = "com.innova.controller")
public class RestExceptionsHandler {

    /*
    * La clase ResponseEntity <T> es una clase Spring especializada
    * para construir un objeto de respuesta con el cuerpo, el código
    * de estado y los encabezados. Al devolver este tipo de instancia,
    * podemos personalizar el estado de la respuesta desde el interior
    * del cuerpo del método, en lugar de usar la anotación @ResponseStatus.
    * Esto es útil porque podemos reducir la cantidad de métodos de
    * manejo de excepciones que se crearán, reduciendo así el código
    * repetitivo.
    * */
   /* @ExceptionHandler
    @ResponseBody
    public ResponseEntity<String> handleException(TrabajoException e){

        return new ResponseEntity<>(e.errorMessage(),e.getHttpStatus());
    }*/
    /***********************************************************************/
    /*
    * version twho
    * */
   /* @ExceptionHandler
    @ResponseBody
    public ResponseEntity<String> handleException(Exception e){

        if (e instanceof TrabajoException){
            TrabajoException exception=(TrabajoException) e;
            return new ResponseEntity<>(exception.errorMessage(),exception.getHttpStatus());
        }
        return new ResponseEntity<>("Unexpected Exception: "+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
    /***********************************************************************/
    /*
    * version tree add JsonError class
    * */
    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<JsonError> handleException(HttpServletRequest request,Exception e){
        String errorUrl=request.getRequestURL().toString();
        if(e instanceof TrabajoException){
            TrabajoException trabajoException=(TrabajoException) e;
            return new ResponseEntity<>(new JsonError(errorUrl,e.getMessage()),((TrabajoException) e).getHttpStatus());
        }else{
            return new ResponseEntity<>(new JsonError(errorUrl,
                    "Unexpected Exception1: "+e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
