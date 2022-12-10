package application.Banco.De.Sangue.controller;

import application.Banco.De.Sangue.dao.CandidatosRepository;
import application.Banco.De.Sangue.model.Candidatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CandidatosController {

    @Autowired
    private CandidatosRepository candidatosRepository;

    @GetMapping("/candidatos")
    public List<Candidatos> getCandidatos() {
        return candidatosRepository.findAll();
    }

    @GetMapping("/candidatos/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        return candidatosRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/candidatos")
    public boolean create (@RequestBody List<Candidatos> candidatos){
        candidatos.forEach(candidato -> candidatosRepository.save(candidato));
        return true;
    }

    @PutMapping("/candidatos/{id}")
    public ResponseEntity update (@PathVariable("id") long id, @RequestBody Candidatos candidatos){
        return candidatosRepository.findById(id)
                .map(record -> {
                    record.setNome(candidatos.getNome());
                    record.setCpf(candidatos.getCpf());
                    record.setRg(candidatos.getRg());
                    record.setData_nasc(candidatos.getData_nasc());
                    record.setSexo(candidatos.getSexo());
                    record.setMae(candidatos.getMae());
                    record.setPai(candidatos.getPai());
                    record.setEmail(candidatos.getEmail());
                    record.setCep(candidatos.getCep());
                    record.setEndereco(candidatos.getEndereco());
                    record.setNumero(candidatos.getNumero());
                    record.setBairro(candidatos.getBairro());
                    record.setCidade(candidatos.getCidade());
                    record.setEstado(candidatos.getEstado());
                    record.setTelefone_fixo(candidatos.getTelefone_fixo());
                    record.setCelular(candidatos.getCelular());
                    record.setAltura(candidatos.getAltura());
                    record.setPeso(candidatos.getPeso());
                    record.setTipo_sanguineo(candidatos.getTipo_sanguineo());
                    Candidatos updated = candidatosRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/candidatos/{id}")
    public ResponseEntity delete (@PathVariable long id){
        return candidatosRepository.findById(id)
                .map(record -> {
                    candidatosRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
