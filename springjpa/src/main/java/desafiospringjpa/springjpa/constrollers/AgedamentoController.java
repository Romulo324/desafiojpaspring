package desafiospringjpa.springjpa.constrollers;

import desafiospringjpa.springjpa.models.AgendamentoModel;
import desafiospringjpa.springjpa.models.PacienteModel;
import desafiospringjpa.springjpa.models.VeterinarioModel;
import desafiospringjpa.springjpa.services.AgendamentoService;
import desafiospringjpa.springjpa.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/agendamento")
public class AgedamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping(value = "/listar")
    public ResponseEntity listarPoragendamentoId(){
        return new ResponseEntity(service.listar(), HttpStatus.OK);
    }
    @PostMapping(value = "/add")
    public ResponseEntity agendamentoAdicionado(@RequestBody AgendamentoModel agendamento,
                                                @RequestParam VeterinarioModel veterinario){
        service.adicionar(agendamento);
        return new ResponseEntity(agendamento, HttpStatus.CREATED);
    }
    @PutMapping(value = "/alterar/{agendamentoId}")
    public ResponseEntity alterar(@PathVariable Integer agendamentoId , @RequestBody AgendamentoModel agendamento){
        service.atualizar(agendamentoId, agendamento);
        return new ResponseEntity(agendamento, HttpStatus.OK);
    }
    @DeleteMapping(value = "/deletar/{agendamentoId}")
    public ResponseEntity deletar(@PathVariable Integer agendamentoId){
        service.remove(agendamentoId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
