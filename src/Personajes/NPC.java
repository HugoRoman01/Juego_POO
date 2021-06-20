package Personajes;

import java.util.ArrayList;
import java.util.List;

public class NPC extends Personajes {

    public List<Creencias> creencias = new ArrayList<Creencias>();

    public NPC(String nombrePJ, String posicion, String posicion_final) {
        super(nombrePJ, posicion, posicion_final);
    }

}
