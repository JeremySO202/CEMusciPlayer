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
        return this.head == null;
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

    /***
     * Busca un id y retorna la cancion correspondiente
     * @param id
     * @return cancion encontrada
     */
    public Cancion buscarId(String id){
        NodoCanciones inicio = this.head;
        NodoCanciones actual = this.head;

        do {
            if (actual.getData().getId().equals(id)){
                return actual.getData();
            }
            actual = actual.getNext();
        }while (inicio!=actual);
        return null;
    }

    /***
     * Busca por id y modifica la cancion encontrada
     * @param id
     * @param modificada
     */
    public void modificarPorId(String id, Cancion modificada){
        NodoCanciones inicio = this.head;
        NodoCanciones actual = this.head;

        do {
            if (actual.getData().getId().equals(id)){
                actual.setData(modificada);
            }
            actual = actual.getNext();
        }while (inicio!=actual);

    }

    /***
     * Busca por id y elimina el encontrado
     * @param id
     */
    public void eliminarPorId(String id){
        NodoCanciones inicio = this.head;
        NodoCanciones actual = this.head;
        NodoCanciones previo = this.head.getPrev();

        if (actual==previo && actual.getData().getId().equals(id)){
            this.head = null;
        }
        else{
            if (inicio!=null){
                do {
                    if (actual.getData().getId().equals(id)){
                        boolean bandera = false;
                        if (inicio==actual){
                            bandera = true;
                        }
                        previo.setNext(previo.getNext().getNext());
                        actual = actual.getNext();
                        actual.setPrev(previo);
                        if (bandera){
                            inicio=actual;
                        }

                    }
                    actual = actual.getNext();
                    previo = actual.getPrev();
                }while (inicio!=actual);
                this.head = actual;
            }
        }


    }
    public NodoCanciones getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }


}
