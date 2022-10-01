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

    /***
     * Metodo constructor de la clase Cancion
     * @param id id de la cancion
     * @param nombre nombre de la cancion
     * @param direccion direccion de la cancion
     * @param genero genero de la cancion
     * @param artista artista de la cancion
     * @param album album de la cancion
     * @param ano ano de la cancion
     * @param letra letra de la cancion
     */
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

    /***
     * Retorna el id de la cancion
     * @return el id de la cancion
     */
    public String getId() {
        return id;
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
     * Retorna el genero de la cancion
     * @return el genero de la cancion
     */
    public String getGenero() {
        return genero;
    }

    /***
     * Retorna el artista de la cancion
     * @return el artista de la cancion
     */
    public String getArtista() {
        return artista;
    }

    /***
     * Retorna el album de la cancion
     * @return el album de la cancion
     */
    public String getAlbum() {
        return album;
    }
    /***
     * Retorna el ano de la cancion
     * @return el ano de la cancion
     */
    public String getAno() {
        return ano;
    }
    /***
     * Retorna el letra de la cancion
     * @return el letra de la cancion
     */
    public String getLetra() {
        return letra;
    }
}
