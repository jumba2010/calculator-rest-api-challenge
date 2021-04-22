package calculator.api.core.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import calculator.api.core.model.Addition;
import calculator.api.core.model.Division;
import calculator.api.core.model.Operator;
import calculator.api.core.model.Operation;
import calculator.api.core.model.Multiplication;
import calculator.api.core.model.Subtraction;

public abstract class OperatorFactory {

	static final Map<Operator, Operation> operationMap = new HashMap<>();

	static {
		operationMap.put(Operator.ADD, new Addition());
		operationMap.put(Operator.SUBTRACT, new Subtraction());
		operationMap.put(Operator.MULTIPLY, new Multiplication());
		operationMap.put(Operator.DEVIDE, new Division());
	}

	private OperatorFactory() {
		super();
	}

	public static Optional<Operation> getOperation(Operator operator) {
		return Optional.ofNullable(operationMap.get(operator));
	}

}
