package classes;


public class Direccion {
    private String provincia;
    private String canton;
    private String distrito;
    private String lugarHabita; // Direccion exacta

    /**
     * Constructor
     * @param provincia
     * @param canton
     * @param distrito
     * @param lugarHabita
     */
    public Direccion(String provincia, String canton, String distrito, String lugarHabita) {
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.lugarHabita = lugarHabita;
    }
    
    /**
     * Getter de provincia
     * @return
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Getter de canton
     * @return
     */
    public String getCanton() {
        return canton;
    }

    /**
     * Getter de distrito
     * @return
     */ 
    public String getDistrito() {
        return distrito;
    }

    /**
     * Getter de lugarHabita
     * @return
     */
    public String getLugarHabita() {
        return lugarHabita;
    }

    /**
     * Setter de provincia
     * @param provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * Setter de distrito
     * @param canton
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }
    

    /**
     * Setter de distrito
     * @param distrito
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * Setter de lugarHabita
     * @param lugarHabita
     */
    public void setLugarHabita(String lugarHabita) {
        this.lugarHabita = lugarHabita;
    }
}
