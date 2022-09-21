package Reproductor;

import gnu.io.*;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;

public class Comunicador implements SerialPortEventListener{
    CommPortIdentifier portId;
    Enumeration cuantosPuertos;
    InputStream input=null;
    OutputStream output=null;
    HashMap portMap=new HashMap();
    SerialPort serialPort=null;

    boolean conectado=false;
    public String dato ="";
    private boolean nuevoEvento = false;

    public void initListener(){
        try{
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);

        }catch(Exception E){
            System.out.println(E.getMessage());
        }

    }
    public String getDato(){
        return dato;
    }

    public void serialEvent(SerialPortEvent spe) {
        if(spe.getEventType() == SerialPortEvent.DATA_AVAILABLE){
            try{
                byte datoSimple=(byte) input.read();
                if(datoSimple != 10 && datoSimple != 13){
                    String texto = new String(new byte[]{datoSimple} );
                    this.dato = texto;
                    nuevoEvento = true;
                }
            }catch(Exception e){
                System.out.println("ERROR lectura: "+e.getMessage());
            }//llave catch
        }//llave if
    }

    public String obtenerPuerto(){
        cuantosPuertos=CommPortIdentifier.getPortIdentifiers();
        String resultado="";
        while(cuantosPuertos.hasMoreElements()){
            CommPortIdentifier puerto=(CommPortIdentifier)cuantosPuertos.nextElement();
            if(puerto.getPortType()==CommPortIdentifier.PORT_SERIAL){
                if (puerto.getName().equals("COM3")){//Funciona solo con COM3
                    portMap.put(puerto.getName(),puerto);
                    return puerto.getName();
                }

            }
        }//LLAVE WHILE
        return null;
    }

    public void conectar(String cualPuerto){
        System.out.println(cualPuerto);
        portId=(CommPortIdentifier) portMap.get(cualPuerto);
        CommPort commport=null;
        try{
            commport=portId.open("TigerControlPanel",1000);
            //cast
            serialPort=(SerialPort) commport;
            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            setConectado(true);
        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }//llave conectar

    public void setConectado(boolean estado){
        this.conectado=estado;
    }//llave setConectado
    public boolean getConectado(){
        return this.conectado;
    }//llave getConectado
    public void desconectar(){
        try{
            serialPort.removeEventListener();
            serialPort.close();
            input.close();
            output.close();
            setConectado(false);

        }catch(Exception e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }//llave desconectar
    public boolean iniciarIO(){
        try{
            input=serialPort.getInputStream();
            output=serialPort.getOutputStream();
            return true;
        }catch(Exception yea){
            System.out.println("ERROR AL INICIAR IO "+ yea);
            return false;
        }//llave catch

    }//llave io

    public void escribir(int _texto) {
        try {
            output.write((_texto + "").getBytes());
            output.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "1111");
        }
    }

    public boolean isNuevoEvento() {
        return nuevoEvento;
    }

    public void setNuevoEvento(boolean nuevoEvento) {
        this.nuevoEvento = nuevoEvento;
    }
}
