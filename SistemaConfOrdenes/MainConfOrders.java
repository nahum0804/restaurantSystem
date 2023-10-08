package SistemaConfOrdenes;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import classes.PedidoExpress;
import classes.PedidoLocal;
import classes.PedidoParaLlevar;
import classes.Producto;

public class MainConfOrders {

    static ArrayList<PedidoExpress> pedidosExpress = new ArrayList<>();
    static ArrayList<PedidoParaLlevar> pedidosParaLlevar = new ArrayList<>();
    static ArrayList<PedidoLocal> pedidosLocals = new ArrayList<>();

    public static void menu() {
    //Variable to storage the pedidos in arrays        
    System.out.print("\033[H\033[2J");
    System.out.flush();
    //Create a scanner object to read the user input
    Scanner scanner = new Scanner(System.in);

    //Create a lists to storage the pedidos


    while(true){
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
                //System.out.println("Pedidos express");
                //Create a new instance of the MainOrderSystem class
                
                //Show the options to do with the pedido
                System.out.println("Digite el numero de la opcion que desea realizar");
                System.out.println("1. Ver pedidos");
                System.out.println("2. Marcar pedido como finalizado");
                System.out.println("3. Ver estado de las ordenes en general");
                //Read the user input
                int optionPedido = scanner.nextInt();
                scanner.nextLine();
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
                                System.out.println("-------------------------------------------------");
                                System.out.println("Pedido de " + pedidoExpress.getCliente().getNombreCompleto());
                                //save in a variable the array of productos
                                ArrayList<Producto> productosExpress = pedidoExpress.getProducto();
                                //iterate the array of productos
                                for (Producto producto : productosExpress) {
                                    //display the productos
                                    if(producto != null){
                                    System.out.println("Descripcion del producto: " + producto.getDescripcionProducto());
                                    System.out.println("Precio del producto: " + producto.getCostoIndividualProducto());
                                    System.out.println("Categoria del producto: " + producto.getTipoCategoria());
                                    System.out.println("\n");
                                    }
                                }
                                System.out.println("Hora del pedido: " + pedidoExpress.getHoraPedido());
                                System.out.println("Hora de entrega: " + pedidoExpress.getHoraEntrega());
                                System.out.println("Dirección de entrega: " + pedidoExpress.getDireccionEntrega());
                                System.out.println("Estado de entrega: " + pedidoExpress.isEntregado());
                                System.out.println("Estado de finalizado: " + pedidoExpress.isFinalizado());
                                System.out.println("-------------------------------------------------");

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
                                scanner.nextLine();
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
                //System.out.println("Pedidos para llevar");
                //Create a new instance of the MainOrderSystem class

                
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
                                System.out.println("-------------------------------------------------");
                                System.out.println("Pedido de " + pedidoParaLlevar.getCliente().getNombreCompleto());
                                //save in a variable the array of productos
                                ArrayList<Producto> productosParaLlevar = pedidoParaLlevar.getProducto();
                                //iterate the array of productos
                                for (Producto producto : productosParaLlevar) {
                                    //display the productos
                                    if (producto != null) {
                                        System.out.println("Descripcion del producto: " + producto.getDescripcionProducto());
                                        System.out.println("Precio del producto: " + producto.getCostoIndividualProducto());
                                        System.out.println("Categoria del producto: " + producto.getTipoCategoria());
                                        System.out.println("\n");
                                    }
                                }
                                System.out.println("Hora del pedido: " + pedidoParaLlevar.getHoraPedido());
                                System.out.println("Estado de finalizado: " + pedidoParaLlevar.isFinalizado());
                                System.out.println("Hora de entrega: " + pedidoParaLlevar.getHora());
                                System.out.println("Fecha de entrega: " + pedidoParaLlevar.getFecha());
                                System.out.println("-------------------------------------------------");
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
                //System.out.println("Pedidos para el restaurante");
                //Create a new instance of the MainOrderSystem class
                //Call the method to get the pedidos
                
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
                                System.out.println("-------------------------------------------------");
                                System.out.println("Pedido de " + pedidoLocal.getCliente().getNombreCompleto());
                                //save in a variable the array of productos
                                ArrayList<Producto> productosLocal = pedidoLocal.getProducto();
                                //display the productos
                                for (Producto producto : productosLocal) {
                                    //display the productos
                                    if (producto != null) {
                                        System.out.println("Descripcion del producto: " + producto.getDescripcionProducto());
                                        System.out.println("Precio del producto: " + producto.getCostoIndividualProducto());
                                        System.out.println("Categoria del producto: " + producto.getTipoCategoria());
                                        System.out.println("\n");
                                    }
                                }

                                System.out.println("Hora del pedido: " + pedidoLocal.getHoraPedido());
                                System.out.println("Estado de finalizado: " + pedidoLocal.isFinalizado());
                                System.out.println("Numero de mesa: " + pedidoLocal.getNumeroMesa());
                                System.out.println("-------------------------------------------------");

                            }
                        }
                        //Go to the main menu
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
                                scanner.nextLine();
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
                        //Go to the main menu
                        break;
                    case 3:
                        //iterate the pedidos to display the status with no import the employee
                        for (PedidoLocal pedidoLocal : pedidosLocals) {
                            //display the status of finished
                            System.out.println("El pedido del cliente " + pedidoLocal.getCliente().getNombreCompleto() + " tiene un estado de finalizado de " + pedidoLocal.isFinalizado());
                        }
                        //Go to the main menu
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                    }
            case 4:
                return;
        }   
    }
    }


    public static void readData(){
          ServerSocket serverSocket = null;
        Socket clientSocket = null;
        ObjectInputStream entradaObjeto = null;

        try {
            serverSocket = new ServerSocket(5001);
            //System.out.println("Servidor esperando conexiones en el puerto 127.0.0.1");

            while (true) {
                clientSocket = serverSocket.accept();
                //System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());
                entradaObjeto = new ObjectInputStream(clientSocket.getInputStream());

                //System.out.println("Esperando objeto...");

                Object objeto = entradaObjeto.readObject();


                if(objeto instanceof PedidoExpress){
                    PedidoExpress pedido = (PedidoExpress) objeto;
                    pedidosExpress.add(pedido); 
                }
                else if(objeto instanceof PedidoParaLlevar){
                    PedidoParaLlevar pedido = (PedidoParaLlevar) objeto;
                    pedidosParaLlevar.add(pedido);
                }
                else if(objeto instanceof PedidoLocal){
                    PedidoLocal pedido = (PedidoLocal) objeto;
                    pedidosLocals.add(pedido);
                }
                else{
                    System.out.println("No se reconoce el objeto");
                }
                               
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (entradaObjeto != null) {
                    entradaObjeto.close();
                }
                if (clientSocket != null) {
                    clientSocket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        Thread menu = new Thread(() -> menu());
        menu.start();

        Thread readData = new Thread(() -> readData());
        readData.start();
    }

}