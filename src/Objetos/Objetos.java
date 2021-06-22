package Objetos;
import Personajes.*;


public class Objetos extends General {

    public String localizacion;
    private final String localizacion_final;


    public Objetos(String nombre, String localizacion, String localizacion_final) {
        super(nombre);               //A LA CLASE GENERAL
        this.localizacion = localizacion;
        this.localizacion_final = localizacion_final;
    }

    public String getlocalizacion(){
        return localizacion;
    }

    public void setLocalizacion(String localizacion){
        this.localizacion = localizacion;
    }

    public String getlocalizacionFinal(){
        return localizacion_final;
    }

    public void imprimir() {
        System.out.println("En la sala " + this.localizacion + " se encuentra el objeto " + this.getNombre()+ " y su objetivo es: " + this.getlocalizacionFinal());
    }


    

}
