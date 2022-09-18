package Ventanas;

import Clases.Biblioteca;
import Clases.Usuario;
import Lectores.LectorXML;
import Listas.Bibliotecas.ListaBibliotecas;
import Listas.Canciones.ListaCanciones;
import com.csvreader.CsvWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GUI_RegistroUsuario extends JFrame {

    public JPanel panelRegistroUsuario;
    private Usuario usuario;

    /***
     * Este es el constructor de la clase GUI_RegistroUsuario
     * En el constructor se crea la ventana
     */
    public GUI_RegistroUsuario() {
        this.setSize(500,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Registro");

        iniciarComponentesRegistro();
    }//constructor

    /***
     * Este metodo crea los componentes para la ventana de Registro
     * Componentes tales como: Panel, labels, Fields, Botones
     */
    public void iniciarComponentesRegistro(){
        //Panel de Registro
        panelRegistroUsuario = new JPanel();
        panelRegistroUsuario.setLayout(null);
        this.getContentPane().add(panelRegistroUsuario);

        //Label Nombre
        JLabel nombreLbl = new JLabel("Nombre: ");
        nombreLbl.setBounds(50,0,200,30);
        nombreLbl.setFont(new Font("arial",Font.PLAIN,20 ));
        panelRegistroUsuario.add(nombreLbl);

        //Field Nombre
        JTextField nombreField = new JTextField();
        nombreField.setBounds(50,50,200,30);
        panelRegistroUsuario.add(nombreField);

        //Label Apellido
        JLabel apellidoLbl = new JLabel("Apellido: ");
        apellidoLbl.setBounds(50,90,200,30);
        apellidoLbl.setFont(new Font("arial",Font.PLAIN,20 ));
        panelRegistroUsuario.add(apellidoLbl);

        //Field Apellido
        JTextField apellidoField = new JTextField();
        apellidoField.setBounds(50,140,200,30);
        panelRegistroUsuario.add(apellidoField);

        //Label Correo
        JLabel correoLbl = new JLabel("Correo: ");
        correoLbl.setBounds(50,180,200,30);
        correoLbl.setFont(new Font("arial",Font.PLAIN,20 ));
        panelRegistroUsuario.add(correoLbl);

        //Field Correo
        JTextField correoField = new JTextField();
        correoField.setBounds(50,230,200,30);
        panelRegistroUsuario.add(correoField);


        //
        String [] paises = {"San Jose", "Cartago", "Limon", "Alajuela" , "Guanacaste", "Puntarenas", "Heredia"};
        JComboBox listaProvincias = new JComboBox(paises);
        listaProvincias.setBounds(300,270,100,30);
        panelRegistroUsuario.add(listaProvincias);


        //Label Contraseña
        JLabel contraseñaLbl = new JLabel("Contraseña: ");
        contraseñaLbl.setBounds(50,270,200,30);
        contraseñaLbl.setFont(new Font("arial",Font.PLAIN,20 ));
        panelRegistroUsuario.add(contraseñaLbl);

        //Field Contraseña
        JTextField contraseñaField = new JTextField();
        contraseñaField.setBounds(50,320,200,30);
        panelRegistroUsuario.add(contraseñaField);

        //Boton de registro
        JButton registroBtn = new JButton("Registrar");
        registroBtn.setBounds(300,380,150,40);
        panelRegistroUsuario.add(registroBtn);

        ActionListener registroBtnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario(nombreField.getText(),apellidoField.getText(),correoField.getText(), (String) listaProvincias.getSelectedItem(),contraseñaField.getText());
                escribirCSV(usuario);
                }
        };
        registroBtn.addActionListener(registroBtnListener);

    }//iniciarComponentesRegistro

    /***
     * Este metodo va a escribir en el CSV para almacenar datos de los Usuarios
     * Datos tales como: Nombre, Apellido, Correo, Provincia, Contraseña
     */
    public void escribirCSV(Usuario usuario){
        String salidaArchivo = "Usuarios.csv";
        boolean existe = new File(salidaArchivo).exists();

        if (existe){
            File archivoUsuarios = new File(salidaArchivo);
            try{
                CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

                salidaCSV.write(usuario.getNombre() );
                salidaCSV.write(usuario.getApellido() );
                salidaCSV.write(usuario.getCorreoElectronico());
                salidaCSV.write(usuario.getProvincia());
                salidaCSV.write(usuario.getContrasena());
                salidaCSV.endRecord();


                salidaCSV.close();
            }catch(IOException e){
                e.printStackTrace();

            }//try-catch
            //archivoUsuarios.delete();

        } else {
            try{
                CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');
                salidaCSV.write("Nombre");
                salidaCSV.write("Apellidos");
                salidaCSV.write("Correo");
                salidaCSV.write("Provincia");
                salidaCSV.write("Contraseña");

                salidaCSV.endRecord();

                salidaCSV.write(usuario.getNombre() );
                salidaCSV.write(usuario.getApellido() );
                salidaCSV.write(usuario.getCorreoElectronico());
                salidaCSV.write(usuario.getProvincia());
                salidaCSV.write(usuario.getContrasena());
                salidaCSV.endRecord();


                salidaCSV.close();
            }catch(IOException e){
                e.printStackTrace();

            }//try-catch
        }//else
        ListaCanciones listaCanciones = new ListaCanciones();
        listaCanciones = LectorXML.leerXMLCanciones();
        ListaBibliotecas listaBibliotecas = new ListaBibliotecas();
        listaBibliotecas.insertarInicio(new Biblioteca("Todas",listaCanciones));
        LectorXML.creaBibliotecas(usuario.getCorreoElectronico(),listaBibliotecas);

        //        "Recursos/Bibliotecas/"+correo+".xml"

    }//escribirCSV



}//Fin clase
