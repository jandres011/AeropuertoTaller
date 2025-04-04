package edu.unimagdalena.aereopuerto.DTO.mapper;


import edu.unimagdalena.aereopuerto.entities.Reserva;
import edu.unimagdalena.aereopuerto.DTO.ReservaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservarMapper {



    @Mapping(source = "pasajero.nombre", target = "pasajeroNombre")
    @Mapping(source = "vuelo.origen", target = "vueloOrigen")
    @Mapping(source = "vuelo.destino", target = "vueloDestino")
    ReservaDto toDto(Reserva reserva);

    @Mapping(target = "pasajero", ignore = true)
    @Mapping(target = "vuelo", ignore = true)
    Reserva toEntity(ReservaDto reservaDto);

}
