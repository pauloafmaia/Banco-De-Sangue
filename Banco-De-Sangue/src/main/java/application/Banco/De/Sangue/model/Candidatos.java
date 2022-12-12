package application.Banco.De.Sangue.model;

import jakarta.persistence.*;
import lombok.Data;

@NamedNativeQuery(name = "Candidatos.getQuantidadeDeCandidatosPorEstado",
        query = "SELECT count(*), candidatos.estado FROM Candidatos candidatos GROUP BY candidatos.estado",
        resultSetMapping = "Mapping.ResultadosDTO")

@Data
@Entity
public class Candidatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;
    public String cpf;
    public String rg;

    @Column(name = "data_nasc")
    public String data_nasc;

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

    @Column(name = "telefone_fixo")
    public String telefone_fixo;

    public String celular;
    public String altura;
    public String peso;

    @Column(name = "tipo_sanguineo")
    public String tipo_sanguineo;

}
