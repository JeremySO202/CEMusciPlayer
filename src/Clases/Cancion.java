package Clases;

/***
 * Clase utilizada para almacenar las canciones del programa
 */
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

    /***
     * Retorna el nombre de la cancion almacenado
     * @return Nombre almacenado
     */
    public String getNombre() {
        return nombre;
    }
    /***
     * Cambia el nombre de la cancion
     * @param nombre nuevo nombre a guardar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /***
     * Retorna la direccion de la cancion almacenado
     * @return Nombre almacenado
     */
    public String getDireccion() {
        return direccion;
    }

    /***
     * Cambia la direccion de la cancion
     * @param direccion nueva direccion a guardar
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
