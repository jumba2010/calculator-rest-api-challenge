package calculator.api.core.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
/**
 * @author Judiao Mbaua
 *
 */
public class OperationDTO {

@NotNull(message = "O valor de var1 é Obrigatório")
private BigDecimal var1;

@NotNull(message = "O valor de var2 é Obrigatório")
private BigDecimal var2;

@NotNull(message = "O valor do operador é Obrigatório")
private String operator;

private BigDecimal result;

public OperationDTO(){
	super();
}

public BigDecimal getResult() {
	return result;
}

public void setResult(BigDecimal result) {
	this.result = result;
}

public BigDecimal getVar1() {
	return var1;
}

public void setVar1(BigDecimal var1) {
	this.var1 = var1;
}

public BigDecimal getVar2() {
	return var2;
}

public void setVar2(BigDecimal var2) {
	this.var2 = var2;
}

public String getOperator() {
	return operator;
}

public void setOperator(String operator) {
	this.operator = operator;
}


}
