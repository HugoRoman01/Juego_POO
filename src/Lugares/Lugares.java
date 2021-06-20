package Lugares;
import java.util.ArrayList;
import java.util.List;

import Personajes.General;

public class Lugares extends General{
	private List<String> adyacenciasLocalizaciones = new ArrayList<String>();


    public Lugares(String nombre,List<String> adyacenciasLocalizaciones){
        super(nombre);
        this.adyacenciasLocalizaciones = adyacenciasLocalizaciones;

    }
    
    public List<String> getAdyacencia(){
        return adyacenciasLocalizaciones;
    }

 

    public void imprimir(){
        System.out.println(this.getNombre()+ " esta conectado con: ");
        for(String elemento : adyacenciasLocalizaciones) {
			System.out.print(elemento + " ");
		}
		System.out.println();
	
    }
     



}
