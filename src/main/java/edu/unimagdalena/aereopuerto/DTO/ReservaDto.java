package edu.unimagdalena.aereopuerto.DTO;

import java.util.UUID;

public class ReservaDto {
    private  Long id;
    private final String pasajeroNombre;
    private final String vueloOrigen;
    private final String vueloDestino;
    private  UUID codigoReserva;


    public ReservaDto(String pasajeroNombre, String vueloOrigen, String vueloDestino){

        this.pasajeroNombre = pasajeroNombre;
        this.vueloOrigen = vueloOrigen;
        this.vueloDestino = vueloDestino;

    }

    public Long getId() {
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
