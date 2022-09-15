package Ventanas;

import Clases.Cancion;
import Listas.ListaCanciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_InicioSesion extends JFrame {
    public JPanel panelInicioSesion;
    public JTextField usuarioField;

    /***
     * Este es el contructor de la clase GUI_InicioSesio
     */
    public GUI_InicioSesion() {
        this.setSize(520,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Registro");
        iniciarComponentesInicioSesion();
    }//constructor

    /***
     * Este metodo crea los componentes para la ventana de Inicio de Sesion
     * Componentes tales como: labels, Fields, Botones con sus respectivos action listener
     */
    public void iniciarComponentesInicioSesion(){

        //Panel de Inicio Sesion
        panelInicioSesion = new JPanel();
        panelInicioSesion.setLayout(null);
        this.getContentPane().add(panelInicioSesion);

        //Componentes

        //Label Usuario
        JLabel usuarioLbl = new JLabel("Ingrese el usuario");
        usuarioLbl.setBounds(160,0,200,40);
        usuarioLbl.setFont(new Font("arial",Font.PLAIN,20 ));
        panelInicioSesion.add(usuarioLbl);

        //Barra de escritura usuario
        JTextField usuarioField = new JTextField();
        usuarioField.setBounds(142,50,200,30);
        panelInicioSesion.add(usuarioField);



        //Etiqueta Contraseña
        JLabel contraseñaLbl = new JLabel("Ingrese la contraseña");
        contraseñaLbl.setBounds(148,90,200,40);
        contraseñaLbl.setFont(new Font("arial",Font.PLAIN,20 ));
        panelInicioSesion.add(contraseñaLbl);

        //Barra de escritura contraseña
        JPasswordField contraseñaField = new JPasswordField();
        contraseñaField.setBounds(142,140,200,30);
        panelInicioSesion.add(contraseñaField);

        //Boton de Inicio de sesion
        JButton inicioSesionBtn = new JButton("Iniciar Sesion");
        inicioSesionBtn.setBounds(70,190,150,40);
        panelInicioSesion.add(inicioSesionBtn);

        //Boton de registrro
        JButton registroBtn = new JButton("Registrar");
        registroBtn.setBounds(270,190,150,40);
        panelInicioSesion.add(registroBtn);

        //inisioSesionbtn Actionlistener
        ActionListener inicioSesionBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuarioField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"No ingresó el usuario");
                }if (contraseñaField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"No ingresó la contraseña");
                }else {
                    dispose();
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

                    GUI_Reproductor gui_reproductor = new GUI_Reproductor(lista);
                    gui_reproductor.setVisible(true);
                }

            }
        };
        inicioSesionBtn.addActionListener(inicioSesionBtnListener);


        //registrobtn Actionlistener
        ActionListener registroBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GUI_RegistroUsuario gui_registroUsuario = new GUI_RegistroUsuario();
                gui_registroUsuario.setVisible(true);
            }
        };
        registroBtn.addActionListener(registroBtnListener);


    }//iniciarComponentes

}//GUI_Registro
