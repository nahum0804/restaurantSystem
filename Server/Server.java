package Server;

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
                ObjectOutputStream salidaObjeto = new ObjectOutputStream(clientSocket.getOutputStream());

                System.out.println("Esperando objeto...");

                Object objeto = entradaObjeto.readObject();

                if (objeto instanceof PedidoExpress) {
                    System.out.println("Pedido Express recibido");
                    PedidoExpress pedidoExpress = (PedidoExpress) objeto;
                    listaPedidosExpress.add(pedidoExpress);
                    System.out.println("Pedido Express agregado a la lista. Pedido de " + pedidoExpress.getCliente().getNombreCompleto());

                    try {
                        salidaObjeto.writeObject(pedidoExpress);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (objeto instanceof PedidoParaLlevar) {
                    // Manejar PedidoParaLlevar
                } else if (objeto instanceof PedidoLocal) {
                    // Manejar PedidoLocal
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
}
