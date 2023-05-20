/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase11;

import Entidad.Alumno;
import Servicio.Simulador;
import java.util.List;

/**
 *
 * @author pc
 */
public class EExtras04 {

    public static void main(String[] args) {
        Simulador simulador = new Simulador();
        List<Alumno> alumnos = simulador.generarListadoAlumnos(10);
        simulador.asignarNombresDNI(alumnos);
        simulador.mostrarListadoAlumnos(alumnos);
        simulador.votacion(alumnos);
        simulador.recuentoVotos(alumnos);
        simulador.mostrarFacilitadores(alumnos);
    }
}