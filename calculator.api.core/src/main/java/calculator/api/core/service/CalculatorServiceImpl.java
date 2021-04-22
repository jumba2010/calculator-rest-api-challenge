package calculator.api.core.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import calculator.api.core.model.Operator;
import calculator.api.core.model.Operation;
import calculator.api.core.utils.OperatorFactory;

@Service(ICalculatorService.NAME)
public class CalculatorServiceImpl implements ICalculatorService {

	@Override
	public BigDecimal calculate(BigDecimal var1, BigDecimal var2, String operator) throws IllegalAccessException {
		Operation operation = OperatorFactory.getOperation(Operator.valueOf(operator))
				.orElseThrow(IllegalAccessException::new);

		return operation.apply(var1, var2);
	}

}
