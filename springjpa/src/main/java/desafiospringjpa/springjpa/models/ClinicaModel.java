package desafiospringjpa.springjpa.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tb_clinica")
public class ClinicaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer ClinicaId;

    @Column(length = 50)
    private String nomeDaClinica;

    @Column(length = 50)
    private String cnpj;

}
