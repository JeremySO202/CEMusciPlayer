import Clases.Biblioteca;
import Clases.Cancion;

import Listas.Bibliotecas.ListaBibliotecas;
import Listas.Canciones.ListaCanciones;
import Ventanas.GUI_Bibliotecas;
import Ventanas.GUI_InicioSesion;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        GUI_InicioSesion gui_inicioSesion = new GUI_InicioSesion();
        gui_inicioSesion.setVisible(true);
    }//main

}//fin clase