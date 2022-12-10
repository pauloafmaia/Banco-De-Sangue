package application.Banco.De.Sangue.service;

import application.Banco.De.Sangue.dao.CandidatosRepository;
import application.Banco.De.Sangue.dto.CandidatosDTO;
import application.Banco.De.Sangue.exception.CandidatoNotFoundException;
import application.Banco.De.Sangue.model.Candidatos;
import application.Banco.De.Sangue.util.CopyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatosService {

    @Autowired
    private CandidatosRepository candidatosRepository;

    public CandidatosDTO getCandidatos() {
        List<Candidatos> candidatos = candidatosRepository.findAll();
        return (CandidatosDTO) candidatos;
    }

    public CandidatosDTO getCandidatosById(Long id) {
        Optional<Candidatos> candidatos = candidatosRepository.findById(id);
        return candidatos.map(c -> CopyProperties.copy(c, CandidatosDTO.class)).orElseThrow(() -> new CandidatoNotFoundException("Candidato não encontrado"));
    }

    public CandidatosDTO insert(Candidatos candidatos) {
        Assert.isNull(candidatos.getId(),"Não foi possível adicionar o candidato");
        return CopyProperties.copy(candidatosRepository.save(candidatos), CandidatosDTO.class);
    }

    public CandidatosDTO update(Candidatos candidatos, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o candidato");
        Optional<Candidatos> optional = candidatosRepository.findById(id);
        if(optional.isPresent()) {
            Candidatos db = optional.get();
            db.setId(candidatos.getId());
            System.out.println("Candidato id " + db.getId());
            candidatosRepository.save(db);
            return CopyProperties.copy(candidatosRepository.save(candidatos), CandidatosDTO.class);
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        candidatosRepository.deleteById(id);
    }
}
