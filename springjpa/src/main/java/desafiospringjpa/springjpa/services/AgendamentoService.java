package desafiospringjpa.springjpa.services;

import desafiospringjpa.springjpa.models.AgendamentoModel;
import desafiospringjpa.springjpa.models.ClinicaModel;
import desafiospringjpa.springjpa.repositories.AgendamentoRepository;
import desafiospringjpa.springjpa.repositories.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AgendamentoService {

    @Autowired
    public AgendamentoRepository agendamentoRepository;

    public void adicionar(AgendamentoModel agendamentoQueSeraSalvo) {
        agendamentoRepository.save(agendamentoQueSeraSalvo);
    }

    public List<AgendamentoModel> listar() {
        return agendamentoRepository.findAll();
    }

    public Optional<AgendamentoModel> acharPorId(Integer agendamentoId) {
        return agendamentoRepository.findById(agendamentoId);
    }

    public void atualizar(Integer agendamentoId, AgendamentoModel agendamento) {
        Optional<AgendamentoModel> agendamentoIdPesquisar = acharPorId(agendamentoId);
        if (agendamentoIdPesquisar.isPresent()
        ) {
            agendamentoRepository.save(agendamento);
        }
    }

    public void remove(Integer agendamentoId) {
        Optional<AgendamentoModel> agendamentoIdPesquisar = acharPorId(agendamentoId);
        if (agendamentoIdPesquisar.isPresent()) {
            agendamentoRepository.deleteById(agendamentoId);
        }
    }
}