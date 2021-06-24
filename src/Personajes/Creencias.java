package Personajes;


public class Creencias {
	private String localizacion;
	private String personaje;
	private String objetoPersonaje;
	private String objeto;
	
	public Creencias(String localizacion, String personaje, String objetoPersonaje, String objeto) {
		this.localizacion = localizacion;
		this.personaje = personaje;
		this.objetoPersonaje = objetoPersonaje;
		this.objeto = objeto;
	}
	
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public String getPersonaje() {
		return personaje;
	}
	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}
	public String getObjetoPersonaje() {
		return objetoPersonaje;
	}
	public void setObjetoPersonaje(String objetoPersonaje) {
		this.objetoPersonaje = objetoPersonaje;
	}
	public String getObjeto() {
		return objeto;
	}
	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}
	
}
