package classes;

public class ServicioExpress {
    private String recojido;
    private Boolean entregado;
    private String tiempoEntrega;
    
    /**
     * Constructor
     * @param recojido
     * @param entregado
     * @param tiempoEntrega
     */

    public ServicioExpress(String recojido, Boolean entregado, String tiempoEntrega) {
        this.recojido = recojido;
        this.entregado = entregado;
        this.tiempoEntrega = tiempoEntrega;
        }
    
    /**
     * Get the value of recojido
     * @return
     */

    public String getRecojido() {
        return recojido;
        }

    /**
     * Get the value of entregado
     * @return
     */

    public Boolean getEntregado() {
        return entregado;
        }
    
    /**
     * Get the value of tiempoEntrega
     * @return
     */

    public String getTiempoEntrega() {
        return tiempoEntrega;
        }
    
    /**
     *  Set the value of recojido
     * @param recojido
     */

    public void setRecojido(String recojido) {
        this.recojido = recojido;
        }
    
    /**
     *  Set the value of entregado
     * @param entregado
     */

    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
        }
    
    /**
     * Set the value of tiempoEntrega
     * @param tiempoEntrega
     */

    public void setTiempoEntrega(String tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
        }
    
    /**
     * Verify if the pedido has been finished
     */
    public void verificarFinalizado(){
        if (entregado == true){
            System.out.println("El pedido ha sido entregado");
        }else{
            System.out.println("El pedido no ha sido entregado");
        }
    }

    /**
     * Mark the pedido as finished
     */
    public void marcarFinalizado() {
        setEntregado(entregado = true);
    }
}

