package calculator.api.core.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import calculator.api.core.model.Operator;
import calculator.api.core.model.Operation;
import calculator.api.core.utils.OperatorFactory;
/**
 * @author Judiao Mbaua
 *
 */
@Service(ICalculatorService.NAME)
public class CalculatorServiceImpl implements ICalculatorService {

	@Override
	public BigDecimal calculate(BigDecimal var1, BigDecimal var2, Operator operator) throws IllegalAccessException {
		Operation operation = OperatorFactory.getOperation(operator)
				.orElseThrow(IllegalAccessException::new);

		return operation.apply(var1, var2);
	}

}
