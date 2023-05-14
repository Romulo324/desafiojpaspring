package desafiospringjpa.springjpa.repositories;

import desafiospringjpa.springjpa.models.VeterinarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeterinarioRepository extends JpaRepository<VeterinarioModel, Integer> {
}
