package classes;

public abstract class Pedido {
    private Producto producto;
    private String horaPedido;
    protected boolean finalizado;

    /**
     * Constructor
     * @param producto
     * @param horaPedido
     */
    public Pedido(Producto producto, String horaPedido) {
        this.producto = producto;
        this.horaPedido = horaPedido;
        this.finalizado = false;
    }

    /**
     * Get the value of producto
     * @return
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Get the value of horaPedido
     * @return
     */
    public String getHoraPedido() {
        return horaPedido;
    }

    /**
     * Get the value of finalizado
     * @return
     */
    public boolean isFinalizado() {
        return finalizado;
    }

    /**
     * Set the value of producto
     * @param producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Set the value of horaPedido
     * @param horaPedido
     */
    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    /**
     * Set the value of finalizado
     * @param finalizado
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }


    // Methods - Especificar mejor su funcionamiento y agregar bien los parametros
    /*--------------
     * -----------
     * -------------
     */
    public float cobroProduccion() {
        return producto.getCostoIndividualProducto();
    }
    /*
     * -------------
     * ------------
     * -------------
     */
}
