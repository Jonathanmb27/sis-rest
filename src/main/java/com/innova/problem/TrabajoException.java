package com.innova.problem;

import org.springframework.http.HttpStatus;

public class TrabajoException extends RuntimeException{

    private HttpStatus httpStatus;
    public TrabajoException(String message){
        super(message);
    }
    public TrabajoException(HttpStatus httpStatus,String message){
        super(message);
        this.httpStatus=httpStatus;
    }
    public TrabajoException(HttpStatus httpStatus,Throwable cause){
        super(cause);
        this.httpStatus=httpStatus;
    }
    public TrabajoException(String message,Throwable cause){
        super(message,cause);
    }
    public String errorMessage(){
        return  httpStatus.value()+" : ".concat(getMessage());
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
