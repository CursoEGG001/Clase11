/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase11;

import Entidad.Perro;
import Entidad.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos clases. Perro, que tendrá como
 * atributos: nombre, raza, edad y tamaño; y la clase Persona con atributos: nombre, apellido, edad, documento y Perro. Ahora
 * deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que pensar la lógica necesaria para asignarle
 * a cada Persona un Perro y por ultimo, mostrar desde la clase Persona, la información del Perro y de la Persona. Realizar
 * unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a tener que contar con muchas personas y muchos perros.
 * El programa deberá preguntarle a cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
 * al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la persona. Una vez que la
 * Persona elige el Perro se le asigna, al final deberemos mostrar todas las personas con sus respectivos perros.
 *
 * @author pc
 */
public class EExtras01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Persona> personas = new ArrayList<>();
        List<Perro> perros = new ArrayList<>();

        // Crear dos Perros
        Perro perro1 = new Perro("Bobby", "Labrador", 3, "Mediano");
        Perro perro2 = new Perro("Rocky", "Bulldog", 2, "Grande");
        perros.add(perro1);
        perros.add(perro2);

        // Crear dos Personas
        Persona persona1 = new Persona("Juan", "Perez", 30, 123456789);
        Persona persona2 = new Persona("Maria", "Lopez", 25, 987654321);
        personas.add(persona1);
        personas.add(persona2);

        // Asignar perros a personas
        for (Persona persona : personas) {
            System.out.println("Hola " + persona.getNombre() + ", elige un perro para adoptar: ");
            for (Perro perro : perros) {
                if (!perro.isAdoptado()) {
                    System.out.println(perro.getNombre() + " - Raza: " + perro.getRaza() + " - Edad: " + perro.getEdad() + " - Tamaño: " + perro.getTamaño());
                }
            }

            String nombrePerro = scanner.nextLine();

            Perro perroElegido = null;
            for (Perro perro : perros) {
                if (perro.getNombre().equalsIgnoreCase(nombrePerro)) {
                    perroElegido = perro;
                    break;
                }
            }

            if (perroElegido != null) {
                if (perroElegido.isAdoptado()) {
                    System.out.println("El perro ya ha sido adoptado por otra persona.");
                } else {
                    persona.setPerro(perroElegido);
                    perroElegido.setAdoptado(true);
                    System.out.println("¡Felicidades! Has adoptado a " + perroElegido.getNombre() + ".");
                }
            } else {
                System.out.println("No se encontró un perro con ese nombre.");
            }

            System.out.println();
        }

        // Mostrar información de las personas y sus perros
        System.out.println("Información de las personas y sus perros:");
        for (Persona persona : personas) {
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Apellido: " + persona.getApellido());
            System.out.println("Edad: " + persona.getEdad());
            System.out.println("Documento: " + persona.getDocumento());

            Perro perro = persona.getPerro();
            if (perro != null) {
                System.out.println("Perro: " + perro.getNombre() + " - Raza: " + perro.getRaza() + " - Edad: " + perro.getEdad() + " - Tamaño: " + perro.getTamaño());
            } else {
                System.out.println("No ha adoptado un perro.");
            }

            System.out.println();
        }
    }
}
