package classes;

public class Cliente extends Persona{
    private Direccion direccion;
    private String numeroContacto;
    private String genero;
    private String edad;

    /**
     * Constructor
     * @param nombreCompleto
     * @param string
     * @param numeroContacto
     * @param genero
     * @param edad
     */
    public Cliente(String nombreCompleto, Direccion direccion, String numeroContacto, String genero, String edad) {
        super(nombreCompleto);
        this.direccion = direccion;
        this.numeroContacto = numeroContacto;
        this.genero = genero;
        this.edad = edad;
    }

    /**
     * Get the value of direccion
     * @return
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Get the value of numeroContacto
     * @return
     */
    public String getNumeroContacto() {
        return numeroContacto;
    }

    /**
     * Get the value of genero
     * @return
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Get the value of edad
     * @return
     */
    public String getEdad() {
        return edad;
    }


    /**
     * Set the value of direccion
     * @param direccion
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Set the value of numeroContacto
     * @param numeroContacto
     */
    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    /**
     * Set the value of genero
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Set the value of edad
     * @param edad
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }
}