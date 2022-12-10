package application.Banco.De.Sangue.dao;

import application.Banco.De.Sangue.model.Candidatos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatosRepository extends JpaRepository<Candidatos, Long> {
}
