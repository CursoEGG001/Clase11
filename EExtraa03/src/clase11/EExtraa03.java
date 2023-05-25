/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase11;

import Entidades.Clientes;
import Entidades.Cuota;
import Entidades.Polizas;
import Entidades.Vehiculo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        Scanner opc = new Scanner(System.in);
        List<Polizas> polizas = new ArrayList<>();

        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar póliza");
            System.out.println("2. Mostrar todas las pólizas");
            System.out.println("3. Buscar póliza por número");
            System.out.println("4. Modificar estado de póliza");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = opc.nextInt();
            opc.nextLine(); // Consumir el salto de línea pendiente

            switch (opcion) {
                case 1:
                    agregarPoliza(opc, polizas);
                    break;
                case 2:
                    mostrarPolizas(polizas);
                    break;
                case 3:
                    buscarPoliza(opc, polizas);
                    break;
                case 4:
                    modificarEstadoPoliza(opc, polizas);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }
    }

    public static void agregarPoliza(Scanner scanner, List<Polizas> polizas) {
        // Crear una instancia de la clase Persona
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

        // Crear una instancia de la clase Poliza
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
        int cantCuotas = scanner.nextInt();
        List<Cuota> creaCuotas = new ArrayList<>();
        for (int i = 0; i < cantCuotas - 1; i++) {
            Cuota cuotaAgregada = new Cuota(i,0,false,new Date(),"debito");
            creaCuotas.add(cuotaAgregada);
            poliza.setCuotas(creaCuotas);
        }

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

        // Agregar la póliza a la lista de polizas
        polizas.add(poliza);

        System.out.println("¡Póliza agregada con éxito!");
    }

    public static void mostrarPolizas(List<Polizas> polizas) {
        System.out.println("\n--- Lista de pólizas ---");

        for (Polizas poliza : polizas) {
            System.out.println(poliza.toString());
            System.out.println("-----------------------");
        }
    }

    public static void buscarPoliza(Scanner scanner, List<Polizas> polizas) {
        System.out.println("Ingrese el número de póliza a buscar:");
        String numeroPoliza = scanner.nextLine();

        boolean encontrado = false;

        for (Polizas poliza : polizas) {
            if (poliza.getNumPoliza().equals(numeroPoliza)) {
                System.out.println("\n--- Póliza encontrada ---");
                System.out.println(poliza.toString());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ninguna póliza con el número ingresado.");
        }
    }

    public static void modificarEstadoPoliza(Scanner scanner, List<Polizas> polizas) {
        System.out.println("Ingrese el número de póliza a modificar:");
        String numeroPoliza = scanner.nextLine();

        boolean encontrado = false;

        for (Polizas poliza : polizas) {
            if (poliza.getNumPoliza().equals(numeroPoliza)) {
                System.out.println("Ingrese el nuevo estado de la póliza (true/false):");
                boolean nuevoEstado = scanner.nextBoolean();
                scanner.nextLine(); // Consumir el salto de línea pendiente

                poliza.setEstado(nuevoEstado);
                encontrado = true;
                System.out.println("Estado de la póliza modificado con éxito.");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ninguna póliza con el número ingresado.");
        }
    }
}
