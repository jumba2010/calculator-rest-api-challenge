package calculator.api.rest.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
/**
 * @author Judiao Mbaua
 *
 */
public class OperationDTO {

@NotNull
private BigDecimal var1;

@NotNull
private BigDecimal var2;

@NotNull
private String operator;

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
