/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase11;

import Entidades.Clientes;
import Entidades.Polizas;
import Entidades.Vehiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class EExtraa03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una instancia de la clase Cliente
        Clientes cliente = new Clientes();

        // Ingresar los datos del cliente
        System.out.println("Ingrese el nombre del cliente:");
        cliente.setNombre(scanner.nextLine());

        System.out.println("Ingrese el apellido del cliente:");
        cliente.setApellido(scanner.nextLine());

        System.out.println("Ingrese el email del cliente:");
        cliente.setEmail(scanner.nextLine());

        System.out.println("Ingrese el domicilio del cliente:");
        cliente.setDomicilio(scanner.nextLine());

        System.out.println("Ingrese el teléfono del cliente:");
        cliente.setTelefono(scanner.nextLine());

        // Crear una instancia de la clase Vehiculo
        Vehiculo vehiculo = new Vehiculo();

        // Ingresar los datos del vehículo
        System.out.println("Ingrese la marca del vehículo:");
        vehiculo.setMarca(scanner.nextLine());

        System.out.println("Ingrese el modelo del vehículo:");
        vehiculo.setModelo(scanner.nextLine());

        System.out.println("Ingrese el año del vehículo:");
        vehiculo.setAnio(scanner.nextInt());
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.println("Ingrese el número de motor del vehículo:");
        vehiculo.setNumMotor(scanner.nextLine());

        System.out.println("Ingrese el número de chasis del vehículo:");
        vehiculo.setChasis(scanner.nextLine());

        System.out.println("Ingrese el color del vehículo:");
        vehiculo.setColor(scanner.nextLine());

        System.out.println("Ingrese el tipo de vehículo:");
        vehiculo.setTipo(scanner.nextLine());

        // Crear una instancia de la clase Polizas
        Polizas poliza = new Polizas();

        // Ingresar los datos de la póliza
        System.out.println("Ingrese el número de póliza:");
        poliza.setNumPoliza(scanner.nextLine());

        System.out.println("Ingrese la fecha de inicio de la póliza (formato: dd/MM/yyyy):");
        String fechaInicioStr = scanner.nextLine();
        try {
            Date fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicioStr);
            poliza.setFechaInicio(fechaInicio);
        } catch (ParseException e) {
            System.out.println("Fecha de inicio inválida. Se utilizará la fecha actual.");
            poliza.setFechaInicio(new Date());
        }

        System.out.println("Ingrese la cantidad de cuotas:");
        poliza.setCuotas(scanner.nextInt());
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.println("Ingrese la forma de pago:");
        poliza.setFormaPago(scanner.nextLine());

        System.out.println("Ingrese el monto asegurado:");
        poliza.setMontoAsegurado(scanner.nextDouble());
        scanner.nextLine(); // Consumir el salto de línea pendiente

        System.out.println("¿La póliza incluye cobertura de granizo? (true/false):");
        poliza.setIncluyeGranizo(scanner.nextBoolean());
        scanner.nextLine(); // Consumir el salto de línea pendiente

        if (poliza.isIncluyeGranizo()) {
            System.out.println("Ingrese el monto máximo cubierto por granizo:");
            poliza.setMontoMaxGranizo(scanner.nextDouble());
            scanner.nextLine(); // Consumir el salto de línea pendiente
        }

        System.out.println("Ingrese el tipo de cobertura:");
        poliza.setTipoCobertura(scanner.nextLine());

        // Asignar el cliente y el vehículo a la póliza
        poliza.setCliente(cliente);
        poliza.setVehiculo(vehiculo);

        // Mostrar los datos ingresados
        System.out.println("\nDatos ingresados:");
        System.out.println(poliza.toString());
    }
}
