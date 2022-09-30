package Clases;

/***
 * Clase utilizada para almacenar las canciones del programa
 */
public class Cancion {
    //TODO agregar XML???
    private String id;
    private String nombre;
    private String direccion;
    private String genero;
    private String artista;
    private String album;
    private String ano;
    private String letra;

    public Cancion(String id, String nombre, String direccion, String genero, String artista, String album, String ano, String letra) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.genero = genero;
        this.artista = artista;
        this.album = album;
        this.ano = ano;
        this.letra = letra;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
}
