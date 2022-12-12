package application.Banco.De.Sangue.dao;

import application.Banco.De.Sangue.dto.ResultadosDTO;
import application.Banco.De.Sangue.model.Candidatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatosRepository extends JpaRepository<Candidatos, Long> {

    @Query(nativeQuery = true)
    ResultadosDTO getQuantidadeDeCandidatosPorEstado();

}
