package Reproductor;

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

    /***
     * Metodo constructor de Reproductor
     * @param lista lista de canciones que se reproduciran
     */
    public Reproductor(ListaCanciones lista) {
        this.lista = lista;
        this.cancionActual = lista.getHead();
        NuevaCancion(this.cancionActual.getData().getDireccion());
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
    public void SubirVolumen(){
        double volumen = reproductor.getVolume()*100;
        if (volumen < 100){
            volumen= volumen + 20;
            reproductor.setVolume(volumen/100);
        }
        System.out.println(volumen);

    }
    public void BajarVolumen(){
        double volumen = reproductor.getVolume()*100;
        if (volumen > 0){
            volumen = volumen - 20;
            reproductor.setVolume(volumen/100);
        }
        System.out.println(volumen);

    }

    /***
     * Devuelve el nombre de la cancion que esta siendo reproducida
     * @return string del nombre de la cancion
     */
    public String getCancionActual(){return cancionActual.getData().getNombre();};
}
