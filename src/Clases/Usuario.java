package Clases;

/***
 * Clase donde le almacenara los usuarios
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String provincia;
    private String contrasena;



    /***
     * Constructor de la clase Usuario
     * @param nombre nombre del usuario a registrar
     * @param apellido apellido de la persona a regitrar
     * @param correoElectronico correo de la persona a regitrar
     * @param provincia provincia en la que vive el usuario
     * @param contrasena contrasena constraseña que registra el usuario
     */
    public Usuario(String nombre, String apellido, String correoElectronico, String provincia, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.provincia = provincia;
        this.contrasena = contrasena;
    }//constructor

    /***
     * Retorna el nombre del usuario
     * @return el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }
    /***
     * Retorna el apellido del usuario
     * @return el apellido del usuario
     */
    public String getApellido() {
        return apellido;
    }
    /***
     * Retorna el correo Electronico del usuario
     * @return el correo Electronico del usuario
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    /***
     * Retorna el provincia del usuario
     * @return el provincia del usuario
     */
    public String getProvincia() {
        return provincia;
    }
    /***
     * Retorna el contrasena del usuario
     * @return el contrasena del usuario
     */
    public String getContrasena() {
        return contrasena;
    }
}//fin clase usuario
