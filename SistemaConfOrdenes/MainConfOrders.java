package SistemaConfOrdenes;

import java.util.ArrayList;
import java.util.Scanner;

import SistemaPedidos.MainOrderSystem;
import classes.Cliente;
import classes.Direccion;
import classes.Producto;
import classes.Pedido;
import classes.PedidoLocal;
public class MainConfOrders {
    private static MainOrderSystem mainOrderSystem;

    public static void main(String[] args) {
        //Variable to storage the pedidos in arrays        
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Hello World from MainConfOrders!");
        
        
        
        
        //Display menu options to the user for manage the orders
        System.out.println("Bienvenido al sistema de configuración de ordenes");
        System.out.println("1. Editar orden");
        System.out.println("2. Eliminar orden");
        System.out.println("3. Listar ordenes");
        System.out.println("4. Buscar orden");
        System.out.println("5. Salir");

        try (//Create a scanner object to read the user input
        Scanner scanner = new Scanner(System.in)) {
            //Read the user input
            int option = scanner.nextInt();

            //Create a switch to manage the user input
            switch (option) {
                
                case 1:
                        
                    break;
                case 2:
                    System.out.println("Eliminar orden");
                    break;
                case 3:
                    System.out.println("Listar ordenes");
                    break;
                case 4:
                    System.out.println("Buscar orden");
                    break;
                case 5:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
}