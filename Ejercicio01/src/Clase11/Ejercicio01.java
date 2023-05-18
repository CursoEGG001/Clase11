/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clase11;

import Entidad.Perro;
import Entidad.Persona;

/**
 * Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos clases. Perro, que tendrá como
 * atributos: nombre, raza, edad y tamaño; y la clase Persona con atributos: nombre, apellido, edad, documento y Perro. Ahora
 * deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que pensar la lógica necesaria para asignarle
 * a cada Persona un Perro y por ultimo, mostrar desde la clase Persona, la información del Perro y de la Persona.
 *
 * @author pc
 */
public class Ejercicio01 {


    public static void main(String[] args) {

        // Crea 2 personas
        Persona person1 = new Persona("John", "Doe", 30, "123456789");
        Persona person2 = new Persona("Jane", "Smith", 25, "987654321");

        // Crea 2 perros
        Perro dog1 = new Perro("Pluto", "Golden Retriever", 5, "Mediano");
        Perro dog2 = new Perro("Milo", "Labrador Retriever", 2, "Pequeño");

        // Asigna un perro a cada persona
        person1.setPerro(dog1);
        person2.setPerro(dog2);

        // Muestra la info de cada persona y sus perros
        person1.muestraInfo();
        person2.muestraInfo();

    }

}
