package application.Banco.De.Sangue.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ObesosPorSexoDTO {

    private BigDecimal homens;
    private BigDecimal mulheres;
}