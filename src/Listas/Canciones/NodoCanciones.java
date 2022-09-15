package Listas.Canciones;

import Clases.Cancion;

/***
 * Nodo de ListaCanciones
 */
public class NodoCanciones {
    private Cancion data;
    private NodoCanciones next;
    private NodoCanciones prev;

    /***
     * Crea el nodo para la lista con una nueva cancion
     * @param data cancion a ingresar en el nodo
     */
    public NodoCanciones(Cancion data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Cancion getData() {
        return data;
    }

    public void setData(Cancion data) {
        this.data = data;
    }

    public NodoCanciones getNext() {
        return next;
    }

    public void setNext(NodoCanciones next) {
        this.next = next;
    }

    public NodoCanciones getPrev() {
        return prev;
    }

    public void setPrev(NodoCanciones prev) {
        this.prev = prev;
    }
}
