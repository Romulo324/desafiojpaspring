package desafiospringjpa.springjpa.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_veterinario")
public class VeterinarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer veterinarioId;

    @Column(length = 50)
    String nome;

    @Column(length = 50)
    String idade;

    @Column(length = 50)
    String crm;

    @ManyToOne
    @JoinColumn(name = "clinica_Id")
    private ClinicaModel clinica;
}
