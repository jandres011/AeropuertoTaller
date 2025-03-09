package edu.unimagdalena.aereopuerto.repositories;

import edu.unimagdalena.aereopuerto.entities.Aereolinea;
import edu.unimagdalena.aereopuerto.entities.Vuelo;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Testcontainers
@Import(TestcontainersConfiguration.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VueloRepositoryTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testPostgres")
            .withUsername("testUsername")
            .withPassword("testPassword");

    static {
        postgreSQLContainer.start();
    }

    Aereolinea aereolinea1;
    Aereolinea aereolinea2;
    Set<Aereolinea> aereolineas1 = new HashSet<>();
    Set<Aereolinea> aereolineas2 = new HashSet<>();
    Vuelo vuelo1;
    Vuelo vuelo2;
    Vuelo vuelo3;

    @Autowired
    AereolineaRepository aereolineaRepository;

    @Autowired
    VueloRepository vueloRepository;

    @BeforeEach
    void setUp() {


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

    @AfterEach
    void tearDown() {
        // Esto limpia los datos después de cada test.
        aereolineaRepository.deleteAll();
        vueloRepository.deleteAll();
    }

    @Test
    @Order(1)
    void findByNumeroVuelo() {
        Vuelo vueloTest = vueloRepository.findVueloByNumeroVuelo(UUID.fromString("7145205c-6d70-4558-a704-962c45d11c55"));
        Assertions.assertNotNull(vueloTest);
        Assertions.assertEquals(vuelo1.getNumeroVuelo(), vueloTest.getNumeroVuelo());
    }

    @Test
    @Order(2)
    void findVueloByOrigen() {
        List<Vuelo> vuelosTest = vueloRepository.findVuelosByOrigen("Santa Marta");
        Assertions.assertNotNull(vuelosTest);
        Assertions.assertEquals(1, vuelosTest.size());
    }

    @Test
    @Order(3)
    void findVuelosByDestino() {
        List<Vuelo> vuelosTest = vueloRepository.findVuelosByDestino("Santa Marta");
        Assertions.assertNotNull(vuelosTest);
        Assertions.assertEquals(2, vuelosTest.size());
    }

    @Test
    @Order(4)
    void findVuelosByOrigenAndDestino() {
        List<Vuelo> vuelosTest = vueloRepository.findVuelosByOrigenAndDestino("Santa Marta", "Bogotá");
        Assertions.assertNotNull(vuelosTest);
        Assertions.assertEquals(1, vuelosTest.size());
    }

    @Test
    @Order(5)
    void findVuelosByReservasIsNotNull() {
        List<Vuelo> vuelosTest = vueloRepository.findVuelosByReservasIsNotNull();
        Assertions.assertTrue(vuelosTest.isEmpty());
    }

    @Test
    @Order(6)
    void countFlightsByDestination() {
        Long countTest = vueloRepository.countFlightsByDestination("Santa Marta");
        Assertions.assertEquals(2L, countTest);
    }

    @Test
    @Order(7)
    void findVuelosByDestinoContaining() {
        List<Vuelo> vuelosTest = vueloRepository.findVuelosByDestinoContaining("otá");
        Assertions.assertFalse(vuelosTest.isEmpty());
        Assertions.assertEquals(1, vuelosTest.size());
    }

    @Test
    @Order(8)
    void findVuelosByOrigenContaining() {
        List<Vuelo> vuelosTest = vueloRepository.findVuelosByOrigenContaining("Santa");
        Assertions.assertFalse(vuelosTest.isEmpty());
        Assertions.assertEquals(1, vuelosTest.size());
    }

    @Test
    @Order(9)
    void findVuelosByDestinoOrderByOrigen() {
        List<Vuelo> vuelosTest = vueloRepository.findVuelosByDestinoOrderByOrigen("Santa Marta");
        Assertions.assertFalse(vuelosTest.isEmpty());
        Assertions.assertEquals(2, vuelosTest.size());
    }

    @Test
    @Order(10)
    void countVuelosByOrigen() {
        Long countTest = vueloRepository.countVuelosByOrigen("Santa Marta");
        Assertions.assertEquals(1L, countTest);
    }
}