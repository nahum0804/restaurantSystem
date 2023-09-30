package classes;

public class Producto extends Categoria {
    private String descripcionProducto;
    private float costoIndividualProducto;
    private String tiempoPreparacion;

    /**
     * Constructor
     * @param tipoCategoria
     * @param descuentoCategoria
     * @param descripcionProducto
     * @param costoIndividualProducto
     * @param tiempoPreparacion
     */
    public Producto(String tipoCategoria, float descuentoCategoria, String descripcionProducto,
            float costoIndividualProducto, String tiempoPreparacion) {
        super(tipoCategoria, descuentoCategoria);
        this.descripcionProducto = descripcionProducto;
        this.costoIndividualProducto = costoIndividualProducto;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    /**
     * Get the value of descripcionProducto
     * @return
     */
    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    /**
     * Get the value of costoIndividualProducto
     * @return
     */
    public float getCostoIndividualProducto() {
        return costoIndividualProducto;
    }

    /**
     * Get the value of tiempoPreparacion
     * @return
     */
    public String getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    /**
     * Set the value of descripcionProducto
     * @param descripcionProducto
     */
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    /**
     * Set the value of costoIndividualProducto
     * @param costoIndividualProducto
     */
    public void setCostoIndividualProducto(float costoIndividualProducto) {
        this.costoIndividualProducto = costoIndividualProducto;
    }

    /**
     * Set the value of tiempoPreparacion
     * @param tiempoPreparacion
     */
    public void setTiempoPreparacion(String tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }
    
}
