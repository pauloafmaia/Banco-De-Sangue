package application.Banco.De.Sangue.controller;

import application.Banco.De.Sangue.dao.CandidatosRepository;
import application.Banco.De.Sangue.dto.ResultadosDTO;
import application.Banco.De.Sangue.model.Candidatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidatos")
public class CandidatosController {

    @Autowired
    private CandidatosRepository candidatosRepository;

    @GetMapping()
    public List<Candidatos> getCandidatos() {
        return candidatosRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return candidatosRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    public boolean create (@RequestBody List<Candidatos> candidatos){
        candidatos.forEach(candidato -> candidatosRepository.save(candidato));
        return true;
    }

    @GetMapping("/estado")
    public List<ResultadosDTO> getQuantidadeDeCandidatosPorEstado() {
        return candidatosRepository.getQuantidadeDeCandidatosPorEstado();
    }
}
