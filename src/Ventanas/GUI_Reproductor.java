package Ventanas;

import Clases.Biblioteca;
import Clases.Usuario;
import Lectores.LectorXML;
import Listas.Bibliotecas.ListaBibliotecas;
import Listas.Canciones.ListaCanciones;
import Reproductor.Reproductor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import Reproductor.Comunicador;

public class GUI_Reproductor extends JFrame{
    private static Comunicador comunicador = new Comunicador();
    private static boolean statusHilo;
    private static Thread hilo;
    public JPanel panelReproductor;
    private ListaCanciones lista;
    private static Reproductor reproductor;
    private static JLabel nombreCancion;
    private AdjustmentListener ajustador;
    DefaultBoundedRangeModel model;
    private static Scrollbar barraVolumen;
    private Usuario usuario;
    private ListaBibliotecas listaBibliotecas;
    private Biblioteca bibliotecaActual;
    private static JButton reproduccionContinuabtn;
    private static JButton anterior;





    /***
     * Este metodo genera la ventana para cargar componentes
     * @param lista Lista de canciones inicial
     */
    public GUI_Reproductor(Usuario usuario, ListaBibliotecas listaBibliotecas, Biblioteca biblioteca, ListaCanciones lista){
        this.lista = lista;
        this.usuario = usuario;
        this.listaBibliotecas = listaBibliotecas;
        this.bibliotecaActual = biblioteca;
        this.reproductor = new Reproductor(this.lista);
        this.setSize(700,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Reproductor");

        iniciarComponentes();

    }//GUI_Reproductor

    /***
     * Este metodo inicializa el panel, botones y etiquetas
     */
    private void iniciarComponentes(){
        colocarPanel();
        colocarEtiquetas();
        colocarBotones();
        conectarArduino();

    }//iniciarComponentes

    private void conectarArduino(){
        comunicador.conectar(comunicador.obtenerPuerto());
        comunicador.iniciarIO();
        comunicador.initListener();
        if(comunicador.getConectado()){
            iniciarHilo();
            hilo.start();
        }
    }
    private void iniciarHilo(){
        statusHilo=true;
        hilo=new Thread(){
            @Override
            public void run() {
                while(statusHilo){
                    try {
                        if (comunicador.isNuevoEvento()){
                            String[] dato = comunicador.getDato();
                            if (dato!=null&&dato.length==2){
                                double volumen = Double.parseDouble(dato[0]);
                                volumen = volumen/1023*100;
                                reproductor.ajustarVolumen(volumen);
                                barraVolumen.setValue((int) volumen);
                                switch (dato[1]){
                                    case "1":
                                        reproductor.Anterior();
                                        nombreCancion.setText(reproductor.getCancionActual());
                                        comunicador.escribir(1);
                                        break;
                                    case "2":
                                        reproductor.Reproducir();
                                        nombreCancion.setText(reproductor.getCancionActual());
                                        comunicador.escribir(2);
                                        break;
                                    case "3":
                                        reproductor.Pausar();
                                        comunicador.escribir(3);
                                        break;
                                    case "4":
                                        reproductor.Siguente();
                                        nombreCancion.setText(reproductor.getCancionActual());
                                        comunicador.escribir(4);
                                        break;
                                    case "5":
                                        reproductor.setRepContinua();
                                        if(reproductor.isRepContinua()){
                                            reproduccionContinuabtn.setBackground(Color.green);
                                        }
                                        else {
                                            reproduccionContinuabtn.setBackground(anterior.getBackground());
                                        }
                                    case "6":
                                        Biblioteca bibliotecaAgregar = listaBibliotecas.buscarNombre("Favoritas");
                                        ListaCanciones nuevaLista = bibliotecaAgregar.getListaCanciones();
                                        nuevaLista.insertarInicio(reproductor.getCancion());
                                        bibliotecaAgregar.setListaCanciones(nuevaLista);
                                        listaBibliotecas.modificarPorNombre(bibliotecaAgregar);
                                        LectorXML.creaBibliotecas(usuario.getCorreoElectronico(), listaBibliotecas);
                                }
                                comunicador.setNuevoEvento(false);
                            }
                        }
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Comunicador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        };
    }

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
        pausaB.setBounds(250,70,100,40);
        panelReproductor.add(pausaB);

        //reproducir
        JButton reproducir = new JButton("Reproducir");
        reproducir.setBounds(150,70,100,40);
        panelReproductor.add(reproducir);

        //botonSiguiente
        JButton siguiente = new JButton("Siguiente");
        siguiente.setBounds(350,70,100,40);
        panelReproductor.add(siguiente);

        //botonAnterior

        anterior = new JButton("Atrás");
        anterior.setBounds(50,70,100,40);
        panelReproductor.add(anterior);

        //botonReproduccionContinua

        reproduccionContinuabtn = new JButton("Continua");
        reproduccionContinuabtn.setBounds(450,70,100,40);
        panelReproductor.add(reproduccionContinuabtn);

        //botonfavoritos
        JButton favoritosbtn = new JButton("Favoritos");
        favoritosbtn.setBounds(550,70,100,40);
        panelReproductor.add(favoritosbtn);

        //BarraVolumen
        barraVolumen = new Scrollbar();
        barraVolumen.setOrientation(Adjustable.HORIZONTAL);
        barraVolumen.setMinimum(0);
        barraVolumen.setMaximum(110);
        barraVolumen.setValue(100);
        barraVolumen.setBounds(50,120,200,40);
        panelReproductor.add(barraVolumen);
        ajustador = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                System.out.println(e.getValue());
                System.out.println(reproductor.ajustarVolumen(e.getValue()));
            }
        };
        barraVolumen.addAdjustmentListener(ajustador);



        //Inicio ActionListeners
        ActionListener siguienteListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                reproductor.Siguente();
                nombreCancion.setText(reproductor.getCancionActual());

            }
        };
        siguiente.addActionListener(siguienteListener);

        ActionListener reproducirListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                reproductor.Reproducir();
                nombreCancion.setText(reproductor.getCancionActual());

            }
        };
        reproducir.addActionListener(reproducirListener);

        ActionListener pauseBListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.Pausar();
            }
        };
        pausaB.addActionListener(pauseBListener);


        ActionListener anteriorListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                reproductor.Anterior();
                nombreCancion.setText(reproductor.getCancionActual());

            }
        };
        anterior.addActionListener(anteriorListener);

        ActionListener continuaListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reproductor.setRepContinua();
                if(reproductor.isRepContinua()){
                    reproduccionContinuabtn.setBackground(Color.green);
                }
                else {
                    reproduccionContinuabtn.setBackground(anterior.getBackground());
                }
            }
        };
        reproduccionContinuabtn.addActionListener(continuaListener);

        ActionListener favoritosListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Biblioteca bibliotecaAgregar = listaBibliotecas.buscarNombre("Favoritas");
                ListaCanciones nuevaLista = bibliotecaAgregar.getListaCanciones();
                nuevaLista.insertarInicio(reproductor.getCancion());
                bibliotecaAgregar.setListaCanciones(nuevaLista);
                listaBibliotecas.modificarPorNombre(bibliotecaAgregar);
                LectorXML.creaBibliotecas(usuario.getCorreoElectronico(), listaBibliotecas);
            }
        };
        favoritosbtn.addActionListener(favoritosListener);
        //fin actionlisteners

    }//colocarBotones

    /***
     * Este metodo crea y pega las etiquetas
     */
    private void colocarEtiquetas(){
        nombreCancion = new JLabel(reproductor.getCancionActual());
        nombreCancion.setBounds(180,5,200,40);

        panelReproductor.add(nombreCancion);
    }//colocarVentanas




}//fin clase GUI_Reproductor
