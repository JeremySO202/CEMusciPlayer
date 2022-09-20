package Listas.Bibliotecas;

import Clases.Biblioteca;

/***
 * Clase donde se almacena la lista de canciones
 */
public class ListaBibliotecas {
    //TODO crear lista de canciones
    private NodoBibliotecas head;
    private NodoBibliotecas last;
    private int size;

    /***
     * Metodo contructor de la clase ListaBibliotecas
     */
    public ListaBibliotecas() {
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
    public void insertarInicio(Biblioteca data){
        System.out.println(data.getNombre());
        NodoBibliotecas nuevo = new NodoBibliotecas(data);
        if (vacia()){
            this.head = nuevo;
            this.last = nuevo;
            this.head.setNext(null);
        }
        else{
            nuevo.setNext(this.head);
            this.head = nuevo;
        }
        this.size++;
    }

    public Biblioteca buscarNombre(String nombre){
        NodoBibliotecas temp = head;
        while (temp!=null){
            if (temp.getData().getNombre().equals(nombre)){
                return temp.getData();
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void modificarPorNombre(Biblioteca modificada){
        ListaBibliotecas nueva = new ListaBibliotecas();
        NodoBibliotecas temp = head;
        while (temp!=null){
            if (temp.getData().getNombre().equals(modificada.getNombre())){
                temp.setData(modificada);
            }
            nueva.insertarInicio(temp.getData());
            temp = temp.getNext();
        }
        this.head = nueva.getHead();
    }

    public void eliminarPorNombre(String eliminar){
        ListaBibliotecas nueva = new ListaBibliotecas();
        NodoBibliotecas temp = head;
        while (temp!=null){
            if (!temp.getData().getNombre().equals(eliminar)){
                nueva.insertarInicio(temp.getData());
            }else{
                this.size--;
            }
            temp = temp.getNext();
        }
        this.head = nueva.getHead();
    }

    public NodoBibliotecas getHead() {
        return head;
    }

    public void setHead(NodoBibliotecas head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
