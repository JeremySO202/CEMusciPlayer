package Clases;

/***
 * Clase donde le almacenara los usuarios
 */
public class Usuario {
    private String nombreCompleto;
    private String correoElectronico;
    private String provincia;
    private String contrasena;

    /***
     *Constructor de la clase Usuario
     * @param nombreCompleto nombre del usuario a registrar
     * @param correoElectronico correo de la persona a regitrar
     * @param provincia provincia en la que vive el usuario
     * @param contrasena constraseña que registra el usuario
     */
    public Usuario(String nombreCompleto, String correoElectronico, String provincia, String contrasena) {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.provincia = provincia;
        this.contrasena = contrasena;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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
