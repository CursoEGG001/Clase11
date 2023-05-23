/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cartas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author pc
 */

public class Baraja {

    private ArrayList<Cartas> cards;

    public Baraja() {
    }

    public void Barajar() {
        this.cards = new ArrayList<>();
        for (int i = 1; i < 12; i++) {
            for (Palo suit : Palo.values()) {
                this.cards.add(new Cartas(i, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public Cartas otraCarta() {
        if (this.cards.isEmpty()) {
            System.out.println("No hay más cartas");
            return null;
        }
        return this.cards.remove(0);
    }

    public int cuantasCartas() {
        return this.cards.size();
    }

    public Cartas[] darCartas(int number) {
        if (number > this.cuantasCartas()) {
            System.out.println("No hay suficientes cartas");
            return null;
        }
        Cartas[] cards = new Cartas[number];
        for (int i = 0; i < number; i++) {
            cards[i] = this.otraCarta();
        }
        return cards;
    }

    public void showCartasMonton() {
        for (Cartas card : this.cards) {
            System.out.println(card);
        }
    }

    public void mostrarBaraja() {
        for (Cartas card : this.cards) {
            System.out.print(card + ", ");
        }
        System.out.println();
    }

 
}
