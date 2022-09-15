import Clases.Biblioteca;
import Clases.Cancion;
import Listas.Bibliotecas.ListaBibliotecas;
import Listas.Canciones.ListaCanciones;
import Ventanas.GUI_Bibliotecas;
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

        ListaCanciones lista2 = new ListaCanciones();
        lista2.insertarInicio(new Cancion("The Oh Hellos： Bitter Water","The Oh Hellos： Bitter Water.mp3"));
        lista2.insertarInicio(new Cancion("The Oh Hellos： Danse Macabre","The Oh Hellos： Danse Macabre.mp3"));
        lista2.insertarInicio(new Cancion("The Oh Hellos： Dear Wormwood","The Oh Hellos： Dear Wormwood.mp3"));
        lista2.insertarInicio(new Cancion("The Oh Hellos： Exeunt","The Oh Hellos： Exeunt.mp3"));

        ListaCanciones lista3 = new ListaCanciones();

        try{


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse(new File("Canciones.xml"));

            NodeList listaCanciones = documento.getElementsByTagName("Cancion");

            for (int i = 0; i < listaCanciones.getLength(); i++) {
                Node nodo = listaCanciones.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) nodo;
                    NodeList hijos = e.getChildNodes();
                    String nombre = "";
                    String direccion = "";
                    for (int j = 0; j < hijos.getLength(); j++) {
                        Node hijo = hijos.item(j);
                        if (hijo.getNodeType() == Node.ELEMENT_NODE){
                            System.out.println(hijo.getNodeName()+"-"+hijo.getTextContent());
                            if (hijo.getNodeName().equals("Nombre")){
                                nombre = hijo.getTextContent();
                            } else if (hijo.getNodeName().equals("Direccion")) {
                                direccion = hijo.getTextContent();
                            }
                        }
                    }
                    lista3.insertarInicio(new Cancion(nombre, direccion));
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex){
            System.out.println(ex.getMessage());
        }

        ListaBibliotecas listaBibliotecas = new ListaBibliotecas();
        listaBibliotecas.insertarInicio(new Biblioteca("B1", lista));
        listaBibliotecas.insertarInicio(new Biblioteca("B2", lista));
        listaBibliotecas.insertarInicio(new Biblioteca("B3", lista));
        listaBibliotecas.insertarInicio(new Biblioteca("B4", lista));
        listaBibliotecas.insertarInicio(new Biblioteca("B5", lista2));
        listaBibliotecas.insertarInicio(new Biblioteca("XML", lista3));

        //TODO GUI

        GUI_Bibliotecas gui_bibliotecas = new GUI_Bibliotecas(listaBibliotecas);

    }//main

}//fin clase