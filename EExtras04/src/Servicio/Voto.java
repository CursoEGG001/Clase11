/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Entidad.Alumno;
import java.util.Set;

/**
 *
 * @author pc
 */
public class Voto {

    private Alumno daVotos;
    private Set<Alumno> recibenVotos;

    public Voto(Alumno daVotos, Set<Alumno> recibenVotos) {
        this.daVotos = daVotos;
        this.recibenVotos = recibenVotos;
    }

    public Set<Alumno> getAlumnosVotados() {
        return (this.recibenVotos);
    }

    public Alumno getAlumno() {
        return this.daVotos;
    }

}
