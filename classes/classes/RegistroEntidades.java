package classes;

public class RegistroEntidades extends Persona{
    private String numeroCedula;
    private String numeroContacto;
    private String medioTransporte;
    private String placaVehiculo;
    private String tipoVehiculo;

    /**
     * Constructor 
     * @param nombreCompleto
     * @param numeroCedula
     * @param numeroContacto
     * @param medioTransporte
     * @param placaVehiculo
     * @param tipoVehiculo
     */
    public RegistroEntidades(String nombreCompleto, String numeroCedula, String numeroContacto, String medioTransporte, String placaVehiculo, String tipoVehiculo) {
        super(nombreCompleto);
        this.numeroCedula = numeroCedula;
        this.numeroContacto = numeroContacto;
        this.medioTransporte = medioTransporte;
        this.placaVehiculo = placaVehiculo;
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Get the value of numeroCedula
     * @return
     */

     public String getNumeroCedula() {
         return numeroCedula;
     }

    /**
    * Get the value of numeroContacto
    * @return
    */
    public String getNumeroContacto() {
        return numeroContacto;
    }

    /**
     * Get the value of medioTransporte
     * @return
     */
    public String getMedioTransporte() {
        return medioTransporte;
    }

    /**
     * Get the value of placaVehiculo
     * @return
     */
    public String getPlacaVehiculo() {
        return placaVehiculo;
    }

    /**
     * Get the value of tipoVehiculo
     * @return
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }



    /**
     * Set the value of numeroCedula
     * @param numeroCedula
     */
    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    /**
     * Set the value of numeroContacto
     * @param numeroContacto
     */
    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    /**
     * Set the value of medioTransporte
     * @param medioTransporte
     */
    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    /**
     * Set the value of placaVehiculo
     * @param placaVehiculo
     */
    public void setPlacaVehiculo(String placaVehiculo) {
        this.placaVehiculo = placaVehiculo;
    }

    /**
     * Set the value of tipoVehiculo
     * @param tipoVehiculo
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
}
