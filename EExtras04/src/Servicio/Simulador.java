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
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Simulador {

    private static final int NUM_VOTOS = 3;
    private static final int NUM_FACILITADORES = 5;
    private static final int NUM_FACILITADORES_SUPLENTES = 5;

    private List<String> nombres;
    private List<String> apellidos;
    private List<String> dnis;

    public Simulador() {
        nombres = new ArrayList<>();
        apellidos = new ArrayList<>();
        dnis = new ArrayList<>();

    }

    public List<Alumno> generarListadoAlumnos(int cantidad) {
        List<Alumno> alumnos = new ArrayList<>();
        Random random = new Random();

        // Inicializar las listas de nombres, apellidos
        // (puedes agregar nombres y apellidos según tus necesidades)
        String[] nom = {
            "Juan", "María", "Pedro", "Ana", "Luis", "Laura", "Carlos", "Lucía",
            "Sergio", "Marta", "Andrés", "Elena", "José", "Carmen", "Miguel", "Isabel",
            "Pablo", "Silvia", "Javier", "Rosa"
        };

        String[] apll = {
            "Gómez", "López", "Pérez", "Fernández", "Martínez", "García", "Rodríguez",
            "Sánchez", "Romero", "Torres", "Vargas", "Navarro", "Ramos", "Jiménez",
            "Moreno", "Herrera", "Castillo", "Ruiz", "Alonso", "Gutiérrez"
        };

        for (int i = 0; i < cantidad; i++) {
            String nombre = nom[random.nextInt(nom.length)];
            String apellido = apll[random.nextInt(apll.length)];
            alumnos.add(new Alumno(nombre + " " + apellido, ""));
        }

        return alumnos;
    }

    public List<String> generarCombinacionesDNI(int cantidad) {
        List<String> combinaDNI = new ArrayList<>();
        List<String> combinacionesDNI = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            String dni = "";
            while (dni.length() < 8) {
                dni += random.nextInt(10);
            }
            combinaDNI.add(dni);
        }
        HashSet<String> noDuplicados = new HashSet<>();
        for (String combinaciones : combinaDNI) {
            noDuplicados.add(combinaciones);
        }
        
        for (String noDuplicado : noDuplicados) {
            combinacionesDNI.add(noDuplicado);
        }

        return combinacionesDNI;
    }

    public void asignarNombresDNI(List<Alumno> alumnos) {
        Random random = new Random();
        List<String> docAsignables = generarCombinacionesDNI(alumnos.size());
        for (Alumno alumno : alumnos) {
            String dni = docAsignables.get(alumnos.indexOf(alumno));
            alumno.setDNI(dni);
        }
    }

    public void mostrarListadoAlumnos(List<Alumno> alumnos) {
        System.out.println("Listado de Alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.getNombreCompleto());
        }
        System.out.println();
    }

    public void votacion(List<Alumno> alumnos) {
        Random random = new Random();

        for (Alumno alumno : alumnos) {
            Set<Alumno> votos = new HashSet<>();
            int numVotos = 0;

            while (numVotos < NUM_VOTOS) {
                Alumno alumnoVotado = alumnos.get(random.nextInt(alumnos.size()));
                if (alumno != alumnoVotado && !votos.contains(alumnoVotado)) {
                    votos.add(alumnoVotado);
                    numVotos++;
                    alumnoVotado.incrementarVotos();
                }
            }

            recuentoVotos(votos);
        }
    }

    public void recuentoVotos(Set<Alumno> alumnos) {
        System.out.println("Recuento de Votos:");
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno.getNombreCompleto());
            System.out.println("Cantidad de votos: " + alumno.getCantidadVotos());
            System.out.println();
        }
    }

    public void mostrarFacilitadores(List<Alumno> alumnos) {
        List<Alumno> filtroFacilitadores = new ArrayList<>(alumnos);
        List<Alumno> facilitadores = obtenerFacilitadores(filtroFacilitadores, NUM_FACILITADORES+NUM_FACILITADORES_SUPLENTES);
        List<Alumno> facilitadoresSuplentes = obtenerFacilitadores(facilitadores, NUM_FACILITADORES_SUPLENTES);

        System.out.println("Facilitadores:");
        Iterator<Alumno> losFacilitadores = facilitadores.iterator();
        int cnt = 0;
        while (losFacilitadores.hasNext()) {
            System.out.println((cnt + 1) + ". " + losFacilitadores.next().getNombreCompleto());

        }

        System.out.println("\nFacilitadores Suplentes:");
        for (int i = 0; i < facilitadoresSuplentes.size(); i++) {
            System.out.println((i + 1) + ". " + facilitadoresSuplentes.get(i).getNombreCompleto());
        }
    }

    private List<Alumno> obtenerFacilitadores(List<Alumno> alumnos, int cantidad) {
        alumnos.sort((a1, a2) -> Integer.compare(a2.getCantidadVotos(), a1.getCantidadVotos()));
        return alumnos.subList(0, cantidad);
    }
}
