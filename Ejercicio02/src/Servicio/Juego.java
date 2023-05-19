/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Revolver.RevolverDeAgua;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class Juego {

    private ArrayList<Jugador> jugadores;
    private RevolverDeAgua revolver;

    public void ronda() {
        int jugadorActual = 0;
        boolean alguienMojado = false;

        while (!alguienMojado) {
            Jugador jugador = jugadores.get(jugadorActual);
            alguienMojado = jugador.disparo(revolver);

            System.out.println(jugador);
            System.out.println(revolver);

            jugadorActual = (jugadorActual + 1) % jugadores.size();
        }

        System.out.println("¡Alguien se mojó!");
    }

    public void llenarJuego(ArrayList<Jugador> jugadores, RevolverDeAgua revolver) {
        this.jugadores = jugadores;
        this.revolver = revolver;
    }
}
