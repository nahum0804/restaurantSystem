package classes;

import java.io.Serializable;

public abstract class Categoria implements Serializable{
    protected String tipoCategoria;
    protected float descuentoCategoria;

    /**
     * Constructor
     * @param tipoCategoria
     * @param descuentoCategoria
     */
    public Categoria(String tipoCategoria, float descuentoCategoria) {
        this.tipoCategoria = tipoCategoria;
        this.descuentoCategoria = descuentoCategoria;
    }

    /**
     * Get the value of tipoCategoria
     * @return
     */
    public String getTipoCategoria() {
        return tipoCategoria;
    }

    /**
     * Get the value of descuentoCategoria
     * @return
     */
    public float getDescuentoCategoria() {
        return descuentoCategoria;
    }


    /**
     * Set the value of tipoCategoria
     * @param tipoCategoria
     */
    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    /**
     * Set the value of descuentoCategoria
     * @param descuentoCategoria
     */
    public void setDescuentoCategoria(float descuentoCategoria) {
        this.descuentoCategoria = descuentoCategoria;
    }
}
