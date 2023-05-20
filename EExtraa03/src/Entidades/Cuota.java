package Entidades;

import java.util.Date;

public class Cuota {

    private int numCuotas;

    private double montoTotal;

    private boolean Pagada;

    private Date fechaVencimiento;

    private String formaPago;

    @Override
    public String toString() {
        return "Cuota{" + "numCuotas=" + numCuotas + ", montoTotal=" + montoTotal + ", Pagada=" + Pagada + ", fechaVencimiento=" + fechaVencimiento + ", formaPago=" + formaPago + '}';
    }

    public int getNumCuotas() {
        return numCuotas;
    }

    public void setNumCuotas(int numCuotas) {
        this.numCuotas = numCuotas;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public boolean isPagada() {
        return Pagada;
    }

    public void setPagada(boolean Pagada) {
        this.Pagada = Pagada;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public Cuota(int numCuotas, double montoTotal, boolean Pagada, Date fechaVencimiento, String formaPago) {
        this.numCuotas = numCuotas;
        this.montoTotal = montoTotal;
        this.Pagada = Pagada;
        this.fechaVencimiento = fechaVencimiento;
        this.formaPago = formaPago;
    }

    public Cuota() {
    }
}
