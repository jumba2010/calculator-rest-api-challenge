package calculator.api.core.calculator.api.core;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import calculator.api.core.model.Addition;
import calculator.api.core.model.Division;
import calculator.api.core.model.Operator;
import calculator.api.core.utils.OperatorFactory;

/**
 * Plain unit tests (no Spring context, no broker) for the individual operation strategies.
 */
class OperationsTest {

	@Test
	void divisionRoundsHalfUpToTwoDecimals() {
		BigDecimal result = new Division().apply(new BigDecimal("10"), new BigDecimal("3"));
		Assertions.assertEquals(new BigDecimal("3.33"), result);
	}

	@Test
	void divisionByZeroIsRejectedWithAClearMessage() {
		ArithmeticException ex = Assertions.assertThrows(ArithmeticException.class,
				() -> new Division().apply(BigDecimal.ONE, BigDecimal.ZERO));
		Assertions.assertEquals("Division by zero is not allowed", ex.getMessage());
	}

	@Test
	void additionIsExactForDecimals() {
		BigDecimal result = new Addition().apply(new BigDecimal("0.1"), new BigDecimal("0.2"));
		Assertions.assertEquals(0, new BigDecimal("0.3").compareTo(result));
	}

	@Test
	void factoryProvidesAnOperationForEveryOperator() {
		for (Operator operator : Operator.values()) {
			Assertions.assertTrue(OperatorFactory.getOperation(operator).isPresent(),
					"missing operation for " + operator);
		}
	}
}
