package classes;

import java.io.Serializable;


public class Empleado extends Persona implements Serializable{

    /* 
        Verificar como están agregados los atributos en las clases
        Si hay listas en de clientes y a su vez hay listas de productos
    */ 

    
    /**
     * Constructor
     * @param nombreCompleto
     */
    public Empleado(String nombreCompleto) {
        super(nombreCompleto);
    }
    
}
