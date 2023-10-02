package classes;

import java.util.ArrayList;

public abstract class Pedido {
    private String horaPedido;
    protected boolean finalizado;
    private ArrayList<Producto> producto;
    private Cliente cliente;
    private Empleado empleado;
    /**
     * Constructor
     * @param horaPedido
     * @param finalizado
     */
    public Pedido(Producto producto, String horaPedido, boolean finalizado, Cliente cliente, Empleado empleado) {
        this.horaPedido = horaPedido;
        this.finalizado = finalizado;
        this.producto = new ArrayList<Producto>();
        this.cliente = cliente;
        this.empleado = empleado;
        //Add the product to the list
        this.producto.add(producto);
    }

    /**
     * Get the value of producto list
     * @return
     */
    public ArrayList<Producto> getProducto() {
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

    /**
     * Add a product to the list
     * @param producto
     */
    public void addProducto(Producto producto) {
        this.producto.add(producto);
    }

    /**
     * Remove a product from the list
     * @param producto
     */
    public void removeProducto(Producto producto) {
        this.producto.remove(producto);
    }

    /**
     * Set the value of producto
     */
    public void setProducto() {
        System.out.println("Set the value of producto function");
        
    }


    // Methods 

    /**
     * Calculate the total cost of the pedido
     * @param costoProducto
     * @param porcentajeDescuento
     * @return float
     */
    public float cobroProduccion(float costoProducto, String porcentajeDescuento) {
        float descuento = Float.parseFloat(porcentajeDescuento);
        descuento = descuento / 100;
        return costoProducto - (costoProducto * descuento);
    }

    /**
     * set the value of cliente
     * @param cliente
     */
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Get the value of cliente
     * @return
     */

    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Set the value of empleado
     * @param empleado
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * Get the value of empleado
     * @return
     */
    public Empleado getEmpleado() {
        return empleado;
    }
}
