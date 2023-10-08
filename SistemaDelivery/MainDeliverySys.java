package SistemaDelivery;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import SistemaPedidos.MainOrderSystem;
import classes.Direccion;
//import classes.Direccion;
import classes.PedidoExpress;
import classes.Producto;
import classes.RegistroEntidades;
import classes.ServicioExpress;


public class MainDeliverySys {

    public static MainOrderSystem mainOrderSystem = new MainOrderSystem();
    public static ArrayList<PedidoExpress> listaPedidosExpress = new ArrayList<PedidoExpress>();
    public static ArrayList<RegistroEntidades> listaEntidades = new ArrayList<RegistroEntidades>();
    // static Scanner entrada = new Scanner(System.in);

    // // Aquí empieza

    // public static void menuInicial() {
    //     int opcion;
    //     System.out.println("Sistema de Servicios Express");
    //     System.out.println("----------------------------");
    //     System.out.println("1. Registrarse");
    //     System.out.println("2. Iniciar Sesión");
    //     System.out.println("3. Salir");
    //     System.out.println("Digite su opción: ");
    //     opcion = entrada.nextInt();
    //     switch (opcion) {
    //         case 1:
    //             signin();
    //             break;
    //         case 2:
    //             login();
    //             break;
    //         case 3:
    //             try {
    //                 MainMenu.App.main(null);
    //             } catch (Exception e) {
    //                 // TODO Auto-generated catch block
    //                 e.printStackTrace();
    //             }
    //             break;
    //         default:
    //             break;
    //     }
    // }

    // public static void signin() {
    //     String name;
    //     String ced;
    //     String numContact;
    //     String medio;
    //     String placa;
    //     String vehiculo;
    //     entrada.nextLine();
    //     System.out.println("Digite su nombre");
    //     name = entrada.nextLine();
    //     System.out.println("Digite su numero de cedula");
    //     ced = entrada.nextLine();
    //     System.out.println("Digite su numero de telefono");
    //     numContact = entrada.nextLine();
    //     System.out.println("Digite su medio de transporte");
    //     medio = entrada.nextLine();
    //     System.out.println("Digite su numero de placa");
    //     placa = entrada.nextLine();
    //     System.out.println("Digite su tipo de vehiculo");
    //     vehiculo = entrada.nextLine();
    //     RegistroEntidades nuevaEntidad = new RegistroEntidades(name, ced, numContact, medio, placa, vehiculo);
    //     listaEntidades.add(nuevaEntidad);
    //     menuInicial();
    // }

    // public static void login() {
    //     String cedBuscar;
    //     System.out.println("Digite su numero de cedula: ");
    //     entrada.nextLine();
    //     cedBuscar = entrada.nextLine();

    //     for (RegistroEntidades entidad : listaEntidades) {
    //         if (entidad.getNumeroCedula().equals(cedBuscar)) {
    //             iniciarServicioExpress(listaPedidosExpress);
    //         }
    //     }
    //     String resp;
    //     System.out.println("Cedula no encontrada. ¿Desea registrarse? (y/n)");
    //     resp = entrada.next();
    //     if (resp.equals("y")) {
    //         signin();
    //     } else if (resp.equals("n")) {
    //         login();
    //     } else {
    //         System.out.println("Respuesta invalida");
    //         login();
    //     }
    // }

    // public static void iniciarServicioExpress(ArrayList<PedidoExpress> listaPedidosExpress) {
    //     int op;
    //     if (listaPedidosExpress.isEmpty()) {
    //         System.out.println("No hay pedidos express disponibles");
    //         menuInicial();
    //     }

    //     for (PedidoExpress pedido : listaPedidosExpress) {
    //         if (!pedido.isFinalizado()) {
    //             System.out.println("Pedido de " + pedido.getCliente().getNombreCompleto());
    //             System.out.println("Dirección: " + pedido.getDireccionEntrega().getLugarHabita());
    //             ArrayList<Producto> prod = pedido.getProducto();
    //             System.out.println("Productos: ");
    //             for (int i = 0; i < prod.size(); i++) {
    //                 System.out.println(prod.get(i).getDescripcionProducto());
    //             }
    //             System.out.println("Hora de entrega: " + pedido.getHoraEntrega());
    //             System.out.println("----------------------------------");
    //             op = entrada.nextInt();
    //             op = op - 1;
    //             if ((op >= 0) && (op <= listaPedidosExpress.size())) {
    //                 iniciarServicioExpress(listaPedidosExpress); 
    //             } else {
    //                 System.out.println("Opcion invalida");
    //                 iniciarServicioExpress(listaPedidosExpress);
    //             }
    //         }
    //     }



        // // Hilo de lectura del servidor
        // class HiloLecturaServidor implements Runnable {

        //     private ArrayList<PedidoExpress> listaPedidosExpress;

        //     public HiloLecturaServidor(ArrayList<PedidoExpress> listaPedidosExpress) {
        //         this.listaPedidosExpress = listaPedidosExpress;
        //     }

        //     @Override
        //     public void run() {
        //         // Limpiar la lista
        //         listaPedidosExpress.clear();

        //         // Leer los datos del servidor
        //         try {
        //             Socket socket = new Socket("127.0.0.1", 5000);
        //             ObjectInputStream entradaObjeto = new ObjectInputStream(socket.getInputStream());

        //             System.out.println("Surprise!!!");
        //             // Filtrar los datos
        //             ArrayList<PedidoExpress> datosFiltrados = (ArrayList<PedidoExpress>) entradaObjeto.readObject();

        //             System.out.println("Ya se ve el sol");
        //             // Agregar los datos filtrados a la lista
        //             listaPedidosExpress.addAll(datosFiltrados);

        //             System.out.println("Datos recibidos del servidor: ");

        //             socket.close();
        //         } catch (IOException | ClassNotFoundException e) {
        //             e.printStackTrace();
        //         }

        //         // Repetir el proceso continuamente
        //         while (true) {
        //             // Leer los datos del servidor
        //             try {
        //                 Socket socket = new Socket("localhost", 5000);
        //                 ObjectInputStream entradaObjeto = new ObjectInputStream(socket.getInputStream());

        //                 // Filtrar los datos
        //                 ArrayList<PedidoExpress> datosFiltrados = (ArrayList<PedidoExpress>) entradaObjeto.readObject();

        //                 // Agregar los datos filtrados a la lista
        //                 listaPedidosExpress.addAll(datosFiltrados);

        //                 //socket.close();
        //             } catch (IOException | ClassNotFoundException e) {
        //                 e.printStackTrace();
        //             }
        //         }
                
        //     }
        // }


    // public static void entregarPedido(ServicioExpress servicio, PedidoExpress pedido, int posicion) {
    //     String opEntrega;
    //     System.out.println("Digite la letra 'e' cuando haya entregado el pedido.");
    //     opEntrega = entrada.nextLine();
    //     if (opEntrega.equals("e")) {
    //         servicio.setEntregado(true);
    //         pedido.setFinalizado(true);
    //         listaPedidosExpress.remove(posicion);
    //         System.out.println("Producto entregado, volviendo a los pedidos...");
    //         // Enviar la información del servicio al servidor
    //         try {
    //             Socket socket = new Socket("localhost", 5000);
    //             ObjectOutputStream salidaObjeto = new ObjectOutputStream(socket.getOutputStream());

    //             // Enviar el servicio
    //             salidaObjeto.writeObject(servicio);

    //             socket.close();
    //         } catch (IOException e) {
    //             e.printStackTrace();
    //         }
    //         iniciarServicioExpress(listaPedidosExpress);
    //     } else {
    //         System.out.println("Opcion invalida.");
    //         entregarPedido(servicio, pedido, posicion);
    //     }
    // }


    public static void menu(){
        while (true) {
            System.out.println("Menú");
            System.out.println("1. Ver datos");
            System.out.println("2. Pedidos entregados");
            System.out.println("3. Pedidos sin entregar");
            System.out.println("4. Salir");
            int opcion = Integer.parseInt(System.console().readLine());

            switch (opcion) {
                case 1:
                    System.out.println("Datos: ");
                    for (PedidoExpress pedido : listaPedidosExpress) {
                        System.out.println("Pedido de: " + pedido.getCliente().getNombreCompleto());
                        //Print the directions - Provincia, canton, distrito, lugarHabita
                        System.out.println("Dirección: " + pedido.getDireccionEntrega().getLugarHabita() + ", " + pedido.getDireccionEntrega().getDistrito() + ", " + pedido.getDireccionEntrega().getCanton() + ", " + pedido.getDireccionEntrega().getProvincia());
                        
                        System.out.println("\n");
                    }
                    break;
                case 2:
                    System.out.println("Pedidos entregados: ");
                    for (PedidoExpress pedido : listaPedidosExpress) {
                        if (pedido.isFinalizado()) {
                            System.out.println("Pedido de: " + pedido.getCliente().getNombreCompleto());
                        } else {
                            System.out.println("No hay pedidos entregados");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Pedidos sin entregar: ");
                    for (PedidoExpress pedido : listaPedidosExpress) {
                        if (!pedido.isFinalizado()) {
                            System.out.println("Pedido de: " + pedido.getCliente().getNombreCompleto());
                        }
                        else {
                            System.out.println("No hay pedidos sin entregar");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no válida");
            }
        }
    }

    public static void readerExprssData() {

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

                PedidoExpress pedido = (PedidoExpress) objeto;

                //System.out.println("Pedido Recibido: " + pedido.getCliente().getNombreCompleto());

                // Agregar el pedido a la lista
                listaPedidosExpress.add(pedido);                
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
        // Crear el hilo para mostrar el menú
        Thread menu = new Thread(() -> menu());

        // Iniciar el hilo
        menu.start();

        // Iniciar el hilo para leer los datos
        Thread dataReaderThread = new Thread(() -> readerExprssData());

        // Iniciar el hilo para leer los datos en segundo plano
        dataReaderThread.start();
    }
}