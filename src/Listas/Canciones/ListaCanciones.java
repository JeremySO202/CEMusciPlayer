package Listas.Canciones;

import Clases.Cancion;

/***
 * Clase donde se almacena la lista de canciones
 */
public class ListaCanciones {
    //TODO crear lista de canciones
    private NodoCanciones head;
    private NodoCanciones last;
    private int size;

    /***
     * Metodo contructor de la clase ListaCanciones
     */
    public ListaCanciones() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    /***
     * Comprueba si nuestra lista esta vacia
     * @return retorna true en caso de que este vacia y false en caso contrario
     */
    public boolean vacia(){
        if (this.head == null){
            return true;
        }
        return false;
    }

    /***
     * Ingresa una cancion al inicio de nuestra lista
     * @param data cancion a ingresar
     */
    public void insertarInicio(Cancion data){
        NodoCanciones nuevo = new NodoCanciones(data);
        if (vacia()){
            this.head = nuevo;
            this.last = nuevo;
            this.head.setNext(this.head);
            this.head.setPrev(this.head);
        }
        else{
            nuevo.setNext(this.head);
            nuevo.setPrev(this.last);
            this.head.setPrev(nuevo);
            this.head = nuevo;
            this.head.setPrev(this.last);
            this.last.setNext(this.head);
        }
        this.size++;

    }

    public NodoCanciones getHead() {
        return head;
    }

    public void setHead(NodoCanciones head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
