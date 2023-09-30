package classes;

public abstract class Persona {
    protected String nombreCompleto;

    /**
     * Constructor
     * @param nombreCompleto
     */
    public Persona(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Get the value of nombreCompleto
     * @return
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Set the value of nombreCompleto
     * @param nombreCompleto
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    
}
