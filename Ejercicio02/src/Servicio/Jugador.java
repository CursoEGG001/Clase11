/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Revolver.RevolverDeAgua;

/**
 *
 * @author pc
 */
public class Jugador {

    private int id;
    private String nombre;
    private boolean mojado;

    public Jugador(int id) {
        this.id = id;
        this.nombre = "Jugador " + id;
        this.mojado = false;
    }

    public boolean disparo(RevolverDeAgua r) {
        r.siguienteChorro();
        if (r.mojar()) {
            mojado = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre + " - Mojado: " + mojado;
    }
}