package Entidades;

import java.util.Date;

public class Polizas {

    private String numPoliza;

    private Date fechaInicio;

    private int cuotas;

    private String formaPago;

    private double montoAsegurado;

    private boolean incluyeGranizo;

    private double montoMaxGranizo;

    private String tipoCobertura;

    private Clientes cliente;

    private Vehiculo vehiculo;

    public String getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public double getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(double montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public boolean isIncluyeGranizo() {
        return incluyeGranizo;
    }

    public void setIncluyeGranizo(boolean incluyeGranizo) {
        this.incluyeGranizo = incluyeGranizo;
    }

    public double getMontoMaxGranizo() {
        return montoMaxGranizo;
    }

    public void setMontoMaxGranizo(double montoMaxGranizo) {
        this.montoMaxGranizo = montoMaxGranizo;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(String tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Polizas(String numPoliza, Date fechaInicio, int cuotas, String formaPago, double montoAsegurado, boolean incluyeGranizo, double montoMaxGranizo, String tipoCobertura, Clientes cliente, Vehiculo vehiculo) {
        this.numPoliza = numPoliza;
        this.fechaInicio = fechaInicio;
        this.cuotas = cuotas;
        this.formaPago = formaPago;
        this.montoAsegurado = montoAsegurado;
        this.incluyeGranizo = incluyeGranizo;
        this.montoMaxGranizo = montoMaxGranizo;
        this.tipoCobertura = tipoCobertura;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Polizas{" + "numPoliza=" + numPoliza + ", fechaInicio=" + fechaInicio + ", cuotas=" + cuotas + ", formaPago=" + formaPago + ", montoAsegurado=" + montoAsegurado + ", incluyeGranizo=" + incluyeGranizo + ", montoMaxGranizo=" + montoMaxGranizo + ", tipoCobertura=" + tipoCobertura + ", cliente=" + cliente + ", vehiculo=" + vehiculo + '}';
    }

    public Polizas() {
    }
}
