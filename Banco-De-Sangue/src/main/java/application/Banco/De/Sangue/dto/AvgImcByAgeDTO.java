package application.Banco.De.Sangue.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AvgImcByAgeDTO {

    private BigDecimal imc;
    private String idade;
}