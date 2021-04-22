package calculator.api.core.service;

import java.math.BigDecimal;

public interface ICalculatorService
{

public static final String NAME="calculator.api.core.service.ICalculatorService";

public abstract BigDecimal calculate(final BigDecimal var1, final BigDecimal var2,final String  operator)  throws IllegalAccessException;


}
