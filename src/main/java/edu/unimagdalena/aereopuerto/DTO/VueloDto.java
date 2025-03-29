package edu.unimagdalena.aereopuerto.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Builder
@Getter


public class VueloDto {
    private final int idVuelo;
    private final String origen;
    private final String destino;

    public VueloDto(int idVuelo, String origen, String destino) {
        this.idVuelo = idVuelo;
        this.origen = origen;
        this.destino = destino;
    }
}
