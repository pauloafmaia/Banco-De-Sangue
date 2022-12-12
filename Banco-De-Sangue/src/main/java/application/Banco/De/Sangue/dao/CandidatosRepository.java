package application.Banco.De.Sangue.dao;

import application.Banco.De.Sangue.dto.*;
import application.Banco.De.Sangue.model.Candidatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatosRepository extends JpaRepository<Candidatos, Long> {

    @Query(nativeQuery = true)
    List<ResultadosDTO> getQuantidadeDeCandidatosPorEstado();

    @Query(nativeQuery = true)
    List<AvgImcByAgeDTO> getAvgImcByAge();

    @Query(nativeQuery = true)
    List<ObesosPorSexoDTO> getObesosPorSexo();

    @Query(nativeQuery = true)
    List<MediaIdadeTipoSanguineoDTO> getMediaIdadeTipoSanguineo();

    @Query(nativeQuery = true)
    List<QuantidadeDoadoresTipoSanguineoDTO> getQuantidadeDoadoresTipoSanguineo();

}