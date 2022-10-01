package Clases;

import Listas.Canciones.ListaCanciones;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//TODO Terminar
public class Biblioteca {
    private String nombre;
    private ListaCanciones listaCanciones;
    private String fecha;

    /***
     * Metodo constructor de la clase biblioteca
     * @param nombre nombre de la playlist
     * @param listaCanciones lista de canciones de la playlist
     * @param fecha fecha de creacion
     */
    public Biblioteca(String nombre, ListaCanciones listaCanciones, String fecha) {
        this.nombre = nombre;
        this.listaCanciones = listaCanciones;
        this.fecha = fecha;
    }

    /***
     * Retorna el nombre de la playlist
     * @return el nombre de la playlist
     */
    public String getNombre() {
        return nombre;
    }

    /***
     * Modifica el nombre
     * @param nombre nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /***
     * Retorna la lista de canciones
     * @return la lista de canciones
     */
    public ListaCanciones getListaCanciones() {
        return listaCanciones;
    }

    /***
     * Modifica la lista de canciones
     * @param listaCanciones la lista de canciones
     */
    public void setListaCanciones(ListaCanciones listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    /***
     * Retorna la fecha de la playlist
     * @return la fecha de la playlist
     */
    public String getFecha() {
        return fecha;
    }
}
