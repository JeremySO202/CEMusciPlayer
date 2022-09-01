package Listas;

import Clases.Cancion;

public class ListaCanciones {
    //TODO crear lista de canciones
    private NodoCanciones head;
    private NodoCanciones last;
    private int size;

    public ListaCanciones() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public boolean vacia(){
        if (this.head == null){
            return true;
        }
        return false;
    }

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
