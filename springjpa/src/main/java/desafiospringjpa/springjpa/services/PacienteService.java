package desafiospringjpa.springjpa.services;

import desafiospringjpa.springjpa.models.ClinicaModel;
import desafiospringjpa.springjpa.models.PacienteModel;
import desafiospringjpa.springjpa.repositories.ClinicaRepository;
import desafiospringjpa.springjpa.repositories.PacienteRepository;
import org.hibernate.boot.archive.scan.spi.PackageInfoArchiveEntryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    public PacienteRepository pacienteRepository;

    public void adicionar(PacienteModel PacienteQueSeraSalvo) {
        pacienteRepository.save(PacienteQueSeraSalvo);
    }

    public List<PacienteModel> listar() {
        return pacienteRepository.findAll();
    }

    public Optional<PacienteModel> acharPorId(Integer animalId){
        return pacienteRepository.findById(animalId);
    }

    public void remove(Integer animalId) {
        Optional<PacienteModel> pacienteIdPesquisar = acharPorId(animalId);
        if (pacienteIdPesquisar.isPresent()) {
            pacienteRepository.deleteById(animalId);
        }
    }

    public void atualizar(Integer animalId, PacienteModel paciente) {
        Optional<PacienteModel> clinicaIdPesquisar = acharPorId(animalId);
        if (clinicaIdPesquisar.isPresent()
        ){pacienteRepository.findById(animalId);
        }
    }
}
