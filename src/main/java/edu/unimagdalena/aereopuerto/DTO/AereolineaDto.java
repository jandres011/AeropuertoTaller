package edu.unimagdalena.aereopuerto.DTO;

import edu.unimagdalena.aereopuerto.entities.Vuelo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Builder
@Getter
public class AereolineaDto {



    private final String nombreAereolinea;
    private final ArrayList<Vuelo> Vuelo;

    public AereolineaDto( String nombreAereolinea, ArrayList<Vuelo> vuelo) {

        this.nombreAereolinea = nombreAereolinea;
        Vuelo = vuelo;
    }

    public String getNombreAereolinea() {
        return nombreAereolinea;
    }

    public ArrayList<Vuelo> getVuelo(){
        return Vuelo;
    }
}
