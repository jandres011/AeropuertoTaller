package edu.unimagdalena.aereopuerto.DTO;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Getter
public class PasajeroDto {
    private Long id;
    private final String nombre;
    private  final String NID;

    public PasajeroDto(String nombre, String nid) {
        this.nombre = nombre;
        NID = nid;
    }
}
