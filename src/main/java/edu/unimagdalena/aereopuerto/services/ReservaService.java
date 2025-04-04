package edu.unimagdalena.aereopuerto.services;


import edu.unimagdalena.aereopuerto.DTO.ReservaDto;
import edu.unimagdalena.aereopuerto.DTO.mapper.ReservarMapper;
import edu.unimagdalena.aereopuerto.entities.Reserva;
import edu.unimagdalena.aereopuerto.repositories.ReservaRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReservaService implements ReservaServiceInterface {
    private final ReservaRepository reservaRepository;
    private final ReservarMapper reservarMapper = Mappers.getMapper(ReservarMapper.class);

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Long countReservasByPasajeroNombre(String nombrePasajero) {
        return reservaRepository.countReservasByPasajeroNombre(nombrePasajero);
    }



    @Override
    public Optional<ReservaDto> findReservaById(Long id) {
        Optional<Reserva> reserva = reservaRepository.findReservaById(id);

        Optional<ReservaDto> reservaDto;
        reservaDto = reserva.map(reservarMapper::toDto);

        return reservaDto;
    }

    @Override
    public List<ReservaDto> findReservasByPasajeroId(Long pasajeroId) {

        List<Reserva> reservas = reservaRepository.findReservasByPasajeroId(pasajeroId);
        return reservas.stream().map(reservarMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ReservaDto> findReservaByCodigoReserva(UUID codigoReserva) {
        Optional<Reserva> reserva = Optional.ofNullable(reservaRepository.findReservaByCodigoReserva(codigoReserva));

        Optional<ReservaDto> reservaDto;
        reservaDto = reserva.map(reservarMapper::toDto);
        return reservaDto;
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
