package Entidades;

import java.util.Date;
import java.util.List;

public class Polizas {

    private String numPoliza;

    private Date fechaInicio;

    private List<Cuota> cuotas;

    private String formaPago;

    private double montoAsegurado;

    private boolean incluyeGranizo;

    private double montoMaxGranizo;

    private String tipoCobertura;

    private Clientes cliente;

    private Vehiculo vehiculo;

    private boolean estado;

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

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
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

    public Polizas(String numPoliza, Date fechaInicio, List<Cuota> cuotas, String formaPago, double montoAsegurado, boolean incluyeGranizo, double montoMaxGranizo, String tipoCobertura, Clientes cliente, Vehiculo vehiculo) {
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

    public Polizas() {
    }

    public void setEstado(boolean nuevoEstado) {
        this.estado = nuevoEstado;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Polizas{");
        sb.append("numPoliza=").append(numPoliza);
        sb.append(", fechaInicio=").append(fechaInicio);

        Cuota cuota=(cuotas.get(cuotas.size()-1));
        sb.append(", cuota=").append(cuota.getMontoTotal());
        sb.append(", formaPago=").append(formaPago);
        sb.append(", montoAsegurado=").append(montoAsegurado);
        sb.append(", incluyeGranizo=").append(incluyeGranizo);
        sb.append(", montoMaxGranizo=").append(montoMaxGranizo);
        sb.append(", tipoCobertura=").append(tipoCobertura);
        sb.append(", cliente=").append(cliente);
        sb.append(", vehiculo=").append(vehiculo);
        sb.append(", estado=").append(estado);
        sb.append('}');
        return sb.toString();
    }

    
}
