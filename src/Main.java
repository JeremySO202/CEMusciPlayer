import Clases.Cancion;
import Listas.ListaCanciones;
import Reproductor.Reproductor;
import Ventanas.GUI_Reproductor;

import javax.swing.*;
import java.awt.*;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCanciones lista = new ListaCanciones();
        lista.insertarInicio(new Cancion("Fondo","Fondo.mp3"));
        lista.insertarInicio(new Cancion("Fondo2","Fondo2.mp3"));
        lista.insertarInicio(new Cancion("Fondo3","Fondo3.mp3"));
        //TODO GUI

        GUI_Reproductor gui_reproductor = new GUI_Reproductor();
        gui_reproductor.setVisible(true);


    }//main

}//fin clase