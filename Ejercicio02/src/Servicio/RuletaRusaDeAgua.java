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
public class RuletaRusaDeAgua {
    public static void main(String[] args) {
        // Crear el revolver y llenarlo
        RevolverDeAgua revolver = new RevolverDeAgua();
        revolver.llenarRevolver();

        // Crear los jugadores
        ArrayList<Jugador> jugadores = new ArrayList<>();
        int numJugadores = 6; // Por defecto
        // Solicitar al usuario el número de jugadores (entre 1 y 6)
        // Aquí puedes incluir tu lógica para solicitar el número de jugadores al usuario

        // Añadir los jugadores al juego
        for (int i = 1; i <= numJugadores; i++) {
            jugadores.add(new Jugador(i));
        }

        // Crear el juego y llenarlo
        Juego juego = new Juego();
        juego.llenarJuego(jugadores, revolver);

        // Jugar rondas hasta que alguien se moje
        juego.ronda();
    }
}
