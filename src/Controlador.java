import Personajes.*;
import Objetos.*;
import Lectura.Leer;
import Lugares.*;


import java.util.List;
import java.util.Scanner;



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

        Leer leer = new Leer();
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a nuestro juego \n");

        do{
            
            for( Personajes personajes : Leer.personajes_list){
                if(personajes.getClass().equals(Jugador.class)){

                    System.out.println("TURNO JUGADOR");
                    
                    ImprimirDatosRonda(personajes,Leer.personajes_list,Leer.localizaciones_list,Leer.objetos_list);
                    imprimeMenu();
                    op = sc.nextInt();

                    switch(op){
                
                        case 0:  //no hace nada
                                
                            System.out.println("NADA");
                            nada++;
                            if(nada==3) {System.out.println("FIN DEL JUEGO");}  //caso de que ningun personaje haga nada
                        break;

                        case 1:  //moverse

                        Scanner direccion = new Scanner(System.in);
                        int correcta=0;
                        System.out.println("MOVERSE");
                        ImprimirLocalizacionesDisponibles(personajes);
                        System.out.println("A donde quieres moverte?");
                        String movimiento = direccion.nextLine();

                        for(Lugares l : Leer.localizaciones_list){
                            if(personajes.getPosicion().equals(l.getNombre())){
                                do{
                                    for(String adyacentes : l.getAdyacencia()){
                                        adyacentes=adyacentes.trim();
                                        if(adyacentes.equals(movimiento)){
                                            correcta=1;
                                            personajes.moverse(adyacentes);
                                            System.out.println(personajes.toString());
                                        }
                                    }
                                }while(correcta==0);
                            }
                        }
                        
                        MovimientosTotales++;
                        break;
                    
                        case 2:  //coger un objeto
                        int correcta2 =0;
                        Scanner obtener = new Scanner(System.in);
                        System.out.println("COGER OBJETO");
                        ImprimirObjetosDisponibles(personajes);  
                        do{
                            System.out.println("Que objeto quieres coger?");   
                            System.out.println(personajes.getObjeto());
                            String cosa = obtener.nextLine(); 
                            cosa = cosa.trim();   
                            for(Objetos obj : Leer.objetos_list){
                                if(obj.getNombre().equals(cosa)){
                                    personajes.coger_objeto(obj);
                                    correcta2 = 1;
                                    for(Objetos o : Leer.objetos_list){
                                        o.imprimir();
                                    }
                                }
                            }        
                        }while (correcta2==0);
                        CogerObjetosTotales++;
                        break;

                        case 3:  //dejar un objeto

                        System.out.println("DEJAR OBJETO");
                        Objetos aux = personajes.getObjeto();
                        personajes.dejar_objeto(personajes.getObjeto());
                        System.out.println(personajes.getNombre() + " ha soltado el objeto " + aux.getNombre());

        
        
                        SoltarObjetosTotales++;
                        break;
                        
                        case 4:  //dar un objeto
                        Scanner dar = new Scanner(System.in);
                        int correcta3 = 0;
                        System.out.println("DAR OBJETO");
                        ImprimirPersonajesDisponibles(personajes);
                        do{
                            System.out.println("A quien quieres dar el objeto?");
                            String entregar = dar.nextLine();
                            entregar = entregar.trim();

                            for(Personajes p : Leer.personajes_list){
                                if(p.getPosicion().equals(personajes.getPosicion())){
                                    if(p.getNombre().equals(entregar)){
                                        personajes.dar_objeto(p);
                                        System.out.println(personajes.getNombre()+ " le da el objeto "+ p.getObjeto() +" a " + p.getNombre());
                                        correcta3 = 1; 
                                    }
                                }
                            }


                        }while(correcta3 ==0);
                        
                        DarObjetosTotales++;
                        break;

                        case 5: //pedir objeto

                        System.out.println("PEDIR OBJETO");
                        Scanner pedido = new Scanner(System.in);
                        int contador_pj = 0;
                        int correcta4=0;

                        for(Personajes p : Leer.personajes_list){
                            if(p.getPosicion().equals(personajes.getPosicion())){
                                contador_pj++;
                            }
                        }
                        if(contador_pj == 0 || contador_pj == 1){
                            System.out.println("No se puede pedir objeto ya que no hay nadie en la sala");
                        }
                        if(contador_pj !=0 && contador_pj != 1){
                            System.out.println("Personajes disponibles:");
                            for(Personajes p2: Leer.personajes_list){
                                if( p2.getNombre() != personajes.getNombre()){
                                    if(p2.getPosicion().equals(personajes.getPosicion())){
                                        System.out.println("\n" + p2.getNombre());
                                    }
                                }
                            }
                        }

                        System.out.println("--------------------------------------------");
                        do{
                            System.out.println("A quien le quieres pedir el objeto?");
                            String input = pedido.nextLine();
                                input = input.trim();
                                for(Personajes p4 : Leer.personajes_list){
                                    if( p4.getNombre().equals(input)){
                                        personajes.pedir_objeto(p4);
                                        System.out.println(personajes.getNombre() + " le pide du objeto a " + input);
                                        correcta4 =1;
                                        
                                    }
                            }

                        }while(correcta4==0);
                        
        
                        PeticionesTotales++;
        
                        case 6:
        
                        System.out.println("Movimientos Realizados: " + MovimientosTotales + "\n" + "Objetos recogidos: "+ CogerObjetosTotales + "\n" +"Objetos soltados: " +SoltarObjetosTotales + "\n" +
                        "Objetos dados: " + DarObjetosTotales + "\n" + "Peticiones realizadas: "  + PeticionesTotales + "\n" + "\n");
        
                    }

                }else{
                     //TURNO NPC
                     System.out.println("--------------------------------------------");
                     System.out.println("--------------------------------------------");
                     System.out.println("--------------------------------------------");
                     System.out.println("TURNO NPC");
                     ImprimirDatosRonda(personajes,Leer.personajes_list,Leer.localizaciones_list,Leer.objetos_list);
                    //AQUI DEBERIA ESTAR EL CODIGO DEL NPC GUIADO POR LAS CREENCIAS PERO NO SE HA REALIZADO 
                     System.out.println("--------------------------------------------");
                     System.out.println("--------------------------------------------");
                     System.out.println("--------------------------------------------");



                }
                
            }

        }while(nada !=3);

        sc.close();
    }

    public static void imprimeMenu(){
        System.out.println("\n\n----------------------------------------------------------");
        System.out.println("0.Nada");
        System.out.println("1.Ir a");
        System.out.println("2.Coger un Objeto");
        System.out.println("3.Dejar un objeto");
        System.out.println("4.Dar un objeto");
        System.out.println("5.Pedir un objeto");
        System.out.println("6.Imprimir estadisticas");
        System.out.println("Elije opcion:");
        System.out.println("----------------------------------------------------------");

    }

    //IMPRIMIR DATOS
    public static void ImprimirDatosRonda(Personajes personajes, List<Personajes> personajes_list, List<Lugares> localizaciones_list, List<Objetos> objetos_list){

          //JUGADOR
          System.out.println( "\n-------------------");
          System.out.println("JUGADOR ACTUAL");
          System.out.println( "-------------------");

        if(personajes.getObjeto() != null){
            System.out.println("\n"+personajes.getNombre() +" esta en " + personajes.getPosicion()+" y tiene " + personajes.getObjeto().getNombre());

        }else if (personajes.getObjeto() == null){
            System.out.println(personajes.getNombre() +" esta en "+ personajes.getPosicion());

        }

        //Localizaciones
        System.out.println( "\n-------------------");
        System.out.println( "LOCALIZACIONES");
        System.out.println( "-------------------");

        for(Lugares lugares : Leer.localizaciones_list){
                System.out.print("\n" + lugares.getNombre()+ " conectado con ");
                for(String elemento : lugares.getAdyacencia()){
                    System.out.print(elemento);                    
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
            System.out.println( "\n-------------------");
            System.out.println("OBJETOS");
            System.out.println( "-------------------");
            for(Objetos objetos : Leer.objetos_list){
                System.out.println(objetos.getNombre());
            }
        }else{
            System.out.println("No hay objetos"+ "\n");
        }

        //PERSONAJES

        int personajes_contador = 0;

        for(Personajes p : Leer.personajes_list){
            if(p.getNombre() != personajes.getNombre()){
                personajes_contador++;
            }
        }

        if(personajes_contador !=0){
            System.out.println( "\n-------------------");
            System.out.println( "PERSONAJES");
            System.out.println( "-------------------");
            for(Personajes p : Leer.personajes_list){
                if(p.getNombre() != personajes.getNombre()){
                    if(p.getObjeto() != null){
                        System.out.println(p.getNombre() +" esta en " + p.getPosicion()+" y tiene " + p.getObjeto().getNombre());
                    }else{
                        System.out.println(p.getNombre() +" esta en "+ p.getPosicion());
                    }
                }
            }


        }else if(personajes_contador == 0){
            System.out.println("No hay nadie"+ "\n");

        }




    }  
        //LOACLIZACIONES DISPONIBLES
    static void ImprimirLocalizacionesDisponibles(Personajes personajes){
        System.out.println("\n----------------------------------------------------------");

        for(Lugares l : Leer.localizaciones_list){
            if(personajes.getPosicion().contains(l.getNombre())){
                l.imprimir();
            }
        }

        System.out.println("----------------------------------------------------------");
    }

        //OBJETOS DISPONIBLES
    static void ImprimirObjetosDisponibles(Personajes personajes){
        System.out.println("\n----------------------------------------------------------");

        for(Objetos o: Leer.objetos_list){
            if(o.getlocalizacion().equals(personajes.getPosicion())){
                o.imprimir();
            }
        }

        System.out.println("----------------------------------------------------------");
    }
    
    //PERSONAJES DISPONIBLES
    static void ImprimirPersonajesDisponibles(Personajes personajes){
        int contador_personajes = 0;
        int temp = 0;
        System.out.println("\n----------------------------------------------------------");

        for(Personajes p : Leer.personajes_list){
            if(p.getPosicion().equals(personajes.getPosicion())){
                contador_personajes++;
            }
        }

        if(contador_personajes != 0){
            System.out.println("Personajes disponibles" + personajes.getNombre());
            for(Personajes pj : Leer.personajes_list){
                if(pj.getNombre() != personajes.getNombre()){
                    System.out.println(" " + pj.getNombre() );
                }
            }
        }else if(contador_personajes == 0 || contador_personajes == 1){
            System.out.println("No puedes dar ningun objeto ya que no hay nadie aparte de "+personajes.getNombre()+" en la localizacion actual");
            temp = 1;
        }

        if(temp == 1){
            op = 0;
        }

        System.out.println("----------------------------------------------------------");


    }
    


    

}

