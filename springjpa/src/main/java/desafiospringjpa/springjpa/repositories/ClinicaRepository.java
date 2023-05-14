package desafiospringjpa.springjpa.repositories;

import desafiospringjpa.springjpa.models.ClinicaModel;
import org.hibernate.type.descriptor.java.InstantJavaType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicaRepository extends JpaRepository <ClinicaModel, Integer>{
}
