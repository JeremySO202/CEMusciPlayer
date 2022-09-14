package Listas.Bibliotecas;


import Clases.Biblioteca;

/***
 * Nodo de ListaCanciones
 */
public class NodoBibliotecas {
    private Biblioteca data;
    private NodoBibliotecas next;

    /***
     * Crea el nodo para la lista con una nueva cancion
     * @param data cancion a ingresar en el nodo
     */
    public NodoBibliotecas(Biblioteca data) {
        this.data = data;
        this.next = null;
    }

    public Biblioteca getData() {
        return data;
    }

    public void setData(Biblioteca data) {
        this.data = data;
    }

    public NodoBibliotecas getNext() {
        return next;
    }

    public void setNext(NodoBibliotecas next) {
        this.next = next;
    }
}
