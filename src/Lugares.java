import java.util.ArrayList;
import java.util.List;

public class Lugares {
	private List<String> adyacenciasLocalizaciones = new ArrayList<String>();
    private String lugar;


    public Lugares(String lugar,List<String> adyacenciasLocalizaciones){
        this.lugar = lugar;
        this.adyacenciasLocalizaciones = adyacenciasLocalizaciones;

    }
    
    public List<String> getAdyacencia(){
        return adyacenciasLocalizaciones;
    }

    public String getLugar(){
        return lugar;
    }

    public void imprimir(){
        System.out.println(this.getLugar()+ " esta conectado con: ");
        for(String elemento : adyacenciasLocalizaciones) {
			System.out.print(elemento + " ");
		}
		System.out.println();
	
    }
     



}
