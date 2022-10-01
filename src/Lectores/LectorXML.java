package Lectores;

import Clases.Biblioteca;
import Clases.Cancion;
import Listas.Bibliotecas.ListaBibliotecas;
import Listas.Bibliotecas.NodoBibliotecas;
import Listas.Canciones.ListaCanciones;
import Listas.Canciones.NodoCanciones;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class LectorXML {

    /***
     * crea el xml con una lista de canciones
     * @param listaCanciones lista de canciones a guardar
     */
    public static void creaCanciones(ListaCanciones listaCanciones){
        try {
            NodoCanciones cancionPrimera = listaCanciones.getHead();
            NodoCanciones actual = cancionPrimera;

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document document = implementation.createDocument(null, "Canciones", null);
            document.setXmlVersion("1.0");
            do {

                //Recorrer listaCanciones
                Element cancion = document.createElement("Cancion");

                Element idCancion = document.createElement("Id");
                Text textIdCancion = document.createTextNode(actual.getData().getId());
                idCancion.appendChild(textIdCancion);
                cancion.appendChild(idCancion);

                Element nombreCancion = document.createElement("Nombre");
                Text textnombreCancion = document.createTextNode(actual.getData().getNombre());
                nombreCancion.appendChild(textnombreCancion);
                cancion.appendChild(nombreCancion);

                Element direccionCancion = document.createElement("Direccion");
                Text textDireccionCancion = document.createTextNode(actual.getData().getDireccion());
                direccionCancion.appendChild(textDireccionCancion);
                cancion.appendChild(direccionCancion);

                Element generoCancion = document.createElement("Genero");
                Text textGeneroCancion = document.createTextNode(actual.getData().getGenero());
                generoCancion.appendChild(textGeneroCancion);
                cancion.appendChild(generoCancion);

                Element artistaCancion = document.createElement("Artista");
                Text textArtistaCancion = document.createTextNode(actual.getData().getArtista());
                artistaCancion.appendChild(textArtistaCancion);
                cancion.appendChild(artistaCancion);

                Element albumCancion = document.createElement("Album");
                Text textAlbumCancion = document.createTextNode(actual.getData().getAlbum());
                albumCancion.appendChild(textAlbumCancion);
                cancion.appendChild(albumCancion);

                Element anoCancion = document.createElement("Ano");
                Text textAnoCancion = document.createTextNode(actual.getData().getAno());
                anoCancion.appendChild(textAnoCancion);
                cancion.appendChild(anoCancion);

                Element letraCancion = document.createElement("Letra");
                Text textLetraCancion = document.createTextNode(actual.getData().getLetra());
                letraCancion.appendChild(textLetraCancion);
                cancion.appendChild(letraCancion);

                document.getDocumentElement().appendChild(cancion);

                actual = actual.getNext();
                //fin ciclo

            }while (cancionPrimera != actual);
            Source source = new DOMSource(document);
            Result result = new StreamResult("Canciones.xml");

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getMessage());
        }

    }

    /***
     * Carga los datos del XML en la listaCanciones
     * @return retorna la lista con las canciones de las canciones cargadas
     */
    public static ListaCanciones leerXMLCanciones() {

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
                    String id = "";
                    String nombre = "";
                    String direccion = "";
                    String genero = "";
                    String artista = "";
                    String album = "";
                    String ano = "";
                    String letra = "";
                    for (int j = 0; j < hijos.getLength(); j++) {
                        Node hijo = hijos.item(j);
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            switch (hijo.getNodeName()) {
                                case "Id":
                                    id = hijo.getTextContent();
                                    break;
                                case "Nombre":
                                    nombre = hijo.getTextContent();
                                    break;
                                case "Direccion":
                                    direccion = hijo.getTextContent();
                                    break;
                                case "Genero":
                                    genero = hijo.getTextContent();
                                    break;
                                case "Artista":
                                    artista = hijo.getTextContent();
                                    break;
                                case "Album":
                                    album = hijo.getTextContent();
                                    break;
                                case "Ano":
                                    ano = hijo.getTextContent();
                                    break;
                                case "Letra":
                                    letra = hijo.getTextContent();
                                    break;
                            }
                        }
                    }
                    lista.insertarInicio(new Cancion(id, nombre, direccion,genero,artista,album,ano,letra));
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    /***
     * crea el XML del usuarios donde se almacenaran las bibliotecas de este
     * @param usuario
     * @param listaBibliotecas
     */
    public static void creaBibliotecas(String usuario, ListaBibliotecas listaBibliotecas){
        try {
            NodoBibliotecas actualBiblioteca = listaBibliotecas.getHead();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document document = implementation.createDocument(null, "Bibliotecas", null);
            document.setXmlVersion("1.0");
            String nombreplaylist = "";
            do {
                if (actualBiblioteca!=null){

                    nombreplaylist = actualBiblioteca.getData().getNombre();
                }
                Element biblioteca = document.createElement("Biblioteca");

                Element nombre = document.createElement("Nombre");
                Text textNombre = document.createTextNode(nombreplaylist);
                nombre.appendChild(textNombre);
                biblioteca.appendChild(nombre);

                Element fecha = document.createElement("Fecha");
                Text textFecha = document.createTextNode(actualBiblioteca.getData().getFecha());
                fecha.appendChild(textFecha);
                biblioteca.appendChild(fecha);

                Element canciones = document.createElement("Canciones");

                //Recorrer listaCanciones
                ListaCanciones listaCanciones = actualBiblioteca.getData().getListaCanciones();

                NodoCanciones cancionPrimera = listaCanciones.getHead();
                NodoCanciones actual = cancionPrimera;

                if (actual!=null){
                    do {
                        Element cancion = document.createElement("Cancion");

                        Element idCancion = document.createElement("Id");
                        Text textIdCancion = document.createTextNode(actual.getData().getId());
                        idCancion.appendChild(textIdCancion);
                        cancion.appendChild(idCancion);

                        canciones.appendChild(cancion);

                        actual = actual.getNext();
                    } while (cancionPrimera != actual);
                }


                //fin ciclo

                biblioteca.appendChild(canciones);


                document.getDocumentElement().appendChild(biblioteca);

                Source source = new DOMSource(document);
                Result result = new StreamResult("Recursos/Bibliotecas/" + usuario + ".xml");

                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(source, result);

                actualBiblioteca = actualBiblioteca.getNext();

            }while (actualBiblioteca!=null);

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getMessage());
        }

    }

    /***
     * Carga los datos del XML en la lista de bibliotecas de un usuario
     * @param usuario correo del usuario del que queremos cargar los datos
     * @return lista de las biblitecas del usuarios
     */
    public static ListaBibliotecas leerXMLBibliotecas(String usuario) {

        ListaBibliotecas listaBibliotecasFinal = new ListaBibliotecas();
        ListaCanciones listaCancionesTotal = leerXMLCanciones();

        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse(new File("Recursos/Bibliotecas/"+usuario+".xml"));

            NodeList listaBiblioteca = documento.getElementsByTagName("Biblioteca");

            for (int i = 0; i < listaBiblioteca.getLength(); i++) {
                ListaCanciones listaCanciones = new ListaCanciones();
                Node nodo = listaBiblioteca.item(i);
                String nombreBiblioteca = "";
                String fechaBiblioteca = "";
                if (nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element e = (Element) nodo;
                    NodeList biblioteca = e.getChildNodes();
                    for (int j = 0; j < biblioteca.getLength(); j++) {
                        Node dataBiblioteca = biblioteca.item(j);
                        if (dataBiblioteca.getNodeType() == Node.ELEMENT_NODE){
                            switch (dataBiblioteca.getNodeName()){
                                case "Nombre":
                                    nombreBiblioteca = dataBiblioteca.getTextContent();
                                    break;
                                case "Fecha":
                                    fechaBiblioteca = dataBiblioteca.getTextContent();
                                    break;
                                case "Canciones":
                                    NodeList canciones = dataBiblioteca.getChildNodes();
                                    for (int k = 0; k < canciones.getLength(); k++) {
                                        Node Cancion = canciones.item(k);
                                        if (Cancion.getNodeType()==Node.ELEMENT_NODE){
                                            NodeList listaCancionesP = Cancion.getChildNodes();
                                            for (int l = 0; l < listaCancionesP.getLength(); l++) {
                                                Node dataCancion = listaCancionesP.item(l);
                                                if (dataCancion.getNodeType()==Node.ELEMENT_NODE){
                                                    if (dataCancion.getNodeName().equals("Id")){
                                                        System.out.println(dataCancion.getTextContent());
                                                        listaCanciones.insertarInicio(listaCancionesTotal.buscarId(dataCancion.getTextContent()));
                                                        System.out.println(listaCanciones.getHead().getData().getNombre());
                                                    }
                                                }
                                            }
                                        }
                                    }
                            }
                        }
                    }
                    listaBibliotecasFinal.insertarInicio(new Biblioteca(nombreBiblioteca,listaCanciones, fechaBiblioteca));

                }

            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println();
        return listaBibliotecasFinal;
    }
}
