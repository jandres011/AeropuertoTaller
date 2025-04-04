package edu.unimagdalena.aereopuerto.services;

import edu.unimagdalena.aereopuerto.DTO.ReservaDto;
import edu.unimagdalena.aereopuerto.entities.Pasajero;
import edu.unimagdalena.aereopuerto.entities.Pasaporte;
import edu.unimagdalena.aereopuerto.entities.Reserva;
import edu.unimagdalena.aereopuerto.entities.Vuelo;
import edu.unimagdalena.aereopuerto.repositories.PasajeroRepository;
import edu.unimagdalena.aereopuerto.repositories.PasaporteRepository;
import edu.unimagdalena.aereopuerto.repositories.ReservaRepository;
import edu.unimagdalena.aereopuerto.repositories.VueloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservaServiceTest {

    @Mock
    private PasajeroRepository pasajeroRepository;

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private VueloRepository vueloRepository;

    @Mock
    private PasaporteRepository pasaporteRepository;

    @InjectMocks
    private ReservaService reservaService;

    private Pasajero pasajero1, pasajero2, pasajero3;
    private Reserva reserva1, reserva2, reserva3;
    private Vuelo vuelo1, vuelo2, vuelo3, vuelo4, vuelo5;
    private Set<Reserva> reservasPasajero1 = new HashSet<>();
    private Set<Reserva> reservasPasajero2 = new HashSet<>();
    private Set<Reserva> reservasPasajero3 = new HashSet<>();
    private Set<Reserva> reservasVuelo1 = new HashSet<>();
    private Set<Reserva> reservasVuelo2 = new HashSet<>();
    private Set<Reserva> reservasVuelo3 = new HashSet<>();
    private Set<Reserva> reservasRecientes = new HashSet<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Pasaporte pasaporte1 = Pasaporte.builder().numero("B894A").build();
        Pasaporte pasaporte2 = Pasaporte.builder().numero("A578B").build();
        Pasaporte pasaporte3 = Pasaporte.builder().numero("A588C").build();

        pasajero1 = Pasajero.builder().NID("25A").nombre("Juan Antonio").pasaporte(pasaporte1).reservas(reservasPasajero1).build();
        pasajero2 = Pasajero.builder().NID("21B").nombre("Juan Andrés").pasaporte(pasaporte2).reservas(reservasPasajero2).build();
        pasajero3 = Pasajero.builder().NID("25C").nombre("Andrés Juan").pasaporte(pasaporte3).reservas(reservasPasajero3).build();

        vuelo1 = Vuelo.builder().origen("Santa Marta").destino("Bogotá").reservas(reservasVuelo1).build();
        vuelo2 = Vuelo.builder().origen("Santa Marta").destino("Medellín").reservas(reservasVuelo2).build();
        vuelo3 = Vuelo.builder().origen("Barranquilla").destino("Valledupar").reservas(reservasVuelo3).build();
        vuelo4 = Vuelo.builder().origen("Manizales").destino("Cucuta").build();
        vuelo5 = Vuelo.builder().origen("Venezia").destino("Madrid").build();

        reserva1 = Reserva.builder().pasajero(pasajero1).vuelo(vuelo1).build();
        reserva2 = Reserva.builder().pasajero(pasajero1).vuelo(vuelo2).build();
        reserva3 = Reserva.builder().pasajero(pasajero1).vuelo(vuelo3).codigoReserva(UUID.fromString("3be0e7b7-7c36-4f3d-b822-c3aba5bdf68a")).build();

        reservasPasajero1.add(reserva1);
        reservasPasajero1.add(reserva2);
        reservasPasajero1.add(reserva3);
        reservasPasajero2.add(reserva2);
        reservasPasajero3.add(reserva3);
        reservasVuelo1.add(reserva1);
        reservasVuelo2.add(reserva2);
        reservasVuelo2.add(reserva3);

    }

    @Test
    void countReservasByPasajeroNombre() {
        when(reservaRepository.countReservasByPasajeroNombre(pasajero1.getNombre())).thenReturn(3L);
        Long resultado = reservaService.countReservasByPasajeroNombre(pasajero1.getNombre());

        assertNotNull(resultado);
        assertEquals(pasajero1.getReservas().size(), resultado);
        verify(reservaRepository, times(1)).countReservasByPasajeroNombre(pasajero1.getNombre());
    }

    @Test
    void findReservaById() {
        when(reservaRepository.findReservaById(reserva1.getId())).thenReturn(Optional.of(reserva1));
        Optional<ReservaDto> resultado = reservaService.findReservaById(reserva1.getId());

        assertNotNull(resultado);
        assertEquals(reserva1.getId(), resultado.get().getId());
        verify(reservaRepository, times(1)).findReservaById(reserva1.getId());
    }

    @Test
    void findReservasByPasajeroId() {
        when(reservaRepository.findReservasByPasajeroId(pasajero1.getId())).thenReturn(new ArrayList<>(reservasPasajero1));
        List<ReservaDto> resultado = reservaService.findReservasByPasajeroId(pasajero1.getId());

        assertNotNull(resultado);
        assertEquals(reservasPasajero1.size(), resultado.size());
        assertTrue(resultado.containsAll(reservasPasajero1));
        verify(reservaRepository, times(1)).findReservasByPasajeroId(pasajero1.getId());
    }

    @Test
    void findReservaByCodigoReserva() {
        when(reservaRepository.findReservaByCodigoReserva(reserva3.getCodigoReserva())).thenReturn(reserva3);
        Optional<ReservaDto> resultado = reservaService.findReservaByCodigoReserva(reserva3.getCodigoReserva());

        assertNotNull(resultado);
        assertEquals(reserva3.getCodigoReserva(), resultado.get().getCodigoReserva());
        verify(reservaRepository, times(1)).findReservaByCodigoReserva(reserva3.getCodigoReserva());
    }

    @Test
    void findReservasByVueloId() {
        when(reservaRepository.findReservasByVueloId(vuelo1.getId())).thenReturn(new ArrayList<>(reservasVuelo1));
        List<Reserva> resultado = reservaService.findReservasByVueloId(vuelo1.getId());

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(reservaRepository, times(1)).findReservasByVueloId(vuelo1.getId());
    }

    @Test
    void findReservasByOrigenAndDestino() {
        when(reservaRepository.findReservasByOrigenAndDestino(vuelo1.getOrigen(),
                vuelo1.getDestino())).thenReturn(new ArrayList<>(reservasVuelo1));

        List<Reserva> resultado = reservaService.findReservasByOrigenAndDestino(vuelo1.getOrigen(), vuelo1.getDestino());
        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(reservaRepository, times(1)).findReservasByOrigenAndDestino(vuelo1.getOrigen(), vuelo1.getDestino());
    }

    @Test
    void findReservasByCiudadOrigen() {
        when(reservaRepository.findReservasByCiudadOrigen(vuelo1.getOrigen())).thenReturn(new ArrayList<>(reservasVuelo1));

        List<Reserva> resultado = reservaService.findReservasByCiudadOrigen(vuelo1.getOrigen());

        assertNotNull(resultado);
        assertEquals(reservasVuelo1.size(), resultado.size());
        assertTrue(resultado.containsAll(reservasVuelo1));
        verify(reservaRepository, times(1)).findReservasByCiudadOrigen(vuelo1.getOrigen());

    }

    @Test
    void findReservationsByFlightDestination() {
        when(reservaRepository.findReservationsByFlightDestination(vuelo1.getDestino())).thenReturn(new ArrayList<>(reservasVuelo1));

        List<Reserva> resultado = reservaService.findReservationsByFlightDestination(vuelo1.getDestino());

        assertNotNull(resultado);
        assertEquals(reservasVuelo1.size(), resultado.size());
        assertTrue(resultado.containsAll(reservasVuelo1));
        verify(reservaRepository, times(1)).findReservationsByFlightDestination(vuelo1.getDestino());
    }

    @Test
    void findReservasByCodigoVuelo() {
        when(reservaRepository.findReservasByCodigoVuelo(vuelo1.getId())).thenReturn(new ArrayList<>(reservasVuelo1));
        //está mal, los vuelos deben tener un codigo UUID asi como hicimos con las reservas
        List<Reserva> resultado = reservaService.findReservasByCodigoVuelo(vuelo1.getId());

        assertNotNull(resultado);
        assertEquals(reservasVuelo1.size(), resultado.size());
        assertTrue(resultado.containsAll(reservasVuelo1));
        verify(reservaRepository, times(1)).findReservasByCodigoVuelo(vuelo1.getId());
    }

    @Test
    void findRecentReservations() {
        when(reservaRepository.findRecentReservations()).thenReturn(new ArrayList<>(reservasRecientes));
        //No está implementado algo para saber que reservas son recientes, hay que arreglarlo.
        // De igual forma el test está bien jeje
        List<Reserva> resultado = reservaService.findRecentReservations();

        assertNotNull(resultado);
        assertEquals(reservasRecientes.size(), resultado.size());
        verify(reservaRepository, times(1)).findRecentReservations();
    }
}