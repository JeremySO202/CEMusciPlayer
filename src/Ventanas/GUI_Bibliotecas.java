package Ventanas;

import Listas.Bibliotecas.ListaBibliotecas;
import Listas.Bibliotecas.NodoBibliotecas;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;

public class GUI_Bibliotecas extends JFrame{
    ArrayList array = new ArrayList();
    DefaultListModel modelo = new DefaultListModel();
    private JPanel panel1;
    private JList JList_Bibliotecas;
    private JTable JTable_Canciones;


    public GUI_Bibliotecas(ListaBibliotecas listaBibliotecas){
        JFrame frame = new JFrame("Bibliotecas");
        frame.setContentPane(panel1);
        frame.setSize(530,200);
        frame.pack();
        frame.setVisible(true);
        System.out.println(listaBibliotecas.getHead().getData().getNombre());
        conversor(listaBibliotecas);
        JList_Bibliotecas.setModel(modelo);
        cargarLista();

        JList_Bibliotecas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println(JList_Bibliotecas.getSelectedValue().toString());
            }
        });
    }

    private void iniciarComponentes(){




    }//iniciarComponentes

    private void cargarLista(){
        modelo.removeAllElements();
        modelo.addElement("Todas");
        for (int i = 0; i < array.size(); i++) {
            modelo.addElement(array.get(i));
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
