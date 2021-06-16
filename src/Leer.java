import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Leer {
    private  List<String> personajes = new ArrayList<String>();
	private  List<Lugares> localizaciones = new ArrayList<Lugares>();
	private  List<String> objetos = new ArrayList<String>();

	private  List<String> personajesLocIni = new ArrayList<String>();

	private  List<String> locObjetos = new ArrayList<String>();
	private  List<String> localizacionObjetivo = new ArrayList<String>();


    public Leer(){
        int entrada = 0;
        String linea;
        ArrayList<String> lista_txt_inicial = new ArrayList<String>();//Lista para guardar el documento conla configuraci�n inicial

        //LEEMOS EL FICHERO INICIAL    
        try{

            String inic_state = System.getProperty("user.dir") + "\\documentos\\inic_state.txt";//Path del documento inicial
            FileReader f = new FileReader(inic_state);
            BufferedReader b = new BufferedReader(f);

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
                        establecer_localizaciones(elemento,localizaciones);

                    }else if(entrada == 1){

                    }else if(entrada == 2){

                    }

                }

            }
        }catch(IOException e){
            e.printStackTrace();
        }

    
    }

    static void establecer_localizaciones(String elemento, List<Lugares> localizaciones){
        
        ArrayList<String> lista_aux = new ArrayList<String>();


        String[] temp= elemento.replace(")"," ").trim().split("\\(");
        String lugar=temp[0];
        String[] adyacentes=temp[1].trim().split(",");
        for(String a:adyacentes) {lista_aux.add(a);}
        localizaciones.add(new Lugares(lugar,lista_aux));
    }
    
}
    

