package Lectores;

import Clases.Usuario;
import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {

    String archivoUsuarios;

    public LectorCSV() {
        this.archivoUsuarios = "Usuarios.csv";

    }//Contructor

    public List<Usuario> extraerUsuarios(){
        List<Usuario> usuarios = new ArrayList<Usuario>();

        try{
            CsvReader leerUsuarios = new CsvReader(this.archivoUsuarios);
            leerUsuarios.readHeaders();

            while(leerUsuarios.readRecord()){
                String nombre = leerUsuarios.get(0);
                String apellidos = leerUsuarios.get(1);
                String correo = leerUsuarios.get(2);
                String provincia = leerUsuarios.get(3);
                String contrasena = leerUsuarios.get(4);


                usuarios.add(new Usuario(nombre,apellidos,correo,provincia,contrasena));
                System.out.println(nombre+apellidos+correo+provincia+contrasena);


            }//while

            leerUsuarios.close();

        } catch(IOException e){
            e.printStackTrace();
        }//try-catch

        return usuarios;
    }//leectorCSV

}//LectorCSV
