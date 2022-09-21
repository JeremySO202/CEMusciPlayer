package Lectores;

import Clases.Usuario;
import Listas.Usuarios.ListaUsuarios;
import Listas.Usuarios.NodoUsuarios;
import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LectorCSV {

    String archivoUsuarios;

    NodoUsuarios usuarioActual;
    ListaUsuarios listaUsuarios;


    public LectorCSV(String archivoUsuarios) {
        this.archivoUsuarios = "Usuarios.csv";
        this.listaUsuarios = new ListaUsuarios();
    }//constructor

    public ListaUsuarios extraerUsuarios(){

        try{
            CsvReader leerUsuarios = new CsvReader(this.archivoUsuarios);
            leerUsuarios.readHeaders();

            while(leerUsuarios.readRecord()){
                String nombre = leerUsuarios.get(0);

                String apellido = leerUsuarios.get(1);
                String correo = leerUsuarios.get(2);
                String provincia = leerUsuarios.get(3);
                String contraseña = leerUsuarios.get(4);

                this.listaUsuarios.insertarInicio( new Usuario(nombre, apellido, correo, provincia, contraseña));

                //usuarios.add(new Usuario(nombre, apellido, correo, provincia, contraseña));


            }//while

            leerUsuarios.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(this.listaUsuarios.getSize());

        return this.listaUsuarios;
    }
    public String getArchivoUsuarios() {
        return archivoUsuarios;
    }

    public void setArchivoUsuarios(String archivoUsuarios) {
        this.archivoUsuarios = archivoUsuarios;
    }

}//fin clase
