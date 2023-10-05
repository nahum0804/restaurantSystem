package SistemaPedidos;
//Import the classes
import classes.Cliente;
import classes.Direccion;
import classes.PedidoExpress;
import classes.PedidoLocal;
import classes.PedidoParaLlevar;
import classes.Producto;
import MainMenu.App;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class MainOrderSystem {
    //Variable to storage the pedidos in arrays
    public static ArrayList<PedidoLocal>  pedidosLocales = new ArrayList<PedidoLocal>();
    public static ArrayList<PedidoParaLlevar> pedidosParaLlevars = new ArrayList<PedidoParaLlevar>();
    public static ArrayList<PedidoExpress> pedidosExpresses = new ArrayList<PedidoExpress>();
        
            
    
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        

        pedidosParaLlevars = new ArrayList<PedidoParaLlevar>();
        //make array of products to have in the menu of the restaurant with this structure (String tipoCategoria, float descuentoCategoria, String descripcionProducto, float costoIndividualProducto, String tiempoPreparacion)
        //add more products and diferent categories  bebidas, pastas, a la carta, menú infantil, postres, etc.

        ArrayList<Producto> productos = new ArrayList<Producto>();
        Producto producto1 = new Producto("Bebida", 0, "Coca Cola", 1500, "00:00:30");
        Producto producto2 = new Producto("Bebida", 0, "Fanta", 1500, "00:00:30");
        Producto producto3 = new Producto("Bebida", 0, "Sprite", 1500, "00:00:30");
        Producto producto4 = new Producto("Bebida", 0, "Agua", 1000, "00:00:30");
        Producto producto5 = new Producto("Bebida", 0, "Jugo de naranja", 1200, "00:00:30");
        Producto producto6 = new Producto("Bebida", 0, "Jugo de piña", 800, "00:00:30");
        Producto producto7 = new Producto("Bebida", 0, "Jugo de manzana", 500, "00:00:30");
        Producto producto8 = new Producto("pastas", 10, "Spaguetti", 2500, "00:20:00");
        Producto producto9 = new Producto("pastas", 10, "Fetuccini", 3000, "00:25:00");
        Producto producto10 = new Producto("pastas", 10, "Ravioli", 2000, "00:15:00");
        Producto producto11 = new Producto("pastas", 10, "Tallarines", 2500, "00:20:00");
        Producto producto12 = new Producto("pastas", 10, "Lasaña", 3500, "00:30:00");
        Producto producto13 = new Producto("a la carta", 15, "Pizza", 4000, "00:30:00");
        Producto producto14 = new Producto("a la carta", 15, "Hamburguesa", 3500, "00:10:00");
        Producto producto15 = new Producto("a la carta", 15, "Sandwich", 3000, "00:10:00");
        Producto producto16 = new Producto("a la carta", 15, "Papas fritas", 2000, "00:10:00");
        Producto producto17 = new Producto("a la carta", 15, "Alitas de pollo", 3000, "00:15:00");
        Producto producto18 = new Producto("menu infantil", 20, "salchipapas", 1500, "00:10:00");
        Producto producto19 = new Producto("menu infantil", 20, "hamburguesa", 2000, "00:10:00");
        Producto producto20 = new Producto("menu infantil", 20, "pizza", 2500, "00:10:00");
        Producto producto21 = new Producto("menu infantil", 20, "hot dog", 1500, "00:10:00");
        Producto producto22 = new Producto("menu infantil", 20, "nuggets", 2000, "00:10:00");
        Producto producto23 = new Producto("postres", 25, "Helado", 1000, "00:05:00");
        Producto producto24 = new Producto("postres", 25, "Torta", 1500, "00:05:00");
        Producto producto25 = new Producto("postres", 25, "Gelatina", 500, "00:05:00");
        Producto producto26 = new Producto("postres", 25, "Flan", 500, "00:05:00");
        Producto producto27 = new Producto("postres", 25, "Cheesecake", 2000, "00:05:00");
        Producto producto28 = new Producto("postres", 25, "Brownie", 1500, "00:05:00");
        Producto producto29 = new Producto("postres", 25, "Cupcake", 1000, "00:05:00");
        //add the products to the array
        productos.add(producto1);  
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);                               
        productos.add(producto5);
        productos.add(producto6);
        productos.add(producto7);
        productos.add(producto8);
        productos.add(producto9);
        productos.add(producto10);
        productos.add(producto11);
        productos.add(producto12);
        productos.add(producto13);
        productos.add(producto14);
        productos.add(producto15);
        productos.add(producto16);
        productos.add(producto17);
        productos.add(producto18);
        productos.add(producto19);
        productos.add(producto20);
        productos.add(producto21);
        productos.add(producto22);
        productos.add(producto23);
        productos.add(producto24);
        productos.add(producto25);
        productos.add(producto26);
        productos.add(producto27);
        productos.add(producto28);
        productos.add(producto29);



        //Direccions user data


        System.out.println("Crear orden");
        System.out.println("\n");

        Scanner scanner = new Scanner(System.in);

        classes.Cliente cliente = addCliente();
        ArrayList<Direccion> tmpDirecciones = cliente.getDireccion();
        Direccion direccionDeEntrega = new Direccion(null, null, null, null);

        // Set the value of empleado
        System.out.println("Ingrese el nombre del empleado");
        String nombreEmpleado = scanner.nextLine();
        classes.Empleado empleado = new classes.Empleado(nombreEmpleado);
        scanner.nextLine();
         String horaPedidoD = obtenerFechaHoraActual();
                String[] parts = horaPedidoD.split(" ");
                String fechaPedidoD = parts[0];
                System.out.println("Fecha de solicitud del pedido:" + fechaPedidoD);
                String horaPedidoGetted = parts[1];
                System.out.println("Hora de solicitud del pedido:" + horaPedidoGetted);

                
                System.out.println("Ingrese si el pedido está entregado (Y/N):");
                String entregadoString = scanner.nextLine();
                boolean entregado;
                if(entregadoString.equals("Y") || entregadoString.equals("y")){
                    entregado = true;
                }else{
                    entregado = false;
                }
                 //print the menu of products with the name of the product and the price and the porcentage of discount
                    System.out.println("Menú de productos");
                    for (int i = 0; i < productos.size(); i++) {
                        System.out.println("Producto " + (i+1) + ": " + productos.get(i).getDescripcionProducto() + " Precio: " + productos.get(i).getCostoIndividualProducto() + " Descuento: " + productos.get(i).getDescuentoCategoria() + "%");
                    }

        //Select the type of pedido to create
        System.out.println("Ingrese el tipo de pedido:");
        System.out.println("\n");
        System.out.println("1. Pedido a domicilio");
        System.out.println("2. Pedido para llevar");
        System.out.println("3. Pedido en el restaurante");
        System.out.println("4. Salir");
        System.out.println("\n");
       
        scanner.nextLine();        
        int tipoPedido = scanner.nextInt();
        System.out.println("\n");
        String validar;
        switch (tipoPedido) {
            case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("PEDIDO A DOMICILIO");
                //Show directions to the user
                System.out.println("Escoga una dirección a la cual desea enviar su pedido:");
                for (int i = 0; i < cliente.getDireccion().size(); i++) {
                    System.out.println("Dirección " + (i+1) + ": " + cliente.getDireccion().get(i).getProvincia() + ", " + tmpDirecciones.get(i).getCanton() + ", " + tmpDirecciones.get(i).getDistrito() + ", " + tmpDirecciones.get(i).getLugarHabita());
                }
                if (tmpDirecciones.size() == 0) {
                    System.out.println("No hay direcciones disponibles");
                    break;
                } else {
                    System.out.println("Ingrese el número de la dirección a la cual desea enviar su pedido:");
                    int direccionEntrega = scanner.nextInt();
                    //Encontrar la dirección en el arraylist
                    for (int i = 0; i < tmpDirecciones.size(); i++) {
                        if (direccionEntrega == i+1) {
                            direccionDeEntrega = tmpDirecciones.get(i);
                        }
                    }
                }

                
                PedidoExpress pedidoExpress = new PedidoExpress(null, horaPedidoD, entregado, direccionDeEntrega, horaPedidoGetted, cliente, empleado);

                do {    
                    // Selec to the array the product to add to the order in a menu format extracted from the array of products
                   
                    System.out.println("Ingrese el número del producto que desea agregar a su pedido:");
                    int productoPedido = scanner.nextInt();
                    Producto producto = productos.get(productoPedido-1);
                    //add the producto to the array of productos in the order
                    //add to pedidoExpress the product with this structure Producto producto, String horaPedido, boolean finalizado, Direccion direccionEntrega, String horaEntrega, Cliente cliente, Empleado empleado)
                    pedidoExpress.addProducto(producto);            
                    System.out.println("Ingrese (y) si desea agregar otro producto");
                    //Get string input in option variable
                    scanner.nextLine();

                    validar = scanner.nextLine();
                    

                    if (validar.equals("y")) {
                    pedidosExpresses.add(pedidoExpress);
                    }
                    
                    
                } while (validar.equals("y"));
                
                
                //Return to the main App
                try {
                    MainMenu.App.main(args);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Pedido para llevar");
              

                // print the menu of products with the name of the product and the price and the porcentage of discount
                System.out.println("Menú de productos");
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println("Producto " + (i+1) + ": " + productos.get(i).getDescripcionProducto() + " Precio: " + productos.get(i).getCostoIndividualProducto() + " Descuento: " + productos.get(i).getDescuentoCategoria() + "%");
                }
                PedidoParaLlevar pedidoParaLlevar = new PedidoParaLlevar(null, horaPedidoD, false, horaPedidoGetted, fechaPedidoD, cliente, empleado);


                do {
                    // select to the array the product to add to the order in a menu format extracted from the array of products
                    System.out.println("Ingrese el número del producto que desea agregar a su pedido");
                    int productoPedido = scanner.nextInt();
                    Producto producto = productos.get(productoPedido-1);
                    //add the producto to the array of productos in the order
                    //add to pedidoParaLlevar the product with this structure Producto producto, String horaPedido, boolean finalizado, String hora, String fecha, Cliente cliente, Empleado empleado
                    pedidoParaLlevar.addProducto(producto);
                    System.out.println("Ingrese (y) si desea agregar otro producto");
                    //Get string input in option variable
                    scanner.nextLine();

                    validar = scanner.nextLine();
                    if (validar.equals("y")) {
                    pedidosParaLlevars.add(pedidoParaLlevar);
                    }
                    
                } while (validar.equals("y"));
                
                try {
                    MainMenu.App.main(args);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            case 3:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                
                System.out.println("Pedido en el restaurante");
                
               
                // boolean finalizado = scanner.nextBoolean();   Se puede agregar esto a un setter en la clase, ya que el pedido no puede estar listo recien 
                System.out.println("Ingrese el número de mesa");
                byte numeroMesa = scanner.nextByte();

                // print the menu of products with the name of the product and the price and the porcentage of discount
                System.out.println("Menú de productos");
                for (int i = 0; i < productos.size(); i++) {
                    System.out.println("Producto " + (i+1) + ": " + productos.get(i).getDescripcionProducto() + " Precio: " + productos.get(i).getCostoIndividualProducto() + " Descuento: " + productos.get(i).getDescuentoCategoria() + "%");
                }
                classes.PedidoLocal pedidoLocal = new PedidoLocal(null, horaPedidoGetted, false, numeroMesa, cliente, empleado);

                do {
                    // select to the array the product to add to the order in a menu format extracted from the array of products
                    System.out.println("Ingrese el número del producto que desea agregar a su pedido");
                    int productoPedido = scanner.nextInt();
                    Producto producto = productos.get(productoPedido-1);
                    //add the producto to the array of productos in the order
                    //add to pedidoLocal the product with this structure Producto producto, String horaPedido, boolean finalizado, byte numeroMesa, Cliente cliente, Empleado empleado
                    pedidoLocal.addProducto(producto);
                    System.out.println("Ingrese (y) si desea otro un producto"); 
                    //Get string input in option variable
                    validar = scanner.nextLine();
                    System.out.println("ignore\n");
                    scanner.nextLine();
                    validar = scanner.nextLine();
                    System.out.println("validar: " + validar + "\n");
                    if (validar.equals("y")) {
                    pedidosLocales.add(pedidoLocal);
                    }
                    
                } while (validar.equals("y"));
                // incorporate the products to the order
                

                try {
                    MainMenu.App.main(args);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            case 4:
            try {
                    MainMenu.App.main(args);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            default:
                System.out.println("Opción no válida");
                break;
                    }
        
    }

    /**
     * Get date and time
     * @return
     */
    public static String obtenerFechaHoraActual() {
        // Obtener la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        
        // Formatear la fecha y hora en un formato legible
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String fechaHoraFormateada = fechaHoraActual.format(formato);
        
        // Devolver la fecha y hora formateada como una cadena de texto
        return fechaHoraFormateada;
    }

    /**
     * Add a cliente to order
     * @return
     */
    public static Cliente addCliente() {
        Scanner scanner = new Scanner(System.in);
        byte verify;
        ArrayList<Direccion> tmpDirecciones = new ArrayList<Direccion>();

        // Set the value of cliente
        System.out.println("Ingrese el nombre completo del cliente");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el número de contacto del cliente");
        String numContacto = scanner.nextLine();
        System.out.println("Ingrese el genero del cliente");
        String genero = scanner.nextLine();
        System.out.println("Ingrese la edad del cliente");
        String edad = scanner.nextLine();

        System.out.println("\n"); 
        System.out.println("Datos de la dirección");

        do {
            System.out.println("Provincia:");
            String provincia = scanner.nextLine();
            System.out.println("Cantón:");
            String canton = scanner.nextLine();
            System.out.println("Distrito:");
            String distrito = scanner.nextLine();
            System.out.println("Dirección exacta:");
            String lugarHabita = scanner.nextLine();
            classes.Direccion direccion = new Direccion(provincia, canton, distrito, lugarHabita);

            tmpDirecciones.add(direccion);

            
            System.out.println("Ingrese (1) si desea agregar otra dirección");
            System.out.println("Ingrese (2) si desea continuar");
            verify = scanner.nextByte();
            System.out.println("\n");
        } while (verify == 1);
        Cliente cliente = new Cliente(nombre, tmpDirecciones, numContacto, genero, edad);
        return cliente;
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