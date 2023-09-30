package classes;

public class PedidoParaLlevar extends Pedido{
    private String hora;
    private String fecha;

    /**
     * Constructor
     * @param producto
     * @param horaPedido
     * @param hora
     * @param fecha
     */
    public PedidoParaLlevar(Producto producto, String horaPedido, String hora, String fecha) {
        super(producto, horaPedido);
        this.hora = hora;
        this.fecha = fecha;
    }

    /**
     * Get the value of hora
     * @return
     */
    public String getHora() {
        return hora;
    }

    /**
     * Get the value of fecha
     * @return
     */
    public String getFecha() {
        return fecha;
    }


    /**
     * Set the value of hora
     * @param hora
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Set the value of fecha
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
