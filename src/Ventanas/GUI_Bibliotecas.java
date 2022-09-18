package Ventanas;

import Clases.Biblioteca;
import Clases.Cancion;
import Clases.Usuario;
import Lectores.LectorXML;
import Listas.Bibliotecas.ListaBibliotecas;
import Listas.Bibliotecas.NodoBibliotecas;
import Listas.Canciones.ListaCanciones;
import Listas.Canciones.NodoCanciones;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI_Bibliotecas extends JFrame{
    ArrayList array = new ArrayList();
    DefaultListModel modeloJList = new DefaultListModel();
    DefaultTableModel modeloJTable = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
                return true;
        }
    };
    private JPanel panel1;
    private JList JList_Bibliotecas;
    private JTable JTable_Canciones;
    private JButton editarButton;
    private JButton btnReproductor;
    private JTextField textFieldNombre;
    private JButton eliminarButton;
    private Biblioteca bibliotecaActual;
    private JFrame frame;
    private Cancion cancionSeleccionada;
    private ListaCanciones listaCancionesTodas;
    private ListaBibliotecas listaBibliotecas;


    public GUI_Bibliotecas(Usuario usuario){
        iniciarComponentes(usuario);

        JList_Bibliotecas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(JList_Bibliotecas.getSelectedValue().toString());
                bibliotecaActual = listaBibliotecas.buscarNombre(JList_Bibliotecas.getSelectedValue().toString());
                cargarTabla(bibliotecaActual);
            }
        });
        btnReproductor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUI_Reproductor gui_reproductor = new GUI_Reproductor(bibliotecaActual.getListaCanciones());
                gui_reproductor.setVisible(true);
                frame.setVisible(false);

            }
        });
        JTable_Canciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int index = JTable_Canciones.rowAtPoint(e.getPoint());
                    String id = String.valueOf(JTable_Canciones.getValueAt(index, 0));
                    cancionSeleccionada = listaCancionesTodas.buscarId(id);
                    textFieldNombre.setText(cancionSeleccionada.getNombre());
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaCancionesTodas.modificarPorId(cancionSeleccionada.getId(),new Cancion(cancionSeleccionada.getId(), textFieldNombre.getText(), cancionSeleccionada.getDireccion()));
                LectorXML.creaCanciones(listaCancionesTodas);
                listaBibliotecas = LectorXML.leerXMLBibliotecas(usuario.getCorreoElectronico());
                bibliotecaActual = listaBibliotecas.buscarNombre(bibliotecaActual.getNombre());
                conversor(listaBibliotecas);
                cargarTabla(bibliotecaActual);
                cargarLista();

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListaCanciones listaP = bibliotecaActual.getListaCanciones();
                listaP.eliminarPorId(cancionSeleccionada.getId());
                bibliotecaActual.setListaCanciones(listaP);
                listaBibliotecas.modificarPorNombre(bibliotecaActual);
                LectorXML.creaBibliotecas(usuario.getCorreoElectronico(), listaBibliotecas);
                cargarTabla(bibliotecaActual);
            }
        });
    }

    private void iniciarComponentes(Usuario usuario){
        frame = new JFrame("Bibliotecas");
        frame.setContentPane(panel1);
        frame.setSize(530,200);
        frame.pack();
        frame.setVisible(true);
        listaBibliotecas = LectorXML.leerXMLBibliotecas(usuario.getCorreoElectronico());
        conversor(listaBibliotecas);
        bibliotecaActual = listaBibliotecas.getHead().getData();
        listaCancionesTodas = LectorXML.leerXMLCanciones();
        cargarLista();
        cargarTabla(bibliotecaActual);

        JTable_Canciones.setModel(modeloJTable);
        JList_Bibliotecas.setModel(modeloJList);



    }//iniciarComponentes

    private void cargarLista(){
        this.modeloJList.removeAllElements();
        for (Object o : array) {
            this.modeloJList.addElement(o.toString());
        }
    }

    private void cargarTabla(Biblioteca biblioteca){
        ListaCanciones listaCanciones = biblioteca.getListaCanciones();
        modeloJTable = new DefaultTableModel();
        modeloJTable.addColumn("Id");
        modeloJTable.addColumn("Nombre");

        if (!listaCanciones.vacia()){
            NodoCanciones inicio = listaCanciones.getHead();
            NodoCanciones temp = listaCanciones.getHead();
            do {
                System.out.println(temp.getData().getNombre());
                modeloJTable.addRow(new Object[]{temp.getData().getId(),temp.getData().getNombre()});
                temp = temp.getNext();
            }while (temp!=inicio);
            JTable_Canciones.setModel(modeloJTable);
        }


    }

    private ArrayList conversor(ListaBibliotecas listaBibliotecas){
        NodoBibliotecas temp = listaBibliotecas.getHead();
        array = new ArrayList();
        while (temp!=null){
            array.add(temp.getData().getNombre());
            temp = temp.getNext();
        }
        return array;
    }

}
