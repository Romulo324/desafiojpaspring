package desafiospringjpa.springjpa.constrollers;
import desafiospringjpa.springjpa.models.ClinicaModel;
import desafiospringjpa.springjpa.models.VeterinarioModel;
import desafiospringjpa.springjpa.services.ClinicaService;
import desafiospringjpa.springjpa.services.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/veterinario")
public class VeterinarioController {
    @Autowired
    private VeterinarioService service;
    @Autowired
    private ClinicaService serviceC;

    @GetMapping(value = "/listar")
    public ResponseEntity listarPorcrm(){
        return new ResponseEntity(service.listar(), HttpStatus.OK);
    }
    @PostMapping(value = "/add")
    public ResponseEntity pacienteAdicionada(@RequestBody VeterinarioModel veterinario,
                                             @RequestParam Integer clinicaId){
        Optional<ClinicaModel> clinica = serviceC.acharPorId(clinicaId);
        if (clinica.isPresent()
        ){
            veterinario.setClinica(clinica.get());
        }
        service.adicionar(veterinario);
        return new ResponseEntity(veterinario, HttpStatus.CREATED);
    }
    @PutMapping(value = "/alterar/{veterinarioId}")
    public ResponseEntity alterar(@PathVariable Integer veterinarioId , @RequestBody VeterinarioModel veterinario){
        service.atualizar(veterinarioId, veterinario);
        return new ResponseEntity(veterinarioId, HttpStatus.OK);
    }
    @DeleteMapping(value = "/deletar/{veterinarioId}")
    public ResponseEntity deletar(@PathVariable Integer veterinarioId){
        service.remove(veterinarioId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
