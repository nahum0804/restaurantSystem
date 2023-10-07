package classes;

import java.io.Serializable;

public class PedidoLocal extends Pedido implements Serializable {
    private byte numeroMesa;

    /**
     * Constructor
     * @param producto
     * @param horaPedido
     * @param numeroMesa
     * @param finalizado
     * @param cliente
     * @param empleado
     */
    public PedidoLocal(Producto producto, String horaPedido, boolean finalizado, byte numeroMesa, Cliente cliente, Empleado empleado) {
        super(producto, horaPedido, finalizado, cliente, empleado);
        this.numeroMesa = numeroMesa;
    }

    /**
     * Get the value of numeroMesa
     * @return
     */
    public byte getNumeroMesa() {
        return numeroMesa;
    
    }

    /**
     * Set the value of numeroMesa
     * @param numeroMesa
     */
    public void setNumeroMesa(byte numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    /**
     * To String
     * @return
     */
    @Override
    public String toString() {
        return "PedidoLocal [numeroMesa=" + numeroMesa + "]";

    }
}
