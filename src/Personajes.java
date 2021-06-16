import java.util.ArrayList;
import java.util.List;


public class Personajes {

    private final String nombrePJ;
    private String posicion;
    private final String posicion_final;
   // private Objeto objeto;
   // private final Objeto objeto_final;


    public Personajes(String nombrePJ, String posicion, String posicion_final){

        this.nombrePJ = nombrePJ;
        this.posicion = posicion;
        this.posicion_final = posicion_final;
       
    }

    public String getNombrePJ(){
        return nombrePJ;
    }

    
    public String getPosicion(){
        return posicion;
    }

    
    public String getPosicionFinal(){
        return posicion_final;
    }
/*
    public Objeto getObjeto(){
        return objeto;
    }

    public Objeto getObjetoFinal(){
        return objeto_final;
    }
    */

    public void imprimir(){
        System.out.println(this.getNombrePJ()+ " esta en " + this.getPosicion() +
         " y su destino es " + this.getPosicionFinal()); 
	}

}


