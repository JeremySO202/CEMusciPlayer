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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}//fin clase usuario
