package com.innova.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.innova.util.DateProcessor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Trabajo extends AbstractEntity{

   // @JsonIgnore
    @Column(name = "RUBRO")
    private String rubroTrabajo;
    @Column(name = "DIRECCION")
    private String direccionTrabajo;
    @Column(name = "TELEFONO")
   // @NotNull(groups = BasicValidation.class)
    @Size(min = 10,groups = {BasicValidation.class})
    private String telefonoTrabajo;




    /*
   * En la muestra de código anterior, el
   * atributo de forma se inicializó con JsonFormat.Shape.STRING
   * para decirle al bean convertidor de Jackson que el valor del
   * campo debería convertirse en un valor de texto en el objeto
   * JSON y el atributo de patrón se inicializó con el valor de
   * plantilla declarado en la clase DateProcessor (aaaa-MM-dd HH: mm),
   * que es el valor personalizado utilizado en todas partes del proyecto.
    * */


   /* @JsonFormat(shape = JsonFormat.Shape.STRING,
    pattern = DateProcessor.DATE_FORMAT)*/
    @Transient
    @JsonIgnore
    private LocalDateTime fechaCreada;


    public String getRubroTrabajo() {
        return rubroTrabajo;
    }

    public void setRubroTrabajo(String rubroTrabajo) {
        this.rubroTrabajo = rubroTrabajo;
    }

    public String getDireccionTrabajo() {
        return direccionTrabajo;
    }

    public void setDireccionTrabajo(String direccionTrabajo) {
        this.direccionTrabajo = direccionTrabajo;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }
    public LocalDateTime getFechaCreada() {
        return fechaCreada;
    }

    public void setFechaCreada(LocalDateTime fechaCreada) {
        this.fechaCreada = fechaCreada;
    }
    public interface BasicValidation{}
}
