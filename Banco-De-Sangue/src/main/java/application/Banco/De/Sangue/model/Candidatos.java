package application.Banco.De.Sangue.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Candidatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;
    public String cpf;
    public String rg;
    public String dataNascimento;
    public String sexo;
    public String mae;
    public String pai;
    public String email;
    public String cep;
    public String endereco;
    public String numero;
    public String bairro;
    public String cidade;
    public String estado;
    public String telefoneFixo;
    public String celular;
    public String altura;
    public String peso;
    public String tipoSanguineo;
}
