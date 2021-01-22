package com.innova.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.innova.util.DateProcessor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Habitacion extends AbstractEntity {

    @Column(name = "NOMBRE")
    private String nombreHabitacion;
    @Column(name = "PRECIO")
    private int precioHabitacion;

    @JsonFormat(shape = JsonFormat.Shape.STRING,
            pattern = DateProcessor.DATE_FORMAT)
    @Column(name = "FECHA_INGRESO")
    private LocalDate fechaIngreso;

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public int getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(int precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
