package edu.unimagdalena.aereopuerto.services;

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

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

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

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Pasaporte pasaporte1 = Pasaporte.builder().numero("B894A").build();
        Pasaporte pasaporte2 = Pasaporte.builder().numero("A578B").build();
        Pasaporte pasaporte3 = Pasaporte.builder().numero("A588C").build();

        pasajero1 = Pasajero.builder().NID("25A").nombre("Juan Antonio").pasaporte(pasaporte1).reservas(reservasPasajero1).build();
        pasajero2 = Pasajero.builder().NID("21B").nombre("Juan Andrés").pasaporte(pasaporte2).reservas(reservasPasajero2).build();
        pasajero3 = Pasajero.builder().NID("25C").nombre("Andrés Juan").pasaporte(pasaporte3).reservas(reservasPasajero3).build();

        vuelo1 = Vuelo.builder().origen("Santa Marta").destino("Bogotá").build();
        vuelo2 = Vuelo.builder().origen("Santa Marta").destino("Medellín").build();
        vuelo3 = Vuelo.builder().origen("Barranquilla").destino("Valledupar").build();
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
    }

    @Test
    void countReservasByPasajeroNombre() {
        when(reservaRepository.countReservasByPasajeroNombre(pasajero1.getNombre())).thenReturn(3L);
        Long resultado = reservaService.countReservasByPasajeroNombre(pasajero1.getNombre());

        assertNotNull(resultado);
        assertEquals(pasajero1.getReservas().size(), resultado);
    }

@Test
    void findReservaById() {
    }

    @Test
    void findReservasByPasajeroId() {
    }

    @Test
    void findReservaByCodigoReserva() {
    }

    @Test
    void findReservasByVueloId() {
    }

    @Test
    void findReservasByOrigenAndDestino() {
    }

    @Test
    void findReservasByCiudadOrigen() {
    }

    @Test
    void findReservationsByFlightDestination() {
    }

    @Test
    void findReservasByCodigoVuelo() {
    }

    @Test
    void findRecentReservations() {
    }
}