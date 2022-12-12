package application.Banco.De.Sangue.model;

import application.Banco.De.Sangue.dto.*;
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

@NamedNativeQuery(
        name = "Candidatos.getAvgImcByAge",
        query = "select (case when DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 10 then '0 a 10' when DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 10 and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 20 then '11 a 20' when DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 20 and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 30 then '21 a 30' when DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 30 and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 40 then '31 a 40' when DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 40 and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 50 then '41 a 50' when DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 50 and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 60 then '51 a 60' when DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 60 and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 70 then '61 a 70' when DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 70 and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 80 then '71 a 80' when DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 80 and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 90 then '81 a 90' else '91 ou mais' end) as idade, cast(avg(peso / (altura * altura)) as decimal(4,2)) as imc from  candidatos group by 1 order by idade",
        resultSetMapping = "getAvgImcByAge"
)

@SqlResultSetMapping(
        name = "getAvgImcByAge",
        classes = @ConstructorResult(targetClass = AvgImcByAgeDTO.class,
                columns = {
                        @ColumnResult(name = "idade"),
                        @ColumnResult(name = "imc")
                }
        )
)

@NamedNativeQuery(
        name = "Candidatos.getObesosPorSexo",
        query = "select (select distinct count(id) from candidatos where peso / (altura * altura) > 30  and sexo = \"Masculino\") / count(id) * 100 as homens, (select distinct count(id) from  candidatos where peso / (altura * altura) > 30  and sexo = \"Feminino\") / count(id) * 100 as mulheres from candidatos",
        resultSetMapping = "getObesosPorSexo"
)

@SqlResultSetMapping(
        name = "getObesosPorSexo",
        classes = @ConstructorResult(targetClass = ObesosPorSexoDTO.class,
                columns = {
                        @ColumnResult(name = "homens"),
                        @ColumnResult(name = "mulheres")
                }
        )
)

@NamedNativeQuery(
        name = "Candidatos.getMediaIdadeTipoSanguineo",
        query = "select tipo_sanguineo, FLOOR(avg(DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0)) as idade from candidatos  group by tipo_sanguineo order by tipo_sanguineo",
        resultSetMapping = "getMediaIdadeTipoSanguineo"
)

@SqlResultSetMapping(
        name = "getMediaIdadeTipoSanguineo",
        classes = @ConstructorResult(targetClass = MediaIdadeTipoSanguineoDTO.class,
                columns = {
                        @ColumnResult(name = "idade"),
                        @ColumnResult(name = "tipo_sanguineo")
                }
        )
)

@NamedNativeQuery(
        name = "Candidatos.getQuantidadeDoadoresTipoSanguineo",
        query = "select (select count(id) from candidatos where tipo_sanguineo in ('A-','O-') and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 15 and  DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 70 and peso > 50 ) as aNegativo, (select count(id) from candidatos where tipo_sanguineo in ('A+','A-','O+','O-') and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 15 and  DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 70 and peso > 50 ) as aPositivo, (select count(id) from candidatos where tipo_sanguineo in ('A-','O-','B-','AB-') and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 15 and  DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 70 and peso > 50 ) as abNegativo, (select count(id) from candidatos where tipo_sanguineo in ('A+','A-','O+','O-', 'B+','B-','AB+','AB-') and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 15 and  DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 70 and peso > 50 ) as abPositivo,  (select count(id) from candidatos where tipo_sanguineo in ('B-','O-') and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 15 and  DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 70 and peso > 50 ) as bNegativo,(select count(id) from candidatos where tipo_sanguineo in ('B+','B-','O+','O-') and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 15 and  DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 70 and peso > 50 ) as bPositivo,  (select count(id) from candidatos where tipo_sanguineo in ('O-') and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 15 and  DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 70 and peso > 50 ) as oNegativo , (select count(id) from candidatos where tipo_sanguineo in ('O+','O-') and DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 > 15 and  DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),STR_TO_DATE(data_nasc, '%d/%m/%Y'))), '%Y') + 0 < 70 and peso > 50 ) as oPositivo from candidatos limit 1",
        resultSetMapping = "getQuantidadeDoadoresTipoSanguineo"
)

@SqlResultSetMapping(
        name = "getQuantidadeDoadoresTipoSanguineo",
        classes = @ConstructorResult(targetClass = QuantidadeDoadoresTipoSanguineoDTO.class,
                columns = {
                        @ColumnResult(name = "aPositivo"),
                        @ColumnResult(name = "aNegativo"),
                        @ColumnResult(name = "bPositivo"),
                        @ColumnResult(name = "bNegativo"),
                        @ColumnResult(name = "abPositivo"),
                        @ColumnResult(name = "abNegativo"),
                        @ColumnResult(name = "oPositivo"),
                        @ColumnResult(name = "oNegativo"),
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