package edu.unimagdalena.aereopuerto.services;

import edu.unimagdalena.aereopuerto.entities.Aereolinea;
import edu.unimagdalena.aereopuerto.repositories.AereolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerolineaService {
    private final AereolineaRepository aereolineaRepository;


    @Autowired
    public AerolineaService(AereolineaRepository aereolineaRepository) {
        this.aereolineaRepository = aereolineaRepository;
    }

    List<Aereolinea> findAereolineaByNombreStartingWith(String letra) {
        return aereolineaRepository.findAereolineaByNombreStartingWith(letra);
    }

    public Aereolinea findAereolineaByIdAereolinea(Long idAereolinea) {


        return aereolineaRepository.findAereolineaByIdAereolinea(idAereolinea);
    }

    public Aereolinea findAereolineaByNombre(String nombre) {
        return aereolineaRepository.findAereolineaByNombre(nombre);
    }

    public List<Aereolinea> findAereolineaByIdAereolineaIn (List<Long> idsAereolinea) {
        return aereolineaRepository.findAereolineaByIdAereolineaIn(idsAereolinea);
    }

    public List<Aereolinea> findAereolineasByNombreLike (String nombres) {
        return aereolineaRepository.findAereolineasByNombreLike(nombres);
    }






}
