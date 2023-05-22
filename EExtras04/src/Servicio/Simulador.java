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
import com.sun.javafx.scene.control.skin.VirtualFlow;
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
            boolean noValidoDNI = ((Integer.parseInt(dni.substring(0, 2)) > 44) || (Integer.parseInt(dni.substring(0, 2)) < 8));
            if (noValidoDNI) {
                i--;
            } else {
                combinaDNI.add(dni);
            }
        }

        // Damos por sentado que duplicados no apareceran despues de esto.
        HashSet<String> noDuplicados = new HashSet<>();
        for (String combinaciones : combinaDNI) {
            noDuplicados.add(combinaciones);
        }

        for (String noDuplicado : noDuplicados) {
            combinacionesDNI.add(noDuplicado);
        }
        if (noDuplicados.size() < cantidad) {
            int Restan = cantidad - noDuplicados.size();
            System.out.println("Restan conseguir " + Restan + " DNIs más");
            for (int i = 0; i < Restan; i++) {
                combinacionesDNI.add(String.valueOf((random.nextInt(44 - 8) + 8)).concat(String.valueOf(random.nextInt(999999))));
            }

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
        //Se hace en listas diferentes para evitar concurrencia
        List<Alumno> facilitadores = obtenerFacilitadores(filtroFacilitadores, NUM_FACILITADORES + NUM_FACILITADORES_SUPLENTES);
        List<Alumno> facilitadoresSuplentes = obtenerFacilitadores(facilitadores, NUM_FACILITADORES_SUPLENTES);

        System.out.println("Facilitadores:");
        Iterator<Alumno> losFacilitadores = facilitadores.iterator();
        int cnt = 0;
        while (losFacilitadores.hasNext()) {
            Alumno aMostrar = losFacilitadores.next();
            System.out.println((cnt + 1) + ". " + aMostrar.getNombreCompleto() + ", DNI: " + aMostrar.getDNI());
            cnt++;
        }

        //Usamos facilitadores para obtener solo los suplentes.
        filtroFacilitadores = new ArrayList<Alumno>(facilitadoresSuplentes);
        for (Alumno facilitador : filtroFacilitadores) {
            facilitadores.remove(facilitador);
        }
        System.out.println(
                "\nFacilitadores Suplentes:");
        for (int i = 0; i < facilitadores.size(); i++) {

            System.out.println((i + 1) + ". " + facilitadores.get(i).getNombreCompleto() + ", DNI: " + facilitadores.get(i).getDNI());

        }
    }

    private List<Alumno> obtenerFacilitadores(List<Alumno> alumnos, int cantidad) {
        alumnos.sort((a1, a2) -> Integer.compare(a2.getCantidadVotos(), a1.getCantidadVotos()));
        return alumnos.subList(0, cantidad);
    }
}
