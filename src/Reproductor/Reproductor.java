package Reproductor;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class Reproductor {
    MediaPlayer reproductor;
    public void Reproducir(String nombreArchivo){
        com.sun.javafx.application.PlatformImpl.startup(()->{});

        final String PATH = "Recursos/Canciones/" + nombreArchivo;
        File archivo = new File(PATH);

        Media audio = new Media(archivo.toURI().toString());

        this.reproductor = new MediaPlayer(audio);

        new Thread(){
            public void run() {
                reproductor.play();
            }
        }.start();
    }
    public void Pausar(){

        System.out.printf("Pausa");
    }
    public void Siguente(){
        System.out.printf("Siguente");
    }
    public void Anterior(){
        System.out.printf("Anterior");
    }
    public void SubirVolumen(){
        System.out.printf("SubirVolumen");
    }
    public void BajarVolumen(){
        System.out.printf("BajarVolumen");
    }
}
