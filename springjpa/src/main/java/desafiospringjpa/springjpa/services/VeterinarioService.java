package desafiospringjpa.springjpa.services;

import desafiospringjpa.springjpa.models.PacienteModel;
import desafiospringjpa.springjpa.models.VeterinarioModel;
import desafiospringjpa.springjpa.repositories.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VeterinarioService {
    @Autowired
    public VeterinarioRepository veterinarioRepository;

    public void atualizar(Integer veterinarioId, VeterinarioModel veterinario) {
        Optional<VeterinarioModel> veterinarioIdPesquisar = acharPorId(veterinarioId);
        if (veterinarioIdPesquisar.isPresent()
        ){veterinarioRepository.findById(veterinarioId);
        }
    }
    public void adicionar(VeterinarioModel veterinarioQueSeraSalvo) {
        veterinarioRepository.save(veterinarioQueSeraSalvo);
    }

    public List<VeterinarioModel> listar() {
        return veterinarioRepository.findAll();
    }


    public Optional<VeterinarioModel> acharPorId(Integer veterinarioId){
        return veterinarioRepository.findById(veterinarioId);
    }

    public void remove(Integer veterinarioId) {
        Optional<VeterinarioModel> pacienteIdPesquisar = acharPorId(veterinarioId);
        if (pacienteIdPesquisar.isPresent()) {
            veterinarioRepository.deleteById(veterinarioId);
        }
    }
}
