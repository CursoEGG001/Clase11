/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author pc
 */
public class Perro {
    private String nombre;
    private String raza;
    private int edad;
    private String talla;
    private boolean adoptado;

    public Perro(String nombre, String raza, int edad, String talle) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.talla = talle;
        this.adoptado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public String getTalla() {
        return talla;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }
}