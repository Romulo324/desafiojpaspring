package desafiospringjpa.springjpa.constrollers;

import desafiospringjpa.springjpa.models.ClinicaModel;
import desafiospringjpa.springjpa.services.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/clinica")
public class Clinicacontroller {
    @Autowired
    private ClinicaService service;

    @PostMapping(value = "/add")
    public ResponseEntity clinicaAdicionada(@RequestBody ClinicaModel clinica){
        service.adicionar(clinica);
        return new ResponseEntity(clinica, HttpStatus.CREATED);
    }
    @GetMapping(value = "/listar")
    public ResponseEntity listarPorClinicaId(){
        return new ResponseEntity(service.listar(), HttpStatus.OK);
    }
    @PutMapping(value = "/alterar/{clinicaId}")
    public ResponseEntity alterar(@PathVariable  Integer clinicaId , @RequestBody ClinicaModel clinica){
        service.atualizar(clinicaId, clinica);
        return new ResponseEntity(clinica, HttpStatus.OK);
    }
    @DeleteMapping(value = "/deletar/{clinicaId}")
    public ResponseEntity deletar(@PathVariable Integer clinicaId){
        service.remove(clinicaId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
