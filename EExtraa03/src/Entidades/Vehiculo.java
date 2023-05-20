package Entidades;

public class Vehiculo {

    private String marca;

    private String modelo;

    private int anio;

    private String numMotor;

    private String chasis;

    private String color;

    private String tipo;

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", numMotor=" + numMotor + ", chasis=" + chasis + ", color=" + color + ", tipo=" + tipo + '}';
    }

    public Vehiculo(String marca, String modelo, int anio, String numMotor, String chasis, String color, String tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.numMotor = numMotor;
        this.chasis = chasis;
        this.color = color;
        this.tipo = tipo;
    }

    public Vehiculo() {
    }
}
