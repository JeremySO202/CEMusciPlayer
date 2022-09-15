package Lectores;

import Clases.Cancion;
import Listas.Canciones.ListaCanciones;
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

public class LectorXML {

    public static ListaCanciones leerXML() {

        ListaCanciones lista = null;
        try {
            lista = new ListaCanciones();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse(new File("Canciones.xml"));

            NodeList listaCanciones = documento.getElementsByTagName("Cancion");

            for (int i = 0; i < listaCanciones.getLength(); i++) {
                Node nodo = listaCanciones.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) nodo;
                    NodeList hijos = e.getChildNodes();
                    String nombre = "";
                    String direccion = "";
                    for (int j = 0; j < hijos.getLength(); j++) {
                        Node hijo = hijos.item(j);
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println(hijo.getNodeName() + "-" + hijo.getTextContent());
                            if (hijo.getNodeName().equals("Nombre")) {
                                nombre = hijo.getTextContent();
                            } else if (hijo.getNodeName().equals("Direccion")) {
                                direccion = hijo.getTextContent();
                            }
                        }
                    }
                    lista.insertarInicio(new Cancion(nombre, direccion));
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

}
