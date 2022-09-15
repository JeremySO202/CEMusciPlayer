package Ventanas;

import Clases.Biblioteca;
import Listas.Bibliotecas.ListaBibliotecas;
import Listas.Bibliotecas.NodoBibliotecas;
import Listas.Canciones.ListaCanciones;
import Listas.Canciones.NodoCanciones;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI_Bibliotecas extends JFrame{
    ArrayList array = new ArrayList();
    DefaultListModel modeloJList = new DefaultListModel();
    DefaultTableModel modeloJTable = new DefaultTableModel();
    private JPanel panel1;
    private JList JList_Bibliotecas;
    private JTable JTable_Canciones;
    private JButton button1;
    private JButton btnReproductor;
    private Biblioteca bibliotecaActual;
    private JFrame frame;


    public GUI_Bibliotecas(ListaBibliotecas listaBibliotecas){
        frame = new JFrame("Bibliotecas");
        frame.setContentPane(panel1);
        frame.setSize(530,200);
        frame.pack();
        frame.setVisible(true);
        System.out.println(listaBibliotecas.getHead().getData().getNombre());
        conversor(listaBibliotecas);
        JTable_Canciones.setModel(modeloJTable);
        JList_Bibliotecas.setModel(modeloJList);
        bibliotecaActual = listaBibliotecas.getHead().getData();
        cargarLista();
        cargarTabla(bibliotecaActual);


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
    }

    private void iniciarComponentes(){




    }//iniciarComponentes

    private void cargarLista(){
        modeloJList.removeAllElements();
        modeloJList.addElement("Todas");
        for (int i = 0; i < array.size(); i++) {
            modeloJList.addElement(array.get(i));
        }


    }

    private void cargarTabla(Biblioteca biblioteca){
        ListaCanciones listaCanciones = biblioteca.getListaCanciones();
        modeloJTable = new DefaultTableModel();
        modeloJTable.addColumn("Nombre");
        if (!listaCanciones.vacia()){
            NodoCanciones inicio = listaCanciones.getHead();
            NodoCanciones temp = listaCanciones.getHead();
            do {
                System.out.println(temp.getData().getNombre());
                modeloJTable.addRow(new Object[]{temp.getData().getNombre()});
                temp = temp.getNext();
            }while (temp!=inicio);
            JTable_Canciones.setModel(modeloJTable);
        }


    }

    private ArrayList conversor(ListaBibliotecas listaBibliotecas){
        NodoBibliotecas temp = listaBibliotecas.getHead();
        while (temp!=null){
            System.out.println(temp.getData().getNombre());
            array.add(temp.getData().getNombre());
            temp = temp.getNext();
        }
        return array;
    }

}
