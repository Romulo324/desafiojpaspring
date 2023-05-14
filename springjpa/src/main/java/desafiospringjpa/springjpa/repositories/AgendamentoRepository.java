package desafiospringjpa.springjpa.repositories;

import desafiospringjpa.springjpa.models.AgendamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Integer> {
}
