import Clases.Cancion;
import Listas.ListaCanciones;
import Reproductor.Reproductor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCanciones lista = new ListaCanciones();
        lista.insertarInicio(new Cancion("Fondo","Fondo.mp3"));
        lista.insertarInicio(new Cancion("Fondo2","Fondo2.mp3"));
        lista.insertarInicio(new Cancion("Fondo3","Fondo3.mp3"));
        Scanner lector = new Scanner(System.in);
        Reproductor reproductor = new Reproductor(lista);
        while (true){
            lector.nextLine();
            reproductor.Pausar();
            lector.nextLine();
            reproductor.Anterior();
        }
        //TODO GUI

    }//fin main
}//fin clase