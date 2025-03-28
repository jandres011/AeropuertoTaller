package edu.unimagdalena.aereopuerto.DTO;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;
@Builder
@Getter
public class PasajeroDto {
    private Long id;
    private final String nombre;
    private  final String NID;
}
