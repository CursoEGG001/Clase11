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

    private String name;
    private String race;
    private int age;
    private String size;

    public Perro(String name, String race, int age, String size) {
        this.name = name;
        this.race = race;
        this.age = age;
        this.size = size;
    }

    public String getNombre() {
        return name;
    }

    public String getRaza() {
        return race;
    }

    public int getEdad() {
        return age;
    }

    public String getTamanio() {
        return size;
    }

}
