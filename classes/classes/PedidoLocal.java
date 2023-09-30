package classes;

public class PedidoLocal extends Pedido{
    private byte numeroMesa;

    /**
     * Constructor
     * @param producto
     * @param horaPedido
     * @param numeroMesa
     */
    public PedidoLocal(Producto producto, String horaPedido, boolean finalizado, byte numeroMesa) {
        super(producto, horaPedido, finalizado);
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
}
