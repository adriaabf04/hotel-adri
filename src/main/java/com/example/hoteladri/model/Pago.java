package com.example.hoteladri.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    @OneToOne
    private Reserva reserva;
    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    public Pago(Date fecha, Reserva reserva, EstadoPago estado) {
        this.fecha = fecha;
        this.reserva = reserva;
        this.estado = estado;
    }

    public Pago() {
    }

    public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }
}
