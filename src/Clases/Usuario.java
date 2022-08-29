package Clases;

public class Usuario {
    private String nombreCompleto;
    private String correoElectronico;
    private String provincia;
    private String contraseña;

    public Usuario(String nombreCompleto, String correoElectronico, String provincia, String contraseña) {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.provincia = provincia;
        this.contraseña = contraseña;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}//fin clase usuario
