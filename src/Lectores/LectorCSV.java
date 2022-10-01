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

    /***
     * extrae lo usuarios del CSV y los carga en una lista de usuarios
     * @return retorna la lista con los usuarios
     */
    public ListaUsuarios extraerUsuarios(){

        try{
            CsvReader leerUsuarios = new CsvReader(this.archivoUsuarios);
            leerUsuarios.readHeaders();

            while(leerUsuarios.readRecord()){
                String nombre = leerUsuarios.get(0);

                String apellido = leerUsuarios.get(1);
                String correo = leerUsuarios.get(2);
                String provincia = leerUsuarios.get(3);
                String contrasena = leerUsuarios.get(4);

                this.listaUsuarios.insertarInicio( new Usuario(nombre, apellido, correo, provincia, contrasena));


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

    /***
     * Retorna el nombre del archivo
     * @return el nombre del archivo
     */
    public String getArchivoUsuarios() {
        return archivoUsuarios;
    }

    /***
     * Cambia el nombre del archivo
     * @param archivoUsuarios nuevo nombre del archivo
     */
    public void setArchivoUsuarios(String archivoUsuarios) {
        this.archivoUsuarios = archivoUsuarios;
    }

}//fin clase
