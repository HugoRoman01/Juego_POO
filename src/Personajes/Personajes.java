package Personajes;


import Objetos.*;
import Excepciones.Excepciones;

public class Personajes extends General{

    private String posicion;
    private final String posicion_final;

    private Objetos objeto;

    private boolean peticion = false;
    private String nombre_peticion;


    public Personajes(String nombre, String posicion, String posicion_final){
        super(nombre);               //A LA CLASE GENERAL
        this.posicion = posicion;
        this.posicion_final = posicion_final;
       
    }

    public String getPosicion(){
        return posicion;
    }

	public void setLocalizacion(String posicion) {
		this.posicion = posicion;
	}
    
    public String getPosicionFinal(){
        return posicion_final;
    }

    public Objetos getObjeto(){
        return objeto;
    }

    public void setObjeto(Objetos objetos){
        this.objeto = objetos;
    }

    public boolean isPeticion() {
		return peticion;
	}

	public void setPeticion(boolean peticion) {
		this.peticion = peticion;
	}

	public String getNombrePeticion(){
        return nombre_peticion;
    }

	public void setNombre_peticion(String nombre_peticion) {
		this.nombre_peticion = nombre_peticion;
	}

	public String toString() {
		if(this.objeto==null) {
			return(this.getNombre() + " esta en " + this.posicion + " y no tiene ningun objeto. Su objetivo es: " + this.posicion_final);
		}else {
			return(this.getNombre() + " esta en " + this.posicion + " y tiene el objeto: " + this.objeto.getNombre() + " Su objetivo es " + this.posicion_final);
		}
	}
    


    //ACCIONES

    public void nada()  { }

    public void moverse(String lugar){
        this.setLocalizacion(lugar);
    }

    public void dejar_objeto(Objetos objetos) throws RuntimeException{
        if(this.objeto ==null){
            throw new Excepciones(this.getNombre() + "No posee ningun objeto");
        }
        if(this.objeto != null){
            this.setObjeto(null);
            objetos.setLocalizacion(this.posicion);
        }

    }

    public void coger_objeto(Objetos objetos) throws RuntimeException{
       
        if(objetos.getlocalizacion().equals(this.posicion)){    //VER SI EL JUGADOR ESTA EN LA SALA DEL OBJETO
            if(this.objeto == null){
                this.setObjeto(objetos);
                objetos.setLocalizacion(this.getNombre());
            }
            if(this.objeto != null){
                throw new Excepciones(this.getNombre() + " ya posee un objeto");

            }

        }else{
            throw new Excepciones(this.getNombre()+" esta en una localizacion diferente ");
        }
    }

    public void pedir_objeto(Personajes NPC) throws RuntimeException{

        if(this.objeto==null){
            NPC.setPeticion(true);
            NPC.setNombre_peticion(this.getNombre());
        }
        if(this.objeto != null){
            throw new Excepciones( "El jugador ya tiene un objeto");
        }
        if(!this.getPosicion().equals(NPC.getPosicion())){
            throw new Excepciones("El jugador " + NPC.getNombre() + "esta en una sala diferente a " + this.getNombre());
        }
    }

    public void dar_objeto(Personajes NPC) throws RuntimeException{

        if(this.objeto == null){
            throw new Excepciones( this.getNombre() + " no posee ningun objeto");
        }
        System.out.println("Peticion " + this.getNombrePeticion());

        if(this.posicion.equals(NPC.getPosicion())){
            if(this.peticion == true && this.nombre_peticion.equals(NPC.getNombre())){
                NPC.setObjeto(this.objeto);
                this.objeto=null;
                this.peticion=false;
                this.nombre_peticion.isEmpty();

            }
        }
        if(!this.posicion.equals(NPC.getPosicion())) {
            throw new Excepciones("El personaje "+this.getNombre()+" esta en un lugar diferente a "+NPC.getNombre());
        }

    }
    

}


