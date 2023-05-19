/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author pc
 */
public class Persona {

    private String name;
    private String surname;
    private int age;
    private String document;
    private Perro dog;

    public Persona(String name, String surname, int age, String document) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.document = document;
    }

    public void setPerro(Perro dog) {
        this.dog = dog;
    }

    public void muestraInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Age: " + age);
        System.out.println("Document: " + document);
        if (dog != null) {
            System.out.println("NombrePerro: " + dog.getNombre());
            System.out.println("RazaPerro: " + dog.getRaza());
            System.out.println("EdadPerro: " + dog.getEdad());
            System.out.println("TamanioPerro: " + dog.getTamanio());
        }
    }

    @Override
    public String toString() {
        return "Persona{" + "name=" + name + ", surname=" + surname + ", age=" + age + ", document=" + document + ", dog=" + dog + '}';
    }

}

