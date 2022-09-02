package com.Udea.Ciclo3.Clases;


import javax.persistence.*;

@Entity
@Table(name="Movimientos")

public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private long monto;
    private String concepto;


    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado usuario;

    public Empleado getEmpleado() {
        return usuario;
    }

    public void setEmpleado(Empleado empleado) {
        this.usuario = empleado;
    }

    public MovimientoDinero() {
    }

    public MovimientoDinero(long monto, String concepto, Empleado usuario) {
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = usuario;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Empleado getUsuario() {
        return usuario;
    }

    public void setUsuario(Empleado usuario) {
        this.usuario = usuario;
    }
}


