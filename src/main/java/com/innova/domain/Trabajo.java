package com.innova.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.innova.util.DateProcessor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Trabajo extends AbstractEntity{

    @Column(name = "RUBRO")
    private String rubroTrabajo;
    @Column(name = "DIRECCION")
    private String direccionTrabajo;
    @Column(name = "TELEFONO")
    @NotNull(groups = BasicValidation.class)
    private String telefonoTrabajo;


    /*
     * JsonFormat.Shape.STRING para decirle al bean convertidor de Jackson que
     * el valor del campo debería convertirse en un valor de texto en
     * el objeto JSON y el atributo de patrón se inicializó con el valor
     * de plantilla declarado en la clase DateProcessor (aaaa-MM-dd HH: mm),
     * */
    
    @JsonFormat(shape = JsonFormat.Shape.STRING,
    pattern = DateProcessor.DATE_FORMAT)
    @Transient
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
    public interface BasicValidation{}
}
