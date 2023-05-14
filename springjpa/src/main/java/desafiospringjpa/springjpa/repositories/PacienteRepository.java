package desafiospringjpa.springjpa.repositories;

import desafiospringjpa.springjpa.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteModel, Integer> {
}
