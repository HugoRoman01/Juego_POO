import Personajes.*;
import Objetos.*;

import java.util.List;

import Lectura.Leer;
import Lugares.*;


public class Controlador{


    static String parametro;
    static int accion;
    static int op;
    static int nada = 0;
    public static int MovimientosTotales;
    public static int CogerObjetosTotales;
    public static int DarObjetosTotales;
    public static int PeticionesTotales;
    public static int SoltarObjetosTotales;

    public static void main(String[] args) {

        System.out.println("Bienvenido a nuestro juego");


        do{

            for( Personajes personajes : Leer.personajes_list){

                if(personajes.getClass().equals(Jugador.class)){

                    System.out.println("TURNO JUGADOR");
                    
                    ImprimirDatosRonda(personajes,Leer.personajes_list,Leer.localizaciones_list,Leer.objetos_list);
                    imprimeMenu();

                    switch(op){
                
                        case 0:  //no hace nada
                                
                            System.out.println("NADA");
                            nada++;
                               if(nada==3) {System.out.println("FIN DEL JUEGO");}  //caso de que ningun personaje haga nada
                               continue;
        
        
                        case 1:  //moverse
        
                        //imprimir los lugares que se puede ir
                        
                        //imprimir otra vez los lugares
                        //introducir donde quieres ir
                        
                        MovimientosTotales++;
                        case 2:  //coger un objeto
                        
                        //mirar que haya objetos en la sala
                        
                        //en caso de que haya
                        //imprimir los objetos disponibles
        
                        //introducir el objeto que se quiere coger
                        CogerObjetosTotales++;
                        case 3:  //dejar un objeto
        
        
                        SoltarObjetosTotales++;
                        case 4:  //dar un objeto
        
                        DarObjetosTotales++;
                        case 5: //pedir objeto
        
        
                        PeticionesTotales++;
        
                        case 6:
        
                        System.out.println("Movimientos Realizados: " + MovimientosTotales + "\n" + "Objetos recogidos: "+ CogerObjetosTotales + "\n" +"Objetos soltados: " +SoltarObjetosTotales + "\n" +
                        "Objetos dados: " + DarObjetosTotales + "\n" + "Peticiones realizadas: "  + PeticionesTotales + "\n" + "\n");
        
                    }

                }

                //TRUNO NPC
                
            }

        }while(nada !=3);

    }

    public static void imprimeMenu(){
        
        System.out.println("0.Nada");
        System.out.println("1.Ir a");
        System.out.println("2.Coger un Objeto");
        System.out.println("3.Dejar un objeto");
        System.out.println("4.Dar un objeto");
        System.out.println("5.Pedir un objeto");
        System.out.println("6.Imprimir estadisticas");
    }

    public static void ImprimirDatosRonda(Personajes personajes, List<Personajes> personajes_list, List<Lugares> localizaciones_list, List<Objetos> objetos_list){

          //JUGADOR

        if(personajes.getObjeto() != null){
            System.out.println(personajes.getNombre() + personajes.getPosicion() + personajes.getObjeto());

        }else{
            System.out.println(personajes.getNombre() + personajes.getPosicion());

        }

        //Localizaciones
        System.out.println("LOCALIZACIONES");

        for(Lugares lugares : Leer.localizaciones_list){

            if(personajes.getPosicion().contains(lugares.getNombre())){
                for(String elemento : lugares.getAdyacencia()){
                    System.out.println(elemento);                    
                }
            }

        }

        //OBJETOS
         int objetos_sala = 0 ;

        for(Objetos objetos : Leer.objetos_list){
            if(objetos.getlocalizacion().equals(personajes.getPosicion())){
                objetos_sala++;
            }
        }

        if(objetos_sala != 0){
            System.out.println("OBJETOS");
            for(Objetos objetos : Leer.objetos_list){
                System.out.println(objetos.getNombre());
            }
        }else{
            System.out.println("No hay objetos en esta sala");
        }

        //PERSONAJES

        int personajes_contador = 0;

        for(Personajes p : Leer.personajes_list){
            if(p.getNombre() != personajes.getNombre()){
                personajes_contador++;
            }
        }

        if(personajes_contador !=0){
            System.out.println("PERSONAJES");
            for(Personajes p : Leer.personajes_list){
                if(p.getNombre() != personajes.getNombre()){
                    if(p.getObjeto() != null){
                        System.out.println(p.getNombre() + p.getObjeto());
                    }else{
                        System.out.println(p.getNombre());
                    }
                }
            }


        }else if(personajes_contador == 0){
            System.out.println("No hay nadie");

        }




    }  

    


    

}

