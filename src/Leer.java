import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import Objetos.*;
import Personajes.*;

public class Leer {
    private static List<Personajes>personajes_list = new ArrayList<Personajes>();
	private static List<Lugares> localizaciones = new ArrayList<Lugares>();
	private static List<Objetos>objetos_list = new ArrayList<Objetos>();
    private static List<NPC> npc = new ArrayList<NPC>();


    public Leer(){
        int entrada = 0, contador = 0;
        String linea;
        String linea2;
        ArrayList<String> lista_txt_inicial = new ArrayList<String>();//Lista para guardar el documento conla configuraci�n inicial
        ArrayList<String> lista_final = new ArrayList<String>();

        
             //LEEMOS EL FICHERO INICIAL    
            try{
                String inic_state = System.getProperty("user.dir") + "\\documentos\\inic_state.txt";//Path del documento inicial
                FileReader f = new FileReader(inic_state);
                BufferedReader b = new BufferedReader(f);
                
                 //CREAMOS LISTS INICIAL
                 while ((linea = b.readLine()) != null) {
                    lista_txt_inicial.add(linea);           
                }
                b.close();
            }catch(Exception FileNotFoundFile){
                System.out.println("Error al leer el documento "+FileNotFoundFile.getMessage());

            }
           

            //LEER EL FICHERO DE OBJETIVOS Y ENLISTARLOS
            try {
                String objetivos = System.getProperty("user.dir") + "\\documentos\\objetivos.txt";
                FileReader f2 = new FileReader(objetivos);
                BufferedReader b2 = new BufferedReader(f2);

                //CREAMOS LISTS FINAL
                while((linea2 = b2.readLine()) != null){
                    lista_final.add(linea2);
                }
                b2.close();
            } catch (Exception FileNotFoundFile) {
                System.out.println("Error al leer el documento "+FileNotFoundFile.getMessage());

            }
            

            for(String elemento: lista_txt_inicial) {
                if(elemento.contains("<Localizaciones>")){
                    entrada = 0;

                }else if(elemento.contains("<Personajes>")){
                    entrada = 1;

                }else if(elemento.contains("<Objetos>")){
                    entrada = 2;

                }else{

                    if(entrada ==0){
                        crear_localizaciones(elemento,localizaciones);
                    }else if(entrada == 1){
                        crear_personajes(elemento,personajes_list,lista_final,contador,npc);
                        contador++;
                    }else if(entrada == 2){
                        crear_objetos(elemento,objetos_list,lista_final);
                    }

                }

            }
    }


    static void crear_localizaciones(String elemento, List<Lugares> localizaciones){
        
        ArrayList<String> lista_aux = new ArrayList<String>();

        String[] temp= elemento.replace(")"," ").trim().split("\\(");
        String lugar=temp[0];                                                                            
        String[] adyacentes=temp[1].trim().split(",");
        for(String a:adyacentes) {lista_aux.add(a);}
        localizaciones.add(new Lugares(lugar,lista_aux));
    }

    static void crear_personajes(String elemento, List<Personajes>personajes_list,List<String> lista_final,int contador,List<NPC> npc){

        for(String elemento_final : lista_final ){
            if(elemento_final.contains("<Localizacion Personajes>")){

                String[] temp= elemento.replace(")"," ").trim().split("\\(");
                String nombrePJ = temp[0];
                String posicion = temp[1].trim(); 
    
                String[] temp2= elemento_final.replace(")"," ").trim().split("\\(");
                String nombre_final = temp2[0].trim();
                String posicion_final = temp2[1].trim();

                if(nombrePJ.contains(nombre_final)){
                    if(contador==0){
                      personajes_list.add(new Jugador(nombrePJ,posicion,posicion_final));
                    
                    }else if(contador !=0){
                       personajes_list.add(new NPC(nombrePJ,posicion,posicion_final));
                        npc.add(new NPC(nombrePJ, posicion, posicion_final));
                    }

                }
    
    
            }

        }
    }

    static void crear_objetos(String elemento, List<Objetos>objetos_list,List<String> lista_final){

        for(String elemento_final : lista_final ){
            if(elemento_final.contains("<Posesion Objetos>")){
                String[] temp= elemento.replace(")"," ").trim().split("\\(");
                String nombreOBJ = temp[0];
                String localizacion = temp[1].trim();
                String[] temp2= elemento_final.replace(")"," ").trim().split("\\(");
                String nombreOBJ_final = temp2[0];
                String localizacion_final = temp2[1].trim();

                if(nombreOBJ.contains(nombreOBJ_final)){
                    if(localizacion_final.contains(nombreOBJ)){
                       objetos_list.add(new Objetos(nombreOBJ,localizacion,null)); //CUMPLIDO
                    }else{
                       objetos_list.add(new Objetos(nombreOBJ, localizacion, localizacion_final));
                        for(Personajes personajes :personajes_list){
                            for(Objetos objetos :objetos_list){
                                if(personajes.getNombre().equals(objetos.getlocalizacion())){
                                    personajes.setObjeto(objetos);
                                }

                            }

                        }
                    }
                }
    
            }

           

        }


    }


    


}
