package Reproductor;

import Clases.Cancion;
import Listas.Canciones.ListaCanciones;
import Listas.Canciones.NodoCanciones;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

/***
 * Clase donde se crean las funcioens necesarias para nuestro reproductor
 */
public class Reproductor {
    JFXPanel fxPanel = new JFXPanel();
    private MediaPlayer reproductor;
    private ListaCanciones lista;
    private NodoCanciones cancionActual;
    private boolean repContinua;

    /***
     * Metodo constructor de Reproductor
     * @param lista lista de canciones que se reproduciran
     */
    public Reproductor(ListaCanciones lista) {
        this.lista = lista;
        this.cancionActual = lista.getHead();
        NuevaCancion(this.cancionActual.getData().getDireccion());
        repContinua = false;
    }

    /***
     * Cambia la cancion que se esta reproduciendo en el reproducor
     * @param nombreArchivo nombre de la nueva ruta a usar
     */
    public void NuevaCancion(String nombreArchivo){

        final String PATH = "Recursos/Canciones/" + nombreArchivo;
        File archivo = new File(PATH);

        Media audio = new Media(archivo.toURI().toString());

        this.reproductor = new MediaPlayer(audio);
        this.reproductor.setOnEndOfMedia(()->{
            if (cancionActual.getNext()!=lista.getHead() || isRepContinua()){
                Siguente();
            }

        });
        Reproducir();
    }

    /***
     * Reproduce la cancion que este actualmente
     */
    public void Reproducir(){
        new Thread(){
            public void run() {
                reproductor.play();
            }
        }.start();
    }

    /***
     * Pausa la cancion que esta sonando actualmente
     */
    public void Pausar(){
        reproductor.pause();
    }

    /***
     * Avanza a la siguente cancion de la lista
     */
    public void Siguente(){
        this.cancionActual=this.cancionActual.getNext();
        reproductor.stop();
        NuevaCancion(this.cancionActual.getData().getDireccion());

    }

    /***
     * Avanza a la anterior cancion de la lista
     */
    public void Anterior(){
        this.cancionActual=this.cancionActual.getPrev();
        reproductor.stop();
        NuevaCancion(this.cancionActual.getData().getDireccion());

    }

    /***
     * setea el volumen al nivel indicado
     * @param volumen volumen a poner(0-100)
     * @return retorna el volumen
     */
    public double ajustarVolumen(double volumen){
        reproductor.setVolume(volumen/100);
        return reproductor.getVolume();

    }


    /***
     * Devuelve el nombre de la cancion que esta siendo reproducida
     * @return string del nombre de la cancion
     */
    public String getCancionActual(){return cancionActual.getData().getNombre();};

    public Cancion getCancion(){
        return cancionActual.getData();
    }
    public boolean isRepContinua() {
        return repContinua;
    }

    /***
     * Cambia entre false y true repContinua
     */
    public void setRepContinua() {
        if (isRepContinua()){
            repContinua = false;
        }else {
            repContinua = true;
        }
    }
}
