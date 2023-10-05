package SistemaDelivery;

import java.util.ArrayList;
import java.util.Scanner;

import SistemaPedidos.MainOrderSystem;
import classes.Direccion;
import classes.PedidoExpress;
import classes.Producto;
import classes.RegistroEntidades;
import classes.ServicioExpress;

public class MainDeliverySys {
    public static MainOrderSystem mainOrderSystem = new MainOrderSystem();
    public static ArrayList<PedidoExpress> listaPedidosExpress = mainOrderSystem.getPedidosExpresses();
    public static ArrayList<RegistroEntidades> listaEntidades = new ArrayList<RegistroEntidades>();
    static Scanner entrada = new Scanner(System.in);

   
    // Aqui empieza
    public static void menuInicial() {
        int opcion;
        System.out.println("Sistema de Servicios Express");
        System.out.println("----------------------------");
        System.out.println("1. Registrarse");
        System.out.println("2. Iniciar Sesión");
        System.out.println("3. Salir");
        System.out.println("Digite su opción: ");
        opcion = entrada.nextInt();
        switch (opcion) {
            case 1:
                signin();
                break;
            case 2:
                login();
                break;
            case 3:
                try {
                    MainMenu.App.main(null);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    public static void signin() {
        String name;
        String ced;
        String numContact;
        String medio;
        String placa;
        String vehiculo;
        entrada.nextLine();
        System.out.println("Digite su nombre");
        name = entrada.nextLine();
        System.out.println("Digite su numero de cedula");
        ced = entrada.nextLine();
        System.out.println("Digite su numero de telefono");
        numContact = entrada.nextLine();
        System.out.println("Digite su medio de transporte");
        medio = entrada.nextLine();
        System.out.println("Digite su numero de placa");
        placa = entrada.nextLine();
        System.out.println("Digite su tipo de vehiculo");
        vehiculo = entrada.nextLine();
        RegistroEntidades nuevaEntidad = new RegistroEntidades(name, ced, numContact, medio, placa, vehiculo);
        listaEntidades.add(nuevaEntidad);
        menuInicial();
    }

    public static void login() {
        String cedBuscar;
        System.out.println("Digite su numero de cedula: ");
        entrada.nextLine();
        cedBuscar = entrada.nextLine();
      
        for (RegistroEntidades entidad : listaEntidades) {
            
            if (entidad.getNumeroCedula().equals(cedBuscar)) {
                verPedidos();
            }
        }
        String resp;
        System.out.println("Cedula no encontrada. ¿Desea registrarse? (y/n)");
        resp = entrada.next();
        if (resp.equals("y")) {
            signin();
        } else if (resp.equals("n")) {
            login();
        } else {
            System.out.println("Respuesta invalida");
            login();
        }
    }

    public static void verPedidos() {
        int c = 1;
        int op;
        if (listaPedidosExpress.isEmpty()) {
            System.out.println("No hay pedidos express");
            menuInicial();
        }
        for (PedidoExpress pedido : listaPedidosExpress) {
            if (pedido.isFinalizado()) {
                System.out.println("Pedido #" + c + ":");
                System.out.println("Dirección: " + pedido.getDireccionEntrega().getLugarHabita());
                ArrayList<Producto> prod = pedido.getProducto();
                System.out.println("Productos: ");
                for (int i = 0; i < prod.size(); i++) {
                    System.out.println(prod.get(i).getDescripcionProducto());
                }
                System.out.println("Hora de entrega: " + pedido.getHoraEntrega());
                System.out.println("----------------------------------");
                c++;
            }
        }
        //Show the list of orders in a for of listaPedidosExpress
        for (PedidoExpress pedido : listaPedidosExpress) {
            if (!pedido.isFinalizado()) {
                System.out.println("Pedido #" + c + ":");
                System.out.println("Dirección: " + pedido.getDireccionEntrega().getLugarHabita());
                ArrayList<Producto> prod = pedido.getProducto();
                System.out.println("Productos: ");
                for (int i = 0; i < prod.size(); i++) {
                    System.out.println(prod.get(i).getDescripcionProducto());
                }
                System.out.println("Hora de entrega: " + pedido.getHoraEntrega());
                System.out.println("----------------------------------");
                c++;
            }
        }
        

        System.out.print("Elija un pedido: ");
        op = entrada.nextInt();
        op = op - 1;
        if ((op >= 0) && (op <= listaPedidosExpress.size())) {
            iniciarServicioExpress(listaPedidosExpress.get(op), op);
        } else {
            System.out.println("Opcion invalida");
            verPedidos();
        }
    }

    public static void iniciarServicioExpress(PedidoExpress pedido, int posicion) {
        String op;
        ServicioExpress servicio = new ServicioExpress("En proceso de fabricacion", false, pedido.getHoraEntrega());
        System.out.println("Usted a aceptado el servicio express hacia la siguiente dirección: ");
        System.out.println(pedido.getDireccionEntrega().getDistrito());
        System.out.println(pedido.getDireccionEntrega().getLugarHabita());
        System.out.print("Hora de llegada estimada: ");
        System.out.println(pedido.getHoraEntrega());
        System.out.println("-------------------------------");
        System.out.println(
                "Digite la letra 'r' cuando haya recogido el pedido o digite la letra 'c' para cancelar el servicio.");
        entrada.nextLine();        
        op = entrada.nextLine();
        if (op.equals("r")) {
            servicio.setRecojido("true");
            entregarPedido(servicio, pedido, posicion);
        } else if (op.equals("c")) {
            System.out.println("Saliendo...");
            verPedidos();
        } else {
            System.out.println("Opcion invalida.");
            iniciarServicioExpress(pedido, posicion);
        }
    }

    public static void entregarPedido(ServicioExpress servicio, PedidoExpress pedido, int posicion) {
        String opEntrega;
        System.out.println("Digite la letra 'e' cuando haya entregado el pedido.");
        opEntrega = entrada.nextLine();
        if (opEntrega.equals("e")) {
            servicio.setEntregado(true);
            pedido.setFinalizado(true);
            listaPedidosExpress.remove(posicion);
            System.out.println("Producto entregado, volviendo a los pedidos...");
            verPedidos();
        } else {
            System.out.println("Opcion invalida.");
            entregarPedido(servicio, pedido, posicion);
        }
    }

    public static void main(String[] args) {
        // Datos de prueba
        menuInicial();
    }

}