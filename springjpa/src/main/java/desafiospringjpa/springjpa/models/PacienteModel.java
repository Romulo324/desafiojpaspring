package desafiospringjpa.springjpa.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity(name = "tb_Paciente")
public class PacienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer AnimalId;
    @Column(length = 50)
    private String nomeDoAnimal;

    @Column(length = 50)
    private LocalDate dataNascimento;

    @Column(length = 50)
    private String numeroAtendimentoDoAnimal;

}
