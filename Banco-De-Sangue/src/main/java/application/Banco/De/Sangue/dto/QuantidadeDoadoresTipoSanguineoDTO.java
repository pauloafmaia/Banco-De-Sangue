package application.Banco.De.Sangue.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"aNegativo", "aPositivo", "abNegativo", "abPositivo", "bNegativo", "bPositivo", "oNegativo", "oPositivo"})
public class QuantidadeDoadoresTipoSanguineoDTO {

    private Long aPositivo;
    private Long aNegativo;
    private Long bPositivo;
    private Long bNegativo;
    private Long abPositivo;
    private Long abNegativo;
    private Long oPositivo;
    private Long oNegativo;
}