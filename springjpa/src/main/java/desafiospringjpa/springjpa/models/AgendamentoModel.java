package desafiospringjpa.springjpa.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity(name = "tb_agendamento")
public class AgendamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agendamentoId;

    @Column(length = 50)
    private LocalDate DataAgendamento;

    @ManyToOne
    @JoinColumn(name = "paciente_Id")
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name = "veterinario_Id")
    private VeterinarioModel veterinario;

}
