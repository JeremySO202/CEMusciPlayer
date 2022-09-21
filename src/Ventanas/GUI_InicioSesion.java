package Ventanas;

import Clases.Biblioteca;
import Clases.Cancion;
import Clases.Usuario;
import Lectores.LectorCSV;
import Lectores.LectorXML;
import Listas.Bibliotecas.ListaBibliotecas;
import Listas.Canciones.ListaCanciones;
import Listas.Usuarios.ListaUsuarios;
import Listas.Usuarios.NodoUsuarios;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI_InicioSesion extends JFrame {

    ListaUsuarios usuariosRegistrados;
    NodoUsuarios usuarioActual;
    public JPanel panelInicioSesion;
    public JTextField usuarioField;
    public LectorCSV lectorCSV;

    /***
     * Este es el contructor de la clase GUI_InicioSesio
     */
    public GUI_InicioSesion() {
        this.setSize(500, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Registro");
        this.lectorCSV = new LectorCSV("Usuarios.csv");
        iniciarComponentesInicioSesion();
    }//constructor

    /***
     * Este metodo crea los componentes para la ventana de Inicio de Sesion
     * Componentes tales como: labels, Fields, Botones con sus respectivos action listener
     */
    public void iniciarComponentesInicioSesion() {

        //Panel de Inicio Sesion
        panelInicioSesion = new JPanel();
        panelInicioSesion.setLayout(null);
        this.getContentPane().add(panelInicioSesion);

        //Label Usuario
        JLabel usuarioLbl = new JLabel("Ingrese el usuario:");
        usuarioLbl.setBounds(140, 10, 200, 30);
        usuarioLbl.setFont(new Font("berlin sans fb", Font.PLAIN, 20));
        panelInicioSesion.add(usuarioLbl);

        //Barra de escritura usuario
        JTextField usuarioField = new JTextField();
        usuarioField.setBounds(142, 50, 200, 30);
        panelInicioSesion.add(usuarioField);

        //Label Contraseña
        JLabel contraseñaLbl = new JLabel("Ingrese la contraseña:");
        contraseñaLbl.setBounds(148, 100, 200, 30);
        contraseñaLbl.setFont(new Font("berlin sans fb", Font.PLAIN, 20));
        panelInicioSesion.add(contraseñaLbl);

        //Barra de escritura contraseña
        JPasswordField contrasenaField;
        contrasenaField = new JPasswordField();
        contrasenaField.setBounds(142, 140, 200, 30);
        panelInicioSesion.add(contrasenaField);

        //Boton de Inicio de sesion
        JButton inicioSesionBtn = new JButton("Iniciar Sesion");
        inicioSesionBtn.setBounds(70, 190, 150, 40);
        inicioSesionBtn.setFont(new Font("berlin sans fb", Font.PLAIN, 20));
        panelInicioSesion.add(inicioSesionBtn);

        //Boton de registrro
        JButton registroBtn = new JButton("Registrar");
        registroBtn.setBounds(270, 190, 150, 40);
        registroBtn.setFont(new Font("berlin sans fb", Font.PLAIN, 20));
        panelInicioSesion.add(registroBtn);

        //inisioSesionbtn Actionlistener
        ActionListener inicioSesionBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                while (usuarioField.getText().equals("") || contrasenaField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "No ingresó algun dato");
                    return;
                }

                usuariosRegistrados = null;
                usuariosRegistrados = lectorCSV.extraerUsuarios();
                usuarioActual = usuariosRegistrados.getHead();


                for (int i = 0; i < usuariosRegistrados.getSize(); i++) {
                    if (usuarioActual.getData().getNombre().equals(usuarioField.getText()) && usuarioActual.getData().getContrasena().equals(contrasenaField.getText())) {
                        dispose();
                        dispose();
                        GUI_Bibliotecas gui_bibliotecas = new GUI_Bibliotecas(usuariosRegistrados.getHead().getData());
                        return;
                        //ListaCanciones lista = LectorXML.leerXML();
                        //ListaBibliotecas listaBibliotecas = new ListaBibliotecas();
                        //listaBibliotecas.insertarInicio(new Biblioteca("Playlist 1", lista));
                        //GUI_Bibliotecas gui_bibliotecas = new GUI_Bibliotecas(listaBibliotecas);

                    }
                    usuarioActual = usuarioActual.getNext();
                }//for
                JOptionPane.showMessageDialog(null, "Usuarios o contraseña incorrecta");



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
}//fin clase
