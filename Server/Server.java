package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import classes.PedidoExpress;
import classes.PedidoLocal;
import classes.PedidoParaLlevar;

public class Server {
    private ArrayList<PedidoExpress> listaPedidosExpress = new ArrayList<>();
    private ArrayList<PedidoParaLlevar> listaPedidosParaLlevar = new ArrayList<>();
    private ArrayList<PedidoLocal> listaPedidosLocal = new ArrayList<>();

    public static void main(String[] args) {
        int PORT = 5000;

        Server server = new Server();
        server.startServer(PORT);
    }

    public void startServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

                // Crear un hilo separado para manejar la conexión del cliente
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                ObjectInputStream entradaObjeto = new ObjectInputStream(clientSocket.getInputStream());
                //ObjectOutputStream salidaObjeto = new ObjectOutputStream(clientSocket.getOutputStream());

                System.out.println("Esperando objeto...");

                Object objeto = entradaObjeto.readObject();

                if (objeto instanceof PedidoExpress) {
                    System.out.println("Pedido Express recibido");
                    PedidoExpress pedidoExpress = (PedidoExpress) objeto;
                    listaPedidosExpress.add(pedidoExpress);
                    System.out.println("Pedido Express agregado a la lista. Pedido de " + pedidoExpress.getCliente().getNombreCompleto());

                    try {
                        //salidaObjeto.writeObject(pedidoExpress);
                        //Recorrer la lista y enviar cada uno a la vez
                        int length = listaPedidosExpress.size();
                        System.out.println(length);
                        for (int i = 0; i < length; i++) {
                            sendPedido(listaPedidosExpress.get(i));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (objeto instanceof PedidoParaLlevar) {
                    System.out.println("Pedido Para Llevar recibido");
                    PedidoParaLlevar pedidoParaLlevar = (PedidoParaLlevar) objeto;
                    listaPedidosParaLlevar.add(pedidoParaLlevar);
                    System.out.println("Pedido Para Llevar agregado a la lista. Pedido de " + pedidoParaLlevar.getCliente().getNombreCompleto());

                    try {
                        for(PedidoParaLlevar pedido : listaPedidosParaLlevar) {
                            sendPedido(pedido);   
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (objeto instanceof PedidoLocal) {
                    System.out.println("Pedido Local recibido");
                    PedidoLocal pedidoLocal = (PedidoLocal) objeto;
                    listaPedidosLocal.add(pedidoLocal);
                    System.out.println("Pedido Local agregado a la lista. Pedido de " + pedidoLocal.getCliente().getNombreCompleto());

                    try {
                        for(PedidoLocal pedido : listaPedidosLocal) {
                            sendPedido(pedido);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.println("Objeto no reconocido");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

        /**
     * Send the pedidoExpress to the server
     * @return
     */
    public static void sendPedido(PedidoExpress pedido){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Thread sockThread = new Thread(() -> {
            String servidorIP = "127.0.0.1";
            try {
                Socket socket = new Socket("127.0.0.1", 5001);
                ObjectOutputStream salidaObjeto = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("Conectado al servidor " + servidorIP + " en el puerto 5000");

                salidaObjeto.writeObject(pedido);
                System.out.println("Reemitido");
                salidaObjeto.close();
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("ADVERTENCIA - No se pudo reemitir " + servidorIP);
                System.out.println("El sistema no se ejecutará correctamente");
                e.printStackTrace();
            }
        });
        sockThread.start();
    }

    /**
     * Send the pedidoParaLlevar to the server
     */
    public static void sendPedido(PedidoParaLlevar pedido){
        System.out.print("\033[H\033[2J");
        System.out.flush();

        Thread sockThread = new Thread(() -> {
            String servidorIP = "127.0.0.1";
            try {
                Socket socket = new Socket("127.0.0.1", 5001);
                ObjectOutputStream salidaObjeto = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("Conectado al servidor " + servidorIP + " en el puerto 5000");

                salidaObjeto.writeObject(pedido);
                System.out.println("Reemitido");
                salidaObjeto.close();
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("ADVERTENCIA - No se pudo reemitir " + servidorIP);
                System.out.println("El sistema no se ejecutará correctamente");
                e.printStackTrace();
            }
        });
       
        sockThread.start();
    }

    /**
     * Send the pedidoLocal to the server
     * @return
     */
    public static void sendPedido(PedidoLocal pedido){
         System.out.print("\033[H\033[2J");
        System.out.flush();

        Thread sockThread = new Thread(() -> {
            String servidorIP = "127.0.0.1";
            try {
                Socket socket = new Socket("127.0.0.1", 5001);
                ObjectOutputStream salidaObjeto = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("Conectado al servidor " + servidorIP + " en el puerto 5000");

                salidaObjeto.writeObject(pedido);
                System.out.println("Reemitido");
                salidaObjeto.close();
                socket.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("ADVERTENCIA - No se pudo reemitir " + servidorIP);
                System.out.println("El sistema no se ejecutará correctamente");
                e.printStackTrace();
            }
        });
       
        sockThread.start();
    }
}
