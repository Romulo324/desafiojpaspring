package desafiospringjpa.springjpa.constrollers;

import desafiospringjpa.springjpa.models.ClinicaModel;
import desafiospringjpa.springjpa.models.PacienteModel;
import desafiospringjpa.springjpa.services.ClinicaService;
import desafiospringjpa.springjpa.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping(value = "/listar")
    public ResponseEntity listarPornumeroAtendimentoDoAnimal(){
        return new ResponseEntity(service.listar(), HttpStatus.OK);
    }
    @PostMapping(value = "/add")
    public ResponseEntity pacienteAdicionada(@RequestBody PacienteModel paciente){
        service.adicionar(paciente);
        return new ResponseEntity(paciente, HttpStatus.CREATED);
    }
    @PutMapping(value = "/alterar/{animalId}")
    public ResponseEntity alterar(@PathVariable Integer animalId , @RequestBody PacienteModel paciente){
        service.atualizar(animalId, paciente);
        return new ResponseEntity(paciente, HttpStatus.OK);
    }
    @DeleteMapping(value = "/deletar/{animalId}")
    public ResponseEntity deletar(@PathVariable Integer animalId){
        service.remove(animalId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
