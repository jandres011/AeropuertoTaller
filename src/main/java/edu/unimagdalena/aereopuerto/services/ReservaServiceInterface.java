package edu.unimagdalena.aereopuerto.services;

import edu.unimagdalena.aereopuerto.entities.Reserva;
import edu.unimagdalena.aereopuerto.repositories.ReservaRepository;

import java.util.List;
import java.util.UUID;

public interface ReservaServiceInterface {

    Long countReservasByPasajeroNombre(String nombrePasajero);
    List<Reserva> findReservasByPasajeroId(Long pasajeroId);
    Reserva findReservaById(Long id);
    Reserva findReservaByCodigoReserva(UUID codigoReserva);
    List<Reserva> findReservasByVueloId(Long vueloId);

    public List<Reserva> findReservasByOrigenAndDestino(String origen, String destino);

    public List<Reserva> findReservasByCiudadOrigen(String ciudadOrigen);

    public List<Reserva> findReservationsByFlightDestination(String destino);

    public List<Reserva> findReservasByCodigoVuelo(Long id);

    public List<Reserva> findRecentReservations();

}


