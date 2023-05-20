/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

/**
 *
 * @author pc
 */
import Entidad.Alumno;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Simulador {

    private List<String> nombres;
    private List<String> apellidos;
    private List<String> dnis;

    public Simulador() {
        nombres = new ArrayList<>();
        apellidos = new ArrayList<>();
        dnis = new ArrayList<>();

        // Inicializar nombres y apellidos
        nombres.add("Juan");
        nombres.add("Jimena");
        nombres.add("Miguel");
        nombres.add("Emma");
        // Agregar más nombres según necesidad

        apellidos.add("Sampano");
        apellidos.add("Jonas");
        apellidos.add("Vilca");
        apellidos.add("Burgo");
        // Agregar más apellidos según necesidad
    }

    public List<Alumno> generarListadoAlumnos(int cantidad) {
        List<Alumno> alumnos = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            String nombre = nombres.get(random.nextInt(nombres.size()));
            String apellido = apellidos.get(random.nextInt(apellidos.size()));
            String nombreCompleto = nombre + " " + apellido;
            String dni = generarDNI();
            alumnos.add(new Alumno(nombreCompleto, dni));
        }

        return alumnos;
    }

    private String generarDNI() {
        Random random = new Random();
        String dni;
        boolean dniRepetido;

        do {
            int numeroDNI = random.nextInt(99999999 - 10000000 + 1) + 10000000;
            dni = String.valueOf(numeroDNI);
            dniRepetido = dnis.contains(dni);
        } while (dniRepetido);

        dnis.add(dni);
        return dni;
    }

    public void asignarNombresDNI(List<Alumno> alumnos) {
        List<String> nombresLista = new ArrayList<>(this.nombres);
        List<String> dnies = new ArrayList<>(this.dnis);
        Random random = new Random();

        for (Alumno alumno : alumnos) {
            String nombre = nombresLista.get(random.nextInt(nombresLista.size()));
            nombresLista.remove(nombre);
            alumno.setNombreCompleto(nombre + " " + apellidos.get(random.nextInt(apellidos.size())));

            String dni = dnies.get(random.nextInt(dnies.size()));
            dnies.remove(dni);
            alumno.setDNI(dni);
        }
    }

    public void mostrarListadoAlumnos(List<Alumno> alumnos) {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    public void votacion(List<Alumno> alumnos) {
        Random random = new Random();
        Set<Alumno> votantes = new HashSet<>();

        for (Alumno votante : alumnos) {
            Set<Alumno> votados = new HashSet<>();
            while (votados.size() < 3) {
                Alumno alumnoVotado = alumnos.get(random.nextInt(alumnos.size()));
                if (votante != alumnoVotado && !votados.contains(alumnoVotado)) {
                    votados.add(alumnoVotado);
                }
            }

            Voto voto = new Voto(votante, votados);
            votante.incrementarVotos();
            for (Alumno votado : votados) {
                votado.incrementarVotos();
            }

            votantes.add(votante);
        }

        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombreCompleto());
            System.out.println("Cantidad de votos: " + alumno.getCantidadVotos());
            System.out.println("Votos recibidos:");
            for (Voto voto : votos) {
                if (voto.getAlumnosVotados().contains(alumno)) {
                    System.out.println("- " + voto.getAlumno().getNombreCompleto());
                }
            }
            System.out.println();
        }
    }

    public void recuentoVotos(List<Alumno> alumnos) {
        // Implementar lógica para el recuento de votos si es necesario
    }

    public void mostrarFacilitadores(List<Alumno> alumnos) {
        // Implementar lógica para mostrar los facilitadores y suplentes
    }

}
