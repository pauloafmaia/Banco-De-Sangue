package application.Banco.De.Sangue.model;

import application.Banco.De.Sangue.dto.ResultadosDTO;
import jakarta.persistence.*;
import lombok.Data;

@NamedNativeQuery(
        name = "Candidatos.getQuantidadeDeCandidatosPorEstado",
        query = "SELECT count(*) as quantidadePorEstado, candidatos.estado FROM candidatos candidatos GROUP BY candidatos.estado",
        resultSetMapping = "getQuantidadeDeCandidatosPorEstado"
)

@SqlResultSetMapping(
        name = "getQuantidadeDeCandidatosPorEstado",
        classes = @ConstructorResult(targetClass = ResultadosDTO.class,
                columns = {
                        @ColumnResult(name = "quantidadePorEstado"),
                        @ColumnResult(name = "estado")
                }
        )
)

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