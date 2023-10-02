package SistemaPedidos;

import classes.Cliente;
import classes.Direccion;
import classes.Pedido;
import classes.PedidoExpress;
import classes.PedidoLocal;
import classes.PedidoParaLlevar;
import classes.Producto;
import java.util.ArrayList;
import java.util.Scanner;


public class MainOrderSystem {
    public static ArrayList<PedidoLocal>  pedidosLocales = new ArrayList<PedidoLocal>();
    public static ArrayList<PedidoParaLlevar> pedidosParaLlevars = new ArrayList<PedidoParaLlevar>();
    public static ArrayList<PedidoExpress> pedidosExpresses = new ArrayList<PedidoExpress>();
        
            
    
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        pedidosParaLlevars = new ArrayList<PedidoParaLlevar>();

        System.out.println("Crear orden");
                    // Set the value of direccion
                    Scanner scanner = new Scanner(System.in);
                    
                    System.out.println("Ingrese la provincia");
                    
                    String provincia = scanner.nextLine();
                    System.out.println("Ingrese el cantón");
                    String canton = scanner.nextLine();
                    System.out.println("Ingrese el distrito");
                    String distrito = scanner.nextLine();
                    System.out.println("Ingrese el lugar de habitación");
                    String lugarHabita = scanner.nextLine();

                    classes.Direccion direccion = new Direccion(provincia, canton, distrito, lugarHabita);
                    
                    // Set the value of cliente
                    System.out.println("Ingrese el nombre");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el número de contacto");
                    String numContacto = scanner.nextLine();
                    System.out.println("Ingrese el genero");
                    String genero = scanner.nextLine();
                    System.out.println("Ingrese la edad");
                    String edad = scanner.nextLine();

                    classes.Cliente cliente = new Cliente(nombre, direccion, numContacto, genero, edad);

                    // Set the value of empleado
                    System.out.println("Ingrese el nombre del empleado");
                    String nombreEmpleado = scanner.nextLine();
                    classes.Empleado empleado = new classes.Empleado(nombreEmpleado);

                

                    //Select the type of pedido to create
                    System.out.println("Ingrese el tipo de pedido");
                    System.out.println("1. Pedido a domicilio");
                    System.out.println("2. Pedido para llevar");
                    System.out.println("3. Pedido en el restaurante");
                    int tipoPedido = scanner.nextInt();
                    String validar;
                    switch (tipoPedido) {
                        case 1:
                            System.out.println("Pedido a domicilio");
                            System.out.println("Ingrese la hora del pedido");
                            String horaPedidoD = scanner.nextLine();
                            Direccion direccionEntrega = cliente.getDireccion();
                            System.out.println("Ingrese la hora de entrega");
                            String horaEntrega = scanner.nextLine();
                            System.out.println("Ingrese si el pedido está entregado");
                            boolean entregado = scanner.nextBoolean();
                            
                            do {
                                // Set the value of productos
                                
                                System.out.println("Ingrese el tipo de categoria");
                                String tipoCategoria = scanner.nextLine();
                                System.out.println("Ingrese el descuento de la categoria");
                                float descuentoCategoria = scanner.nextFloat();
                                System.out.println("Ingrese la descripción del producto");
                                String descripcionProducto = scanner.nextLine();
                                System.out.println("Ingrese el costo individual del producto");
                                float costoIndividualProducto = scanner.nextFloat();
                                System.out.println("Ingrese el tiempo de preparación");
                                String tiempoPreparacion = scanner.nextLine();
                                Producto producto = new Producto(tipoCategoria, descuentoCategoria, descripcionProducto, costoIndividualProducto, tiempoPreparacion);
                                classes.PedidoExpress pedidoExpress = new classes.PedidoExpress(producto, horaPedidoD, entregado, direccionEntrega, horaEntrega, cliente, empleado);
                                pedidoExpress.addProducto(producto);
                                System.out.println("Ingrese (y) si desea agregar un producto"); 
                                //Get string input in option variable
                                validar = scanner.nextLine();
                                if (validar != "y") {
                                pedidosExpresses.add(pedidoExpress);
                                }
                                
                                
                            } while (validar.equals("y"));
                            
                            
                            break;
                        case 2:
                            System.out.println("Pedido para llevar");
                            System.out.println("Ingrese la hora del pedido");
                            String horaPedidoL = scanner.nextLine();
                            System.out.println("Ingrese la fecha del pedido");
                            String fechaPedidoL = scanner.nextLine();

                            do {
                                // Set the value of productos
                                
                                System.out.println("Ingrese el tipo de categoria");
                                String tipoCategoria = scanner.nextLine();
                                System.out.println("Ingrese el descuento de la categoria");
                                float descuentoCategoria = scanner.nextFloat();
                                System.out.println("Ingrese la descripción del producto");
                                String descripcionProducto = scanner.nextLine();
                                System.out.println("Ingrese el costo individual del producto");
                                float costoIndividualProducto = scanner.nextFloat();
                                System.out.println("Ingrese el tiempo de preparación");
                                String tiempoPreparacion = scanner.nextLine();
                                Producto producto = new Producto(tipoCategoria, descuentoCategoria, descripcionProducto, costoIndividualProducto, tiempoPreparacion);
                                classes.PedidoParaLlevar pedidoParaLlevar = new classes.PedidoParaLlevar(producto, horaPedidoL, false, horaPedidoL, fechaPedidoL, cliente, empleado);
                                pedidoParaLlevar.addProducto(producto);
                                System.out.println("Ingrese (y) si desea agregar un producto"); 
                                //Get string input in option variable
                                validar = scanner.nextLine();
                                if (validar != "y") {
                                pedidosParaLlevars.add(pedidoParaLlevar);
                                }
                                
                            } while (validar.equals("y"));
                            
                            break;
                        case 3:
                            System.out.println("Pedido en el restaurante");
                            
                            System.out.println("Ingrese la hora del pedido");
                            String horaPedido = scanner.nextLine();
                            System.out.println("Ingrese si el pedido está finalizado");
                            boolean finalizado = scanner.nextBoolean();
                            System.out.println("Ingrese el número de mesa");
                            byte numeroMesa = scanner.nextByte();
                            do {
                                // Set the value of productos
                                
                                System.out.println("Ingrese el tipo de categoria");
                                String tipoCategoria = scanner.nextLine();
                                System.out.println("Ingrese el descuento de la categoria");
                                float descuentoCategoria = scanner.nextFloat();
                                System.out.println("Ingrese la descripción del producto");
                                String descripcionProducto = scanner.nextLine();
                                System.out.println("Ingrese el costo individual del producto");
                                float costoIndividualProducto = scanner.nextFloat();
                                System.out.println("Ingrese el tiempo de preparación");
                                String tiempoPreparacion = scanner.nextLine();
                                Producto producto = new Producto(tipoCategoria, descuentoCategoria, descripcionProducto, costoIndividualProducto, tiempoPreparacion);
                                classes.PedidoLocal pedidoLocal = new PedidoLocal(producto, horaPedido, finalizado, numeroMesa, cliente, empleado);
                                pedidoLocal.addProducto(producto);
                                System.out.println("Ingrese (y) si desea agregar un producto"); 
                                //Get string input in option variable
                                validar = scanner.nextLine();
                                if (validar != "y") {
                                pedidosLocales.add(pedidoLocal);
                                }
                                
                            } while (validar.equals("y"));
                            // incorporate the products to the order
                            

                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
        
    }
    
    //Get the value of pedidosLocales
    public static ArrayList<PedidoLocal> getPedidosLocales() {
        return pedidosLocales;
    }

    //Get the value of pedidosParaLlevars
    public static ArrayList<PedidoParaLlevar> getPedidosParaLlevars() {
        return pedidosParaLlevars;
    }

    //Get the value of pedidosExpresses
    public static ArrayList<PedidoExpress> getPedidosExpresses() {
        return pedidosExpresses;
    }
    
    
}