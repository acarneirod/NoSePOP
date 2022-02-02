
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acuar
 */
public class NoSePOP {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static Scanner input;
    
    public static void main(String[] args) {
        input = new Scanner(System.in);
        int opcion;
        // Se muestra el menú hasta que se introduzca una opción valida o se salga del programa.
        do {
            System.out.println("0. Mostrar Tabla Empleados.");
            System.out.println("1. Mostrar Tabla Departamentos.");
            System.out.println("2. Introducir empleado.");
            System.out.println("3. Eliminar empleado.");
            System.out.println("4. Mostrar información de Tabla Empleados y Tabla Departamentos.");
            System.out.println("5. Funcionalidad extra.");
            System.out.println("6. Salir.");

            try {
                System.out.println("Elija una opcion: ");
                opcion = Integer.parseInt(input.nextLine());

                if (opcion < 0 || opcion > 6) {
                    System.out.println("ERROR: Opción Inválida...");
                    System.out.print("Pulsa Intro para continuar...");
                    input.nextLine();
                } else {
                    menuOpciones(opcion, input);
                }

            } catch (NumberFormatException nfe) {
                System.out.println("ERROR: Debe introducir solo números...");
                System.out.println("Pulsa Intro para continuar ...");
                input.nextLine();
                opcion = Integer.MIN_VALUE;
            }

        } while (opcion != 6);
        // Se cierra la conexión a la BBDD y la entrada por teclado.
        input.close();
    }

    private static void menuOpciones(int opcion, Scanner entrada){
        switch (opcion) {
            case 0:
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("\nMOSTRANDO TABLA EMPLEADOS ... ");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                break;
            case 1:
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("\nMOSTRANDO TAVLA DEPARTAMENTOS ...");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                break;
            case 2:
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("\nINTRODUCIR EMPLEADO ...");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                break;
            case 3:
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("\nELIMINAR EMPLEADO ...");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                break;
            case 4:
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("\nMOSTRANDO INFORMACIÓN DE LA TABLA EMPLEADOS Y LA TABLA DEPARTAMENTOS");
                System.out.println("-----------------------------------------------------------------------------------------------------");
            case 5:
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("\nFUNCIONALIDAD EXTRA.");
                System.out.println("-----------------------------------------------------------------------------------------------------");
            case 6:
                System.out.println("-----------------------------------------------------------------------------------------------------");
                System.out.println("GRACIAS POR UTILIZAR EL PROGRAMA, BUEN DÍA. VUELVE PRONTO!!!");
                System.out.println("-----------------------------------------------------------------------------------------------------");
                break;
        }
        System.out.println("Pulsa Intro para continuar...");
        entrada.nextLine();
    }

}
