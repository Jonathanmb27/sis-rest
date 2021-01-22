package com.innova.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Cancelado extends AbstractEntity{

    @Column(name = "MONTO")
    private int montoCancelado;

    @Column(name = "FECHA")
    private LocalDate fechaCancelado;

    @ManyToOne
    private Inquilino inquilino;

    /*
    * campo solo para jdbcTemplate
    * */
    @Transient
    private long inquilinoId;

    public int getMontoCancelado() {
        return montoCancelado;
    }

    public void setMontoCancelado(int montoCancelado) {
        this.montoCancelado = montoCancelado;
    }

    public LocalDate getFechaCancelado() {
        return fechaCancelado;
    }

    public void setFechaCancelado(LocalDate fechaCancelado) {
        this.fechaCancelado = fechaCancelado;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public long getInquilinoId() {
        return inquilinoId;
    }

    public void setInquilinoId(long inquilinoId) {
        this.inquilinoId = inquilinoId;
    }
}
