package calculator.api.core.service;

import java.math.BigDecimal;

import calculator.api.core.model.Operator;

public interface ICalculatorService
{

public static final String NAME="calculator.api.core.service.ICalculatorService";

public abstract BigDecimal calculate(final BigDecimal var1, final BigDecimal var2,final Operator  operator)  throws IllegalAccessException;


}
