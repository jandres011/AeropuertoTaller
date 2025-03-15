package edu.unimagdalena.aereopuerto.services;


import edu.unimagdalena.aereopuerto.entities.Reserva;
import edu.unimagdalena.aereopuerto.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Long countReservasByPasajeroNombre(String nombrePasajero) {
        return reservaRepository.countReservasByPasajeroNombre(nombrePasajero);
    }

    public Reserva findReservaById(Long id) {
        return reservaRepository.findReservaById(id);
    }

    public List<Reserva> findReservasByPasajeroId(Long pasajeroId) {
        return reservaRepository.findReservasByPasajeroId(pasajeroId);
    }

    public Reserva findReservaByCodigoReserva(UUID codigoReserva) {
        return reservaRepository.findReservaByCodigoReserva(codigoReserva);
    }

    public List<Reserva> findReservasByVueloId(Long vueloId) {
        return reservaRepository.findReservasByVueloId(vueloId);
    }

    public List<Reserva> findReservasByOrigenAndDestino(String origen, String destino) {
        return reservaRepository.findReservasByOrigenAndDestino(origen, destino);
    }

    public List<Reserva> findReservasByCiudadOrigen(String ciudadOrigen){
        return reservaRepository.findReservasByCiudadOrigen(ciudadOrigen);
    }

    public List<Reserva> findReservationsByFlightDestination(String destino){
        return reservaRepository.findReservationsByFlightDestination(destino);
    }

    public List<Reserva> findReservasByCodigoVuelo(Long id){
        return reservaRepository.findReservasByCodigoVuelo(id);
    }

    public List<Reserva> findRecentReservations(){
        return reservaRepository.findRecentReservations();
    }

}
