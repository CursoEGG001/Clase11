package Entidades;

import java.util.Date;

public class Cuota {

    private int numCuota;

    private double montoTotal;

    private boolean Pagada;

    private Date fechaVencimiento;

    private String formaPago;

    @Override
    public String toString() {
        return "Cuota{" + "numCuota=" + numCuota + ", montoTotal=" + montoTotal + ", Pagada=" + Pagada + ", fechaVencimiento=" + fechaVencimiento + ", formaPago=" + formaPago + '}';
    }

    public int getNumCuota() {
        return numCuota;
    }

    public void setNumCuota(int numCuotas) {
        this.numCuota = numCuotas;
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

    public Cuota(int numCuota, double montoTotal, boolean Pagada, Date fechaVencimiento, String formaPago) {
        this.numCuota = numCuota;
        this.montoTotal = montoTotal;
        this.Pagada = Pagada;
        this.fechaVencimiento = fechaVencimiento;
        this.formaPago = formaPago;
    }

    public Cuota() {
    }
}
