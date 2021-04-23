package calculator.api.rest.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class Operation {

@NotNull
private BigDecimal var1;

@NotNull
private BigDecimal var2;

@NotNull
private String operator;


}
