import Clases.Biblioteca;
import Clases.Cancion;
import Listas.Bibliotecas.ListaBibliotecas;
import Listas.Canciones.ListaCanciones;
import Ventanas.GUI_Bibliotecas;

public class Main {
    public static void main(String[] args) {
        ListaCanciones lista = new ListaCanciones();
        lista.insertarInicio(new Cancion("The Oh Hellos： Bitter Water","The Oh Hellos： Bitter Water.mp3"));
        lista.insertarInicio(new Cancion("The Oh Hellos： Danse Macabre","The Oh Hellos： Danse Macabre.mp3"));
        lista.insertarInicio(new Cancion("The Oh Hellos： Dear Wormwood","The Oh Hellos： Dear Wormwood.mp3"));
        lista.insertarInicio(new Cancion("The Oh Hellos： Exeunt","The Oh Hellos： Exeunt.mp3"));
        lista.insertarInicio(new Cancion("The Oh Hellos： In the Blue Hours of Morning","The Oh Hellos： In the Blue Hours of Morning.mp3"));
        lista.insertarInicio(new Cancion("The Oh Hellos： Thus Always to Tyrants","The Oh Hellos： Thus Always to Tyrants.mp3"));
        lista.insertarInicio(new Cancion("The Oh Hellos： There Beneath","The Oh Hellos： There Beneath.mp3"));
        lista.insertarInicio(new Cancion("The Oh Hellos： Soldier, Poet, King","The Oh Hellos： Soldier, Poet, King.mp3"));
        lista.insertarInicio(new Cancion("The Oh Hellos： Prelude","The Oh Hellos： Prelude.mp3"));
        ListaBibliotecas listaBibliotecas = new ListaBibliotecas();
        listaBibliotecas.insertarInicio(new Biblioteca("B1", lista));
        listaBibliotecas.insertarInicio(new Biblioteca("B2", lista));
        listaBibliotecas.insertarInicio(new Biblioteca("B3", lista));
        listaBibliotecas.insertarInicio(new Biblioteca("B4", lista));
        listaBibliotecas.insertarInicio(new Biblioteca("B5", lista));


        //TODO GUI

        GUI_Bibliotecas gui_bibliotecas = new GUI_Bibliotecas(listaBibliotecas);
//        GUI_Reproductor gui_reproductor = new GUI_Reproductor(lista);
//        gui_reproductor.setVisible(true);


    }//main

}//fin clase