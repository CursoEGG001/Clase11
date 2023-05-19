/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cartas;

/**
 *
 * @author pc
 */
    public class Cartas {

        private int number;
        private Palo suit;

        public Cartas(int number, Palo suit) {
            this.number = number;
            this.suit = suit;
        }

        @Override
        public String toString() {
            return this.number + " de " + this.suit;
        }

    }