package SistemaConfOrdenes;

import java.util.ArrayList;
import java.util.Scanner;

import SistemaPedidos.MainOrderSystem;
import classes.PedidoExpress;
import classes.PedidoLocal;
import classes.PedidoParaLlevar;

public class MainConfOrders {
    private static MainOrderSystem mainOrderSystem;

    public static void main(String[] args) {
        //Variable to storage the pedidos in arrays        
        System.out.print("\033[H\033[2J");
        System.out.flush();
        //Create a scanner object to read the user input
        Scanner scanner = new Scanner(System.in);
        
        
        
        
        
        //Display menu options to the user for manage the orders
        System.out.println("Bienvenido al sistema de configuración de ordenes");
        System.out.println("Digite el nombre de empleado en turno:");
        String nombreEmpleado = scanner.nextLine();
        System.out.println("Bienvenido, digite el numero del tipo de orden que desea revisar"); 
        System.out.println("1. Pedidos express");
        System.out.println("2. Pedidos Para llevar");
        System.out.println("3. Pedidos para el restaurante");
        System.out.println("4. Salir");

        //Read the user input
        int option = scanner.nextInt();

        //Create a switch to manage the user input

        switch (option) {
            case 1:
                System.out.println("Pedidos express");
                //Create a new instance of the MainOrderSystem class
                //Call the method to get the pedidos
                ArrayList<PedidoExpress> pedidosExpress = mainOrderSystem.getPedidosExpresses();
                
                //Show the options to do with the pedido
                System.out.println("Digite el numero de la opcion que desea realizar");
                System.out.println("1. Ver pedidos");
                System.out.println("2. Marcar pedido como finalizado");
                System.out.println("3. Ver estado de las ordenes en general");
                //Read the user input
                int optionPedido = scanner.nextInt();
                //Create a switch to manage the user input
                switch (optionPedido) {
                    case 1:
                        //Call the method to display the pedidos
                        //Iterate the pedidos
                        for (PedidoExpress pedidoExpress : pedidosExpress) {
                            //obtain the name of the employee
                            String nombreEmpleadoPedido = pedidoExpress.getEmpleado().getNombreCompleto();
                            //Verify if the name of the employee is the same that the user input
                            if (nombreEmpleadoPedido.equals(nombreEmpleado)) {
                                //display the pedido
                                System.out.println(pedidoExpress);
                            }
                        }
                        break;
                    case 2:
                        //iterate the pedidos
                        for (PedidoExpress pedidoExpress : pedidosExpress) {
                            //obtain the name of the employee
                            String nombreEmpleadoPedido = pedidoExpress.getEmpleado().getNombreCompleto();
                            //Verify if the name of the employee is the same that the user input
                            if (nombreEmpleadoPedido.equals(nombreEmpleado)) {
                                //display the pedido
                                System.out.println(pedidoExpress);
                                //Validate if the employee want to mark the pedido as finished
                                System.out.println("¿Desea marcar el pedido como finalizado?");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                //Read the user input
                                int optionMark = scanner.nextInt();
                                //Create a switch to manage the user input
                                switch (optionMark) {
                                    case 1:
                                        //Call the method to mark the pedido as finished
                                        pedidoExpress.setFinalizado(true);
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                        break;
                                }

                                
                            }
                        }
                        break;
                    case 3:
                        //iterate the pedidos to display the status with no import the employee
                        for (PedidoExpress pedidoExpress : pedidosExpress) {
                            //display the status of finished
                            System.out.println("El pedido del cliente " + pedidoExpress.getCliente().getNombreCompleto() + " tiene un estado de finalizado de " + pedidoExpress.isFinalizado());
                        }


                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;

                }
                
               
                break;
            //do the same for the other options
            case 2:
                System.out.println("Pedidos para llevar");
                //Create a new instance of the MainOrderSystem class
                //Call the method to get the pedidos
                ArrayList<PedidoParaLlevar> pedidosParaLlevar = mainOrderSystem.getPedidosParaLlevars();
                
                //Show the options to do with the pedido
                System.out.println("Digite el numero de la opcion que desea realizar");
                System.out.println("1. Ver pedidos");
                System.out.println("2. Marcar pedido como finalizado");
                System.out.println("3. Ver estado de las ordenes en general");
                //Read the user input
                int optionPedidoParaLlevar = scanner.nextInt();
                //Create a switch to manage the user input
                switch (optionPedidoParaLlevar) {
                    case 1:
                        //Call the method to display the pedidos
                        //Iterate the pedidos
                        for (PedidoParaLlevar pedidoParaLlevar : pedidosParaLlevar) {
                            //obtain the name of the employee
                            String nombreEmpleadoPedido = pedidoParaLlevar.getEmpleado().getNombreCompleto();
                            //Verify if the name of the employee is the same that the user input
                            if (nombreEmpleadoPedido.equals(nombreEmpleado)) {
                                //display the pedido
                                System.out.println(pedidoParaLlevar);
                            }
                        }
                        break;
                    case 2:
                        //iterate the pedidos
                        for (PedidoParaLlevar pedidoParaLlevar : pedidosParaLlevar) {
                            //obtain the name of the employee
                            String nombreEmpleadoPedido = pedidoParaLlevar.getEmpleado().getNombreCompleto();
                            //Verify if the name of the employee is the same that the user input
                            if (nombreEmpleadoPedido.equals(nombreEmpleado)) {
                                //display the pedido
                                System.out.println(pedidoParaLlevar);
                                //Validate if the employee want to mark the pedido as finished
                                System.out.println("¿Desea marcar el pedido como finalizado?");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                //Read the user input
                                int optionMark = scanner.nextInt();
                                //Create a switch to manage the user input
                                switch (optionMark) {
                                    case 1:
                                        //Call the method to mark the pedido as finished
                                        pedidoParaLlevar.setFinalizado(true);
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                        break;
                                    }
                            }
                        }
                    case 3:
                        //iterate the pedidos to display the status with no import the employee
                        for (PedidoParaLlevar pedidoParaLlevar : pedidosParaLlevar) {
                            //display the status of finished
                            System.out.println("El pedido del cliente " + pedidoParaLlevar.getCliente().getNombreCompleto() + " tiene un estado de finalizado de " + pedidoParaLlevar.isFinalizado());
                        }
                        break;    
                    default:
                    System.out.println("Opción no válida");
                    break;
            
                


            
        
            }
            case 3:
                System.out.println("Pedidos para el restaurante");
                //Create a new instance of the MainOrderSystem class
                //Call the method to get the pedidos
                ArrayList<PedidoLocal> pedidosLocals = mainOrderSystem.getPedidosLocales();
                
                //Show the options to do with the pedido
                System.out.println("Digite el numero de la opcion que desea realizar");
                System.out.println("1. Ver pedidos");
                System.out.println("2. Marcar pedido como finalizado");
                System.out.println("3. Ver estado de las ordenes en general");
                System.out.println("4. Retroceder");
                //Read the user input
                int optionPedidoLocal = scanner.nextInt();
                //Create a switch to manage the user input
                switch (optionPedidoLocal) {
                    case 1:
                        //Call the method to display the pedidos
                        //Iterate the pedidos
                        for (PedidoLocal pedidoLocal : pedidosLocals) {
                            //obtain the name of the employee
                            String nombreEmpleadoPedido = pedidoLocal.getEmpleado().getNombreCompleto();
                            //Verify if the name of the employee is the same that the user input
                            if (nombreEmpleadoPedido.equals(nombreEmpleado)) {
                                //display the pedido
                                System.out.println(pedidoLocal);
                            }
                        }
                        break;
                    case 2:
                        //iterate the pedidos
                        for (PedidoLocal pedidoLocal : pedidosLocals) {
                            //obtain the name of the employee
                            String nombreEmpleadoPedido = pedidoLocal.getEmpleado().getNombreCompleto();
                            //Verify if the name of the employee is the same that the user input
                            if (nombreEmpleadoPedido.equals(nombreEmpleado)) {
                                //display the pedido
                                System.out.println(pedidoLocal);
                                //Validate if the employee want to mark the pedido as finished
                                System.out.println("¿Desea marcar el pedido como finalizado?");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                //Read the user input
                                int optionMark = scanner.nextInt();
                                //Create a switch to manage the user input
                                switch (optionMark) {
                                    case 1:
                                        //Call the method to mark the pedido as finished
                                        pedidoLocal.setFinalizado(true);
                                        break;
                                    case 2:
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                }
                            }
                        }
                    case 3:
                        //iterate the pedidos to display the status with no import the employee
                        for (PedidoLocal pedidoLocal : pedidosLocals) {
                            //display the status of finished
                            System.out.println("El pedido del cliente " + pedidoLocal.getCliente().getNombreCompleto() + " tiene un estado de finalizado de " + pedidoLocal.isFinalizado());
                        }
                        break;
                    case 4:
                        try {
                    MainMenu.App.main(args);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                        break;
                    default:
                        System.out.println("Opción no válida");
                        SistemaConfOrdenes.MainConfOrders.main(args);

                    }
            case 4:
                    SistemaPedidos.MainOrderSystem.main(args);

        }
        
    }
}