import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;


public class Leer {
    private  List<Personajes> personajes = new ArrayList<Personajes>();
	private  List<Lugares> localizaciones = new ArrayList<Lugares>();
	private  List<Objetos> objetos = new ArrayList<Objetos>();
	//private  List<String> personajesLocIni = new ArrayList<String>();
	//private  List<String> locObjetos = new ArrayList<String>();
	//private  List<String> localizacionObjetivo = new ArrayList<String>();


    public Leer(){
        int entrada = 0;
        String linea;
        String linea2;
        ArrayList<String> lista_txt_inicial = new ArrayList<String>();//Lista para guardar el documento conla configuraci�n inicial
        ArrayList<String> lista_final = new ArrayList<String>();

        try{
             //LEEMOS EL FICHERO INICIAL    

            String inic_state = System.getProperty("user.dir") + "\\documentos\\inic_state.txt";//Path del documento inicial
            FileReader f = new FileReader(inic_state);
            BufferedReader b = new BufferedReader(f);

            //LEER EL FICHERO DE OBJETIVOS Y ENLISTARLOS

            String objetivos = System.getProperty("user.dir") + "\\documentos\\objetivos.txt";
            FileReader f2 = new FileReader(objetivos);
            BufferedReader b2 = new BufferedReader(f2);

            //CREAMOS LISTS FINAL
            while((linea2 = b2.readLine()) != null){
                lista_final.add(linea2);
            }

            //CREAMOS LISTS INICIAL
            while ((linea = b.readLine()) != null) {
                lista_txt_inicial.add(linea);           
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
                        crear_personajes(elemento,personajes,lista_final);
                    }else if(entrada == 2){
                        crear_objetos(elemento, objetos,lista_final);
                    }

                }

            }
        }catch(IOException e){
            e.printStackTrace();
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

    static void crear_personajes(String elemento, List<Personajes> personajes,List<String> lista_final){

        for(String elemento_final : lista_final ){

            String[] temp= elemento.replace(")"," ").trim().split("\\(");
            String nombrePJ = temp[0];
            String posicion = temp[1].trim(); 

            String[] temp2= elemento_final.replace(")"," ").trim().split("\\(");
            String posicion_final = temp2[1].trim();

            personajes.add(new Personajes(nombrePJ,posicion,posicion_final));

        }
    }

    static void crear_objetos(String elemento, List<Objetos> objetos,List<String> lista_final){

        for(String elemento_final : lista_final ){

            




        }


    }
}
    

