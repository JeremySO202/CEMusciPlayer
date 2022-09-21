package Listas.Usuarios;

import Clases.Usuario;
import Listas.Canciones.NodoCanciones;

public class ListaUsuarios {
    //TODO crear lista de usuarios
    private NodoUsuarios head;
    private NodoUsuarios last;
    private int size;

    /***
     * Contructor de la clase ListaUsuarios
     */
    public ListaUsuarios() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    /***
     * Comprobacion de si la lista está vacía
     * @return retorna true en caso de que este vacia y false en caso contrario
     */
    public boolean vacia() {
        if (this.head == null) {
            return true;
        }
        return false;
    }//vacia

    /***
     * Ingresa una cancion al inicio de nuestra lista
     * @param data cancion a ingresar
     */
    public void insertarInicio(Usuario data) {
        NodoUsuarios nuevo = new NodoUsuarios(data);
        if (vacia()) {
            this.head = nuevo;
            this.last = nuevo;
            this.head.setNext(this.head);
            this.head.setPrev(this.head);
        } else {
            nuevo.setNext(this.head);
            nuevo.setPrev(this.last);
            this.head.setPrev(nuevo);
            this.head = nuevo;
            this.head.setPrev(this.last);
            this.last.setNext(this.head);
        }
        this.size++;

    }//insertarInicio

    public NodoUsuarios getHead() {
        return head;
    }

    public void setHead(NodoUsuarios head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


}//fin clase
