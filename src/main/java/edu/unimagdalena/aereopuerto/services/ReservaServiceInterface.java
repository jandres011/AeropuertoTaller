package edu.unimagdalena.aereopuerto.services;

import edu.unimagdalena.aereopuerto.DTO.ReservaDto;
import edu.unimagdalena.aereopuerto.entities.Reserva;
import edu.unimagdalena.aereopuerto.repositories.ReservaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReservaServiceInterface {

    Long countReservasByPasajeroNombre(String nombrePasajero);
    List<ReservaDto> findReservasByPasajeroId(Long pasajeroId);
    Optional<ReservaDto> findReservaById(Long id);
    Optional<ReservaDto> findReservaByCodigoReserva(UUID codigoReserva);
    List<Reserva> findReservasByVueloId(Long vueloId);

    public List<Reserva> findReservasByOrigenAndDestino(String origen, String destino);

    public List<Reserva> findReservasByCiudadOrigen(String ciudadOrigen);

    public List<Reserva> findReservationsByFlightDestination(String destino);

    public List<Reserva> findReservasByCodigoVuelo(Long id);

    public List<Reserva> findRecentReservations();

}


