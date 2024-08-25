package com.example.hoteladri.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.sql.Date;

@Entity
public class Reserva {
    @Id
    Long id;
    @ManyToOne
    private Habitacion habitacion;
    @ManyToOne
    private Cliente cliente;
    private Date fechaInicio;
    private Date fechaFin;
    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    public Reserva(Habitacion habitacion, Cliente cliente, Date fechaInicio, Date fechaFin, EstadoReserva estado) {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public void confirmarReserva() {
        this.estado = EstadoReserva.CONFIRMADA;
    }

    public void cancelarReserva() {
        this.estado = EstadoReserva.CANCELADA;
    }
}