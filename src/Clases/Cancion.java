package Clases;

public class Cancion {
    //TODO agregar XML???
    private String nombre;
    private String direccion;

    /***
     * Constructor de la clase Cancion
     * @param nombre nombre de la cancion
     * @param direccion path de donde se ubica la cancion
     */
    public Cancion(String nombre, String direccion) {

        this.nombre = nombre;
        this.direccion = direccion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
