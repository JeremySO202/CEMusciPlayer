package Listas.Usuarios;

import Clases.Usuario;

/***
 * Nodo de ListaCanciones
 */
public class NodoUsuarios {
    private Usuario data;
    private NodoUsuarios next;
    private NodoUsuarios prev;

    /***
     * Crea el nodo para la lista con una nueva cancion
     * @param data cancion a ingresar en el nodo
     */
    public NodoUsuarios(Usuario data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }


    public Usuario getData() {
        return data;
    }

    public void setData(Usuario data) {
        this.data = data;
    }


    public NodoUsuarios getNext() {
        return next;
    }

    public void setNext(NodoUsuarios next) {
        this.next = next;
    }

    public NodoUsuarios getPrev() {
        return prev;
    }

    public void setPrev(NodoUsuarios prev) {
        this.prev = prev;
    }

}//fin clase

