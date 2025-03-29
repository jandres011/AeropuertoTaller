package edu.unimagdalena.aereopuerto.DTO;

import edu.unimagdalena.aereopuerto.entities.Vuelo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
public class AereolineaDto {


    private Long idAereolinea;
    private final String nombreAereolinea;
    private final String vueloOrigen;
    private final String vueloDestino;

    public AereolineaDto(String nombreAereolinea, String vueloOrigen, String vueloDestino) {

        this.nombreAereolinea = nombreAereolinea;
        this.vueloOrigen = vueloOrigen;
        this.vueloDestino = vueloDestino;
    }


}
