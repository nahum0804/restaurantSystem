import java.util.Scanner;

import classes.Cliente;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //Call the others main methods from the other packages
        // SistemaConfOrdenes.MainConfOrders.main(args);
        // SistemaDelivery.MainDeliverySys.main(args);
        // SistemaPedidos.MainOrderSystem.main(args);

        //Display menu options to the user for choose the service type
        System.out.println("Bienvenido al sistema");
        System.out.println("1. Servicio express");
        System.out.println("2. Servicio de pedidos");
        System.out.println("3. Sistema de confección de ordenes");

        //Create a scanner object to read the user input
        Scanner scanner = new Scanner(System.in);
        //Read the user input
        int option = scanner.nextInt();

        //Create a switch to manage the user input
        switch (option) {
            case 1:
                System.out.println("Servicio express");
                SistemaDelivery.MainDeliverySys.main(args);
                break;
            case 2:
                //Execute the MainConfOrders class
                System.out.println("Servicio de pedidos");
                SistemaPedidos.MainOrderSystem.main(args);

                break;
            case 3:
                System.out.println("Sisteme de confección de ordenes");
                SistemaConfOrdenes.MainConfOrders.main(args);
                break;
        }
    }
}