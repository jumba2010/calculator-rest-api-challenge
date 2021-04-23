package calculator.api.core.dto;

import java.math.BigDecimal;
/**
 * @author Judiao Mbaua
 *
 */
public class OperationDTO  implements Cloneable{

private BigDecimal var1;

private BigDecimal var2;

private String operator;

private BigDecimal result;

public OperationDTO(BigDecimal var1, BigDecimal var2, String operator) {
	super();
	this.var1 = var1;
	this.var2 = var2;
	this.operator = operator;
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

public BigDecimal getResult() {
	return result;
}

public void setResult(BigDecimal result) {
	this.result = result;
}

}
