package edu.unimagdalena.aereopuerto.services;

import edu.unimagdalena.aereopuerto.entities.Aereolinea;
import edu.unimagdalena.aereopuerto.entities.Vuelo;
import edu.unimagdalena.aereopuerto.repositories.*;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@Testcontainers
@Import(TestcontainersConfiguration.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class VueloServiceTest {

    @Mock
    private PasajeroRepository pasajeroRepository;

    @Mock
    private AereolineaRepository aereolineaRepository;

    @Mock
    private VueloRepository vueloRepository;

    @Mock
    private PasaporteRepository pasaporteRepository;

    @InjectMocks
    private VueloService vueloService;

    Aereolinea aereolinea1;
    Aereolinea aereolinea2;
    Set<Aereolinea> aereolineas1 = new HashSet<>();
    Set<Aereolinea> aereolineas2 = new HashSet<>();
    Vuelo vuelo1;
    Vuelo vuelo2;
    Vuelo vuelo3;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        aereolinea1 = Aereolinea.builder().nombre("Jetsmart").build();
        aereolinea2 = Aereolinea.builder().nombre("Wingo Air").build();
        aereolineas1.add(aereolinea1);
        aereolineas1.add(aereolinea2);
        aereolineas2.add(aereolinea2);
        aereolineaRepository.saveAll(aereolineas1);
        aereolineaRepository.saveAll(aereolineas2);


        vuelo1 = vueloRepository.save(Vuelo.builder().origen("Santa Marta").destino("Bogotá").numeroVuelo(UUID.fromString("7145205c-6d70-4558-a704-962c45d11c55")).aereolineas(aereolineas1).build());
        vuelo2 = vueloRepository.save(Vuelo.builder().origen("Bogotá").destino("Santa Marta").aereolineas(new HashSet<>()).build());
        vuelo3 = vueloRepository.save(Vuelo.builder().origen("Medellín").destino("Santa Marta").aereolineas(aereolineas2).build());
    }

    @Test
    void findByNumeroVuelo() {

    }

    @Test
    void findVueloByOrigen() {

    }

    @Test
    void findVuelosByDestino() {

    }

    @Test
    void findVuelosByOrigenAndDestino() {

    }

    @Test
    void findVuelosByReservasIsNotNull() {

    }

    @Test
    void countFlightsByDestination() {

    }

    @Test
    void findVuelosByDestinoContaining() {

    }

    @Test
    void findVuelosByOrigenContaining() {

    }

    @Test
    void findVuelosByDestinoOrderByOrigen() {

    }

    @Test
    void countVuelosByOrigen() {

    }
}

