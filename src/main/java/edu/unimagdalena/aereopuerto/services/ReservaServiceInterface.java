package edu.unimagdalena.aereopuerto.services;

import edu.unimagdalena.aereopuerto.entities.Reserva;
import edu.unimagdalena.aereopuerto.repositories.ReservaRepository;

import java.util.List;

public interface ReservaServiceInterface {

    ReservaService(ReservaRepository reservaRepository);
    List<Reserva> findReservasByPasajeroId(Long pasajeroId);

}
