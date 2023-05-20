/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author pc
 */
public class Alumno {

    private String nombreCompleto;
    private String DNI;
    private int cantidadVotos;

    public Alumno(String nombreCompleto, String DNI) {
        this.nombreCompleto = nombreCompleto;
        this.DNI = DNI;
        this.cantidadVotos = 0;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDNI() {
        return DNI;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void incrementarVotos() {
        cantidadVotos++;
    }

    @Override
    public String toString() {
        return "Alumno{"
                + "nombreCompleto='" + nombreCompleto + '\''
                + ", DNI='" + DNI + '\''
                + ", cantidadVotos=" + cantidadVotos
                + '}';
    }

    public void setNombreCompleto(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setDNI(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
