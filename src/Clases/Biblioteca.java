package Clases;

import Listas.Canciones.ListaCanciones;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//TODO Terminar
public class Biblioteca {
    private String nombre;
    private ListaCanciones listaCanciones;
    private String fecha;

    public Biblioteca(String nombre, ListaCanciones listaCanciones) {
        this.nombre = nombre;
        this.listaCanciones = listaCanciones;
        this.fecha = DateTimeFormatter.ofPattern("dd/MM/dd HH:mm").format(LocalDateTime.now());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaCanciones getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(ListaCanciones listaCanciones) {
        this.listaCanciones = listaCanciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
