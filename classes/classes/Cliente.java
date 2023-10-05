package classes;

import java.util.ArrayList;

public class Cliente extends Persona{
    ArrayList<Direccion> direcciones = new ArrayList<Direccion>();
    private Direccion direccion;
    private String numeroContacto;
    private String genero;
    private String edad;

    /**
     * Constructor
     * @param nombreCompleto
     * @param ArrayList<Direccion>
     * @param numeroContacto
     * @param genero
     * @param edad
     */
    public Cliente(String nombreCompleto, ArrayList<Direccion> direccion, String numeroContacto, String genero, String edad) {
        super(nombreCompleto);
        this.direcciones = direccion;
        this.numeroContacto = numeroContacto;
        this.genero = genero;
        this.edad = edad;
    }

    /**
     * Get directions list
     * @return
     */
    public ArrayList<Direccion> getDireccion() {
        return direcciones;
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