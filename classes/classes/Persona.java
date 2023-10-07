package classes;

import java.io.Serializable;

public abstract class Persona implements Serializable{
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
