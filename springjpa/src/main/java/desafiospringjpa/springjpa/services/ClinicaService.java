package desafiospringjpa.springjpa.services;

import desafiospringjpa.springjpa.models.ClinicaModel;
import desafiospringjpa.springjpa.repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClinicaService {

    @Autowired
    public ClinicaRepository clinicaReposytory;

    public void adicionar(ClinicaModel clinicaQueSeraSalva) {
        clinicaReposytory.save(clinicaQueSeraSalva);
    }

    public List<ClinicaModel> listar() {
        return clinicaReposytory.findAll();
    }

    public Optional<ClinicaModel> acharPorId(Integer clinicaId){
        return clinicaReposytory.findById(clinicaId);
    }

    public void atualizar(Integer clinicaId, ClinicaModel clinica) {
        Optional<ClinicaModel> clinicaIdPesquisar = acharPorId(clinicaId);
        if (clinicaIdPesquisar.isPresent()
        ){clinicaReposytory.save(clinica);
        }
    }

    public void remove(Integer clinicaId) {
        Optional<ClinicaModel> clinicaIdPesquisar = acharPorId(clinicaId);
        if (clinicaIdPesquisar.isPresent()) {
            clinicaReposytory.deleteById(clinicaId);
        }
    }
}
