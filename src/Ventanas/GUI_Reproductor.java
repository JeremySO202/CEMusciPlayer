package Ventanas;

import Listas.Canciones.ListaCanciones;
import Reproductor.Reproductor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Reproductor extends JFrame{
    public JPanel panelReproductor;
    private ListaCanciones lista;
    private Reproductor reproductor;



    /***
     * Este metodo genera la ventana para cargar componentes
     * @param lista Lista de canciones inicial
     */
    public GUI_Reproductor(ListaCanciones lista){
        this.lista = lista;
        this.reproductor = new Reproductor(this.lista);
        this.setSize(530,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Reproductor");

        JButton pause = new JButton();
        pause.setText("Pause");
        pause.setBounds(100,100,100,40);
        pause.setEnabled(true);
        iniciarComponentes();
    }//GUI_Reproductor

    /***
     * Este metodo inicializa el panel, botones y etiquetas
     */
    private void iniciarComponentes(){
        colocarPanel();
        colocarEtiquetas();
        colocarBotones();


    }//iniciarComponentes

    /***
     * Este metodo crea el panel y lo pega en la ventana
     */
    private void colocarPanel(){
        panelReproductor = new JPanel();
        panelReproductor.setLayout(null);
        this.getContentPane().add(panelReproductor);

    }//colocarPanel

    private void colocarCanciones(ListaCanciones lista){
        
    }

    /***
     * Este metodo crea y pega los botones en el panel
     * Este metodo incluye los actionlistener de todos los botones
     */
    private void colocarBotones(){
        //botonPausaB
        JButton pausaB = new JButton("Pausa");
        pausaB.setBounds(50,70,100,40);
        panelReproductor.add(pausaB);

        //reproducir
        JButton reproducir = new JButton("Reproducir");
        reproducir.setBounds(150,70,100,40);
        panelReproductor.add(reproducir);

        //botonSiguiente
        JButton siguiente = new JButton("Siguiente");
        siguiente.setBounds(250,70,100,40);
        panelReproductor.add(siguiente);

        //botonAnterior
        JButton anterior = new JButton("Atrás");
        anterior.setBounds(350,70,100,40);
        panelReproductor.add(anterior);

        //subirVolumen
        JButton subirVolumen = new JButton("+");
        subirVolumen.setBounds(450,70,45,40);
        panelReproductor.add(subirVolumen);

        //bajarVolumen
        JButton bajarVolumen = new JButton("-");
        bajarVolumen.setBounds(10,70,45,40);
        panelReproductor.add(bajarVolumen);


        //Inicio ActionListeners
        ActionListener pauseBListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                reproductor.Pausar();

            }
        };
        pausaB.addActionListener(pauseBListener);

        ActionListener reproducirListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                reproductor.Reproducir();
                colocarEtiquetas();

            }
        };
        reproducir.addActionListener(reproducirListener);

        ActionListener siguienteListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.Siguente();
                colocarEtiquetas();
            }
        };
        siguiente.addActionListener(siguienteListener);
        ActionListener anteriorListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.Anterior();
                colocarEtiquetas();
            }
        };
        anterior.addActionListener(anteriorListener);

        ActionListener subirVolumenListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.SubirVolumen();
            }
        };
        subirVolumen.addActionListener(subirVolumenListener);

        ActionListener bajarVolumenListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.BajarVolumen();
            }
        };
        bajarVolumen.addActionListener(bajarVolumenListener);

        //fin actionlisteners

    }//colocarBotones

    /***
     * Este metodo crea y pega las etiquetas
     */
    private void colocarEtiquetas(){
        JLabel nombreCancion = new JLabel(reproductor.getCancionActual());
        nombreCancion.setBounds(180,5,200,40);

        panelReproductor.add(nombreCancion);
    }//colocarVentanas


}//fin clase GUI_Reproductor
