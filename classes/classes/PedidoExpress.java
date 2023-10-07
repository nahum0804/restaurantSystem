package classes;

import java.io.Serializable;

public class PedidoExpress extends Pedido implements Serializable {
    private Direccion direccionEntrega;
    private String horaEntrega;
    private boolean entregado;
    

    
    /**
     * Constructor
     * @param direccionEntrega
     * @param horaEntrega
     * @param entregado
     * @param producto
     * @param horaPedido
     * @param finalizado
     * @param cliente
     * @param empleado
     * 
     */
    public PedidoExpress(Producto producto, String horaPedido, boolean finalizado, Direccion direccionEntrega, String horaEntrega, Cliente cliente, Empleado empleado) {
        super(producto, horaPedido, finalizado, cliente, empleado);
        this.direccionEntrega = direccionEntrega;
        this.horaEntrega = horaEntrega;
        this.entregado = false;
    }


    /**
     * Get the value of direccionEntrega
     * @return
     */
    public Direccion getDireccionEntrega() {
        return direccionEntrega;
    }

    /**
     * Get the value of horaEntrega
     * @return
     */
    public String getHoraEntrega() {
        return horaEntrega;
    }

    /**
     * Get the value of entregado
     * @return
     */
    public boolean isEntregado() {
        return entregado;
    }


    /**
     * Set the value of direccionEntrega
     * @param direccionEntrega
     */
    public void setDireccionEntrega(Direccion direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    /**
     * Set the value of horaEntrega
     * @param horaEntrega
     */
    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    /**
     * Set the value of entregado
     * @param entregado
     */
    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }


    // Methods - - Especificar mejor su funcionamiento 
    /*--------------
     * -----------
     * -------------
     */
    public String horaEstimadaEntrega(String tiempoPreparacion) {
        return tiempoPreparacion;
    }
    /*--------------
     * -----------
     * -------------
     */
}
