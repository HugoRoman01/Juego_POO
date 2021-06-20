public class main{


    static String parametro;
    static int accion;
    static int op;
    static int nada;
    public int MovimientosTotales;
    public int CogerObjetosTotales;
    public int DarObjetosTotales;
    public int PeticionesTotales;




    public static void main(String[] args) {

        System.out.println("Bienvenido a nuestro juego");

        do{
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
                

                case 2:  //coger un objeto
                
                //mirar que haya objetos en la sala
                
                //en caso de que haya
                //imprimir los objetos disponibles

                //introducir el objeto que se quiere coger

                case 3:  //dejar un objeto


                case 4:  //dar un objeto

                
                case 5: //pedir objeto



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
    }


    


    

}

