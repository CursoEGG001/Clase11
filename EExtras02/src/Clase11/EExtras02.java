/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clase11;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class EExtras02 {

    private String movieTitle;
    private int movieDuration;
    private int minimumAge;
    private String movieDirector;
    private int priceOfTicket;

    private boolean[][] seats;

    public EExtras02() {

        this.movieTitle = "The Shawshank Redemption";
        this.movieDuration = 142;
        this.minimumAge = 13;
        this.movieDirector = "Frank Darabont";
        this.priceOfTicket = 10;

        this.seats = new boolean[8][6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                this.seats[i][j] = false;
            }
        }

    }

    public void addSpectator(String name, int age, int money) {
        if (age >= this.minimumAge && money >= this.priceOfTicket) {
            boolean foundSeat = false;
            for (int i = 8 - 1; i >= 0 && !foundSeat; i--) {
                for (int j = 0; j < 6 && !foundSeat; j++) {
                    int rFila = (int) (Math.random() * (8-1));
                    int rCol = (int) (Math.random() * (6-1));
                    if (!this.seats[rFila][rCol]) {
                        this.seats[rFila][rCol] = true;
                        foundSeat = true;
                        System.out.println(name + " se asentó en el asiento " + (rFila + 1) + ((char) ('A' + rCol)));
                    }
                }
            }
        } else {
            System.out.println(name + " no puede ver la película.");
        }
    }

    public void showSeats() {
        for (int i = 8 - 1; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (this.seats[i][j]) {
                    System.out.print((i + 1) + String.valueOf((char) ('A' + j)) + "X |");
                } else {
                    System.out.print((i + 1) + String.valueOf((char) ('A' + j)) + "_ |");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        EExtras02 cinema = new EExtras02();

        System.out.println("¡Bienvenidos al cine!");
        System.out.println("La película presentada hoy es " + cinema.movieTitle);
        System.out.println("La película dura " + cinema.movieDuration + " minutos.");
        System.out.println("La Edad permitida para ver ésta es " + cinema.minimumAge);
        System.out.println("El precio de la entrada es " + cinema.priceOfTicket + " pesos");

        String answer = "S";
        while (answer.equals("S")) {
            System.out.println("Nombre del espectador: ");
            String name = leer.next();

            System.out.println("Ingrese la edad del espectador: ");
            int age = leer.nextInt();

            System.out.println("Ponga la cantidad de dinero del espectador: ");
            int money = leer.nextInt();

            cinema.addSpectator(name, age, money);

            System.out.println("¿Agregas otro? (S/N) ");

            answer = leer.next().toUpperCase();

        }

        System.out.println("Cuadro de los asientos: ");
        cinema.showSeats();
    }
}
