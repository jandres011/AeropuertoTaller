package edu.unimagdalena.aereopuerto.DTO;

import java.util.UUID;

public class ReservaDto {
    private final UUID id;
    private final String pasajeroNombre;
    private final String vueloOrigen;
    private final String vueloDestino;
    private final UUID codigoReserva;


    public ReservaDto(UUID id, String pasajeroNombre, String vueloOrigen, String vueloDestino, UUID codigoReserva){
        this.id = id;
        this.pasajeroNombre = pasajeroNombre;
        this.vueloOrigen = vueloOrigen;
        this.vueloDestino = vueloDestino;
        this.codigoReserva = codigoReserva;
    }

    public UUID getId() {
        return id;
    }

    public String getPasajeroNombre() {
        return pasajeroNombre;
    }

    public String getVueloOrigen() {
        return vueloOrigen;
    }

    public String getVueloDestino() {
        return vueloDestino;
    }

    public UUID getCodigoReserva() {
        return codigoReserva;
    }

}
