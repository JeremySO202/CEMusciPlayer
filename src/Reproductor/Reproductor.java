package Reproductor;

import Clases.Cancion;
import Listas.ListaCanciones;
import Listas.NodoCanciones;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Reproductor {
    private MediaPlayer reproductor;
    private ListaCanciones lista;
    private NodoCanciones cancionActual;

    public Reproductor(ListaCanciones lista) {
        this.lista = lista;
        this.cancionActual = lista.getHead();
        NuevaCancion(this.cancionActual.getData().getDireccion());
    }

    public void NuevaCancion(String nombreArchivo){
        com.sun.javafx.application.PlatformImpl.startup(()->{});

        final String PATH = "Recursos/Canciones/" + nombreArchivo;
        File archivo = new File(PATH);

        Media audio = new Media(archivo.toURI().toString());

        this.reproductor = new MediaPlayer(audio);
        Reproducir();



    }
    public void Reproducir(){
        new Thread(){
            public void run() {
                reproductor.play();
            }
        }.start();
    }
    public void Pausar(){
        reproductor.pause();
    }
    public void Siguente(){
        this.cancionActual=this.cancionActual.getNext();
        reproductor.stop();
        System.out.println(this.cancionActual.getData().getDireccion());
        NuevaCancion(this.cancionActual.getData().getDireccion());
    }
    public void Anterior(){
        System.out.println(this.cancionActual.getPrev().getPrev().getData().getDireccion());
        this.cancionActual=this.cancionActual.getPrev();
        reproductor.stop();
        System.out.println(this.cancionActual.getData().getDireccion());
        NuevaCancion(this.cancionActual.getData().getDireccion());

    }
    public void SubirVolumen(){
        System.out.printf("SubirVolumen");
    }
    public void BajarVolumen(){
        System.out.printf("BajarVolumen");
    }
}
